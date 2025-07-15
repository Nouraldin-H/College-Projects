/**
 * Main program.
 * @author {Nouraldin Hassan}
*/
const fs = require('fs');
const csvParser = require('csv-parser');
const readline = require('readline');
const Record = require('./record');

const records = [];
const filePath = './keystone-throughput-and-capacity.csv';

/**
 * Read and display records from a CSV file.
 * Uses File-IO, exception handling, and a simple data structure.
 */
fs.createReadStream(filePath)
    .pipe(csvParser())
    .on('data', (row) => {
        try {
            console.log('Parsed Row:', row);
            /**
             * Initialize a new Record object with data from the CSV file row.
             * @type {Record}
             */
            const record = new Record(row.Date, row.Month, row.Year, row.Company, row.Pipeline, row.KeyPoint, row.Latitude, row.Longitude, row.FlowDirection, row.TradeType, row.Product, row.Throughput, row.CommittedVolumes, row.UncommittedVolumes, row.NameplateCapacity, row.AvailableCapacity, row.VarianceReason);
            records.push(record);
        } catch (error) {
            console.error('Error parsing row:', error);
        }
    })
    .on('end', () => {
        console.log('CSV file successfully processed');
        promptUser();
    })
    .on('error', (error) => {
        console.error('Error reading file:', error);
    });

/**
 * This function prompts the user for input.
 */
function promptUser() {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    rl.question('Do you want to generate the table-like formatted records? (Y/N): ', (answer) => {
        if (answer.toLowerCase() === 'y') {
            displayRecords();
            console.log('Nouraldin Hassan');
        } else {
            console.log('Table-like formatted records generation skipped.');
            console.log('Nouraldin Hassan');
        }
        rl.close();
    });
}

/**
 * This function displays table-like formatted records.
 */
function displayRecords() {
    console.log('Records:');
    console.log('Date | Month | Year | Company | Pipeline | Key Point | Latitude | Longitude | Flow Direction | Trade Type | Product | Throughput | Committed Volumes | Uncommitted Volumes | Nameplate Capacity | Available Capacity | Variance Reason');
    console.log('-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------');
    records.forEach(record => {
        console.log(`${record.date} | ${record.month} | ${record.year} | ${record.company} | ${record.pipeline} | ${record.keyPoint} | ${record.latitude} | ${record.longitude} | ${record.flowDirection} | ${record.tradeType} | ${record.product} | ${record.throughput} | ${record.committedVolumes} | ${record.uncommittedVolumes} | ${record.nameplateCapacity} | ${record.availableCapacity} | ${record.varianceReason}`);
    });
}