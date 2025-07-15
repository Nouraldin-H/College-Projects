/**
 * @author {Nouraldin Hassan}
 */
const assert = require('assert');
const Record = require('./record');

const sampleData = {
    Date: '2024-09-22',
    Month: 'September',
    Year: '2024',
    Company: 'Example Company',
    Pipeline: 'Example Pipeline',
    'Key Point': 'Example Key Point',
    Latitude: '45.4215',
    Longitude: '-75.6972',
    'Flow Direction': 'North',
    'Trade Type': 'Export',
    Product: 'Oil',
    Throughput: '1000',
    'Committed Volumes': '500',
    'Uncommitted Volumes': '500',
    'Nameplate Capacity': '2000',
    'Available Capacity': '1000',
    'Variance Reason': 'Maintenance'
};

const record = new Record(
    sampleData.Date,
    sampleData.Month,
    sampleData.Year,
    sampleData.Company,
    sampleData.Pipeline,
    sampleData['Key Point'],
    sampleData.Latitude,
    sampleData.Longitude,
    sampleData['Flow Direction'],
    sampleData['Trade Type'],
    sampleData.Product,
    sampleData.Throughput,
    sampleData['Committed Volumes'],
    sampleData['Uncommitted Volumes'],
    sampleData['Nameplate Capacity'],
    sampleData['Available Capacity'],
    sampleData['Variance Reason']
);

assert.strictEqual(record.date, sampleData.Date, 'Date should match');
assert.strictEqual(record.month, sampleData.Month, 'Month should match');
assert.strictEqual(record.year, sampleData.Year, 'Year should match');
assert.strictEqual(record.company, sampleData.Company, 'Company should match');
assert.strictEqual(record.pipeline, sampleData.Pipeline, 'Pipeline should match');
assert.strictEqual(record.keyPoint, sampleData['Key Point'], 'Key Point should match');
assert.strictEqual(record.latitude, sampleData.Latitude, 'Latitude should match');
assert.strictEqual(record.longitude, sampleData.Longitude, 'Longitude should match');
assert.strictEqual(record.flowDirection, sampleData['Flow Direction'], 'Flow Direction should match');
assert.strictEqual(record.tradeType, sampleData['Trade Type'], 'Trade Type should match');
assert.strictEqual(record.product, sampleData.Product, 'Product should match');
assert.strictEqual(record.throughput, sampleData.Throughput, 'Throughput should match');
assert.strictEqual(record.committedVolumes, sampleData['Committed Volumes'], 'Committed Volumes should match');
assert.strictEqual(record.uncommittedVolumes, sampleData['Uncommitted Volumes'], 'Uncommitted Volumes should match');
assert.strictEqual(record.nameplateCapacity, sampleData['Nameplate Capacity'], 'Nameplate Capacity should match');
assert.strictEqual(record.availableCapacity, sampleData['Available Capacity'], 'Available Capacity should match');
assert.strictEqual(record.varianceReason, sampleData['Variance Reason'], 'Variance Reason should match');

console.log('All tests performed!');