/**
 * This class handles files and some record logic.
 * @author {Nouraldin Hassan}
 */
const fs = require('fs');
const csvParser = require('csv-parser');
const Record = require('../service/record');

const filePath = './program/data/keystone-throughput-and-capacity.csv';
const records = [];

/**
 * Reads and display records from a CSV file.
 * Uses File-IO, exception handling, and a simple data structure.
 * @param {function} callback - The callback function that processes the loaded records.
 * @param {number} [limit=100] - The limit on the number of records to process. Defaults to 100.
 */
function loadRecords(callback, limit = 100) {
    fs.createReadStream(filePath)
        .pipe(csvParser())
        .on('data', (row) => {
            try {
                //console.log(row.Date);
                /**
                 * Initialize a new Record object with data from the CSV file row.
                 * @type {Record}
                 */
                const record = new Record(row.Date, row.Month, row.Year, row.Company, row.Pipeline, row['Key Point'], row.Latitude, row.Longitude, row['Direction of Flow'], row['Trade Type'], row.Product, row['Throughput (1000 m3/d)'], row['Committed Volumes (1000 m3/d)'], row['Uncommitted Volumes (1000 m3/d)'], row['Nameplate Capacity (1000 m3/d)'], row['Available Capacity (1000 m3/d)'], row['Reason For Variance']);
                records.push(record);
            } catch (error) {
                console.error('Error parsing row:', error);
            }
        })
        .on('end', () => {
            callback(records.slice(0, Math.max(2, Math.min(limit, 1000)))); // Limit to between 2 and 1000 records
        })
        .on('error', (error) => {
            console.error('Error reading file:', error);
        });
}
/**
 * Saves records to a CSV file.
 * Uses File-IO and a simple data structure.
 * @param {any} records - The records to save.
 * @param {String} outputFilePath - The file path to output the records to.
 */
function saveRecords(records, outputFilePath) {
    const headers = 'Date,Month,Year,Company,Pipeline,Key Point,Latitude,Longitude,Direction Of Flow,Trade Type,Product,Throughput (1000 m3/d),Committed Volumes (1000 m3/d),Uncommitted Volumes (1000 m3/d),Nameplate Capacity (1000 m3/d),Available Capacity (1000 m3/d),Reason For Variance\n';
    const csvData = records.map(record => {
        return `${record.date},${record.month},${record.year},${record.company},${record.pipeline},${record.keyPoint},${record.latitude},${record.longitude},${record.flowDirection},${record.tradeType},${record.product},${record.throughput},${record.committedVolumes},${record.uncommittedVolumes},${record.nameplateCapacity},${record.availableCapacity},${record.varianceReason}`;
    }).join('\n');

    fs.writeFileSync(outputFilePath, headers + csvData, 'utf8');
}

module.exports = { loadRecords, saveRecords, filePath };