/**
 * @author {Nouraldin Hassan}
 */
const assert = require('assert');
const { initializeRecords, getRecords } = require('../service/record-service');

initializeRecords(() => {
    const records = getRecords();
    const cutoffLimit = 22;
    const limitedRecords = records.slice(0, cutoffLimit);

    assert(records.length > 0, 'Records should be loaded');
    assert.strictEqual(limitedRecords.length, cutoffLimit, `Expected ${cutoffLimit} records to be displayed.`);
    
    for (let i = 0; i < limitedRecords.length; i++) {
        console.log(limitedRecords[i]);
        if ((i + 1) % 10 === 0) {
            console.log('\nProgram by Nouraldin Hassan\n'); 
        }
    }

    console.log('All tests performed!');
});