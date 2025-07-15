/**
 * @author {Nouraldin Hassan}
*/
const { loadRecords, saveRecords } = require('../data/file-handler');
const Record = require('./record');
/**
 * Initializes an empty array for storing records.
 */
let records = [];
/**
 * Initializes records by storing them in the records array.
 * @param {function} callback - The callback function to execute for record loading.
 */
function initializeRecords(callback) {
    loadRecords((loadedRecords) => {
        records = loadedRecords;
        callback();
    });
}
/**
 * Reloads records by performing an initialization callback.
 * @param {function} callback - The callback function to execute after record loading.
 */
function reloadRecords(callback) {
    initializeRecords(callback);
}
/**
 * Provides record persistence though performing a record save.
 * @param {String} outputFilePath - The file path to output the records to.
 */
function persistRecords(outputFilePath) {
    saveRecords(records, outputFilePath);
}
/**
 * Fetches records
 */
function getRecords() {
    return records;
}
/**
 * Fetches records by index
 * @param {String} index - The index of the record.
 */
function getRecord(index) {
    return records[index];
}
/**
 * Adds a new record.
 * @param {any} record - The record to add.
 */
function addRecord(record) {
    records.push(record);
}
/**
 * Updates a record.
 * @param {any} index - The index of the record.
 * @param {any} updatedRecord - The updated record.
 */
function updateRecord(index, updatedRecord) {
    records[index] = updatedRecord;
}
/**
 * Deletes a record.
 * @param {any} index - The index of the record to remove.
 */
function deleteRecord(index) {
    records.splice(index, 1);
}

module.exports = { initializeRecords, reloadRecords, persistRecords, getRecords, getRecord, addRecord, updateRecord, deleteRecord, records };