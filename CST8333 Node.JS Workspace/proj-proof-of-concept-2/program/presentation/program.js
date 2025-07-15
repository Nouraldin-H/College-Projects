/**
 * Main program.
 * @author {Nouraldin Hassan}
*/
const fs = require('fs');
const csvParser = require('csv-parser');
const readline = require('readline');
const { initializeRecords, reloadRecords, persistRecords, getRecords, getRecord, addRecord, updateRecord, deleteRecord } = require('../service/record-service');
const Record = require('../service/record');
const { filePath, loadRecords } = require('../data/file-handler');
/**
 * Prompts the user for input.
 * @function
 */
function promptUser() {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    rl.question('Choose an option (note that you may need to repeat an option if nothing happens):\n1. Reload Data\n2. Save Data\n3. Display Records\n4. Add Record\n5. Edit Record\n6. Delete Record\n7. Exit\n\n', (answer) => {
        switch (answer) {
            case '1':
                reloadRecords(() => {
                    clearConsole(true);
                    rl.close();
                    promptUser();
                });
                break;
            case '2':
                clearConsole(true);
                persistRecords('./program/data/output.csv');
                console.log('Data saved.');
                rl.close();
                promptUser();
                break;
            case '3':
                clearConsole(true);
                giveDisplayOptions(rl);
                //displayRecords();
                //rl.close();
                //promptUser();
                break;
            case '4':
                addNewRecord(rl);
                break;
            case '5':
                editRecord(rl);
                break;
            case '6':
                deleteRecordPrompt(rl);
                break;
            case '7':
                rl.close();
                //console.log('Program by Nouraldin Hassan');
                process.exit();
                break;
            default:
                console.log('Invalid option.');
                rl.close();
                promptUser();
                break;
        }
    });
}
/**
 * Provides display options to the user. Used exclusively to provide more options for displaying records.
 * @param {readline.Interface} rl - The readline interface input.
 */
function giveDisplayOptions(rl) {
    clearConsole(true);
    rl.question('Choose a display option:\n1. Single: Display a single record\n2. Multiple: Display multiple records (options available)\n\n', (displayAnswer) => {
        switch (displayAnswer) {
            case '1':
                displaySingleRecord(rl);
                break;
            case '2':
                displayRecords(rl);
                break;
            default:
                console.log('Invalid display option.');
                rl.close();
                promptUser();
                break;
        }
    });
}
/**
 * Displays a record to the user.
 * @param {readline.Interface} rl - The readline interface input.
 */
function displaySingleRecord(rl) {
    clearConsole(true);
    rl.question('Enter the index of the record to display: ', (index) => {
        const record = getRecord(index);
        if (record) {
            console.log('Record:');
            console.log(`${record.date} | ${record.month} | ${record.year} | ${record.company} | ${record.pipeline} | ${record.keyPoint} | ${record.latitude} | ${record.longitude} | ${record.flowDirection} | ${record.tradeType} | ${record.product} | ${record.throughput} | ${record.committedVolumes} | ${record.uncommittedVolumes} | ${record.nameplateCapacity} | ${record.availableCapacity} | ${record.varianceReason}`);
        } else {
            console.log('Record not found.');
        }
        rl.close();
        promptUser();
    });
}
/**
 * Displays the records to the user.
 * @param {readline.Interface} rl - The readline interface input to prompt the user on what kind of record list to print.
 */
function displayRecords(rl) {
    clearConsole(true);
    rl.question('Enter the kind of record list you want to retrieve:\n1. Table: Displays records in a table-like format (Allows option for record limit) \n2. Array: Displays records in an array-like format (no option for record limit) ', (response) => {
        
        switch (response) {
            case '1': // Display as table
                rl.question('Enter the number of records to display (between 2 and 1000): ', (cutoff) => {
                    const cutoffLimit = parseInt(cutoff, 10); // Parse the input as an integer
                    
                    if (cutoffLimit < 2 || cutoffLimit > 1000 || isNaN(cutoffLimit)) {
                        console.log('Invalid cutoff limit. Next time, please enter a number between 2 and 1000.');
                        rl.close();
                        promptUser();
                        return;
                    }
                
                    loadRecords((records) => {
                        console.log('Records:');
                        console.log('Date | Month | Year | Company | Pipeline | Key Point | Latitude | Longitude | Flow Direction | Trade Type | Product | Throughput | Committed Volumes | Uncommitted Volumes | Nameplate Capacity | Available Capacity | Variance Reason');
                        console.log('-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------');
                        records.forEach((record, index) => {
                            console.log(`${record.date} | ${record.month} | ${record.year} | ${record.company} | ${record.pipeline} | ${record.keyPoint} | ${record.latitude} | ${record.longitude} | ${record.flowDirection} | ${record.tradeType} | ${record.product} | ${record.throughput} | ${record.committedVolumes} | ${record.uncommittedVolumes} | ${record.nameplateCapacity} | ${record.availableCapacity} | ${record.varianceReason}`);
                            if ((index + 1) % 10 === 0) {
                                console.log('\nProgram by: Nouraldin Hassan\n');
                            }
                        });
                        console.log(`Displayed ${records.length} records.`); // show how many records were displayed
                        rl.close();
                        promptUser();
                    }, cutoffLimit);
                })
                break;
            case '2': // Display as array
                fs.createReadStream(filePath)
                .pipe(csvParser())
                .on('data', (row) => {
                    try {
                        console.log('Parsed Row:', row);
                    } catch (error) {
                        console.error('Error parsing row:', error);
                    }
                })
                .on('end', () => {
                    console.log('CSV file successfully processed\nProgram by: Nouraldin Hassan\n');
                    rl.close();
                    promptUser();
                })
                .on('error', (error) => {
                    console.error('Error reading file:', error);
                });
                rl.close();
                promptUser();
                break;
            default:
                console.log('Invalid option.');
                rl.close();
                promptUser();
                break;
        }
    });
}
/**
 * Adds a new record.
 * @param {readline.Interface} rl - The readline interface input for adding a record.
 */
function addNewRecord(rl) {
    rl.question('Enter record details (comma-separated): Date,Month,Year,Company,Pipeline,Key Point,Latitude,Longitude,Flow Direction,Trade Type,Product,Throughput,Committed Volumes,Uncommitted Volumes,Nameplate Capacity,Available Capacity,Variance Reason\n', (input) => {
        const [date, month, year, company, pipeline, keyPoint, latitude, longitude, flowDirection, tradeType, product, throughput, committedVolumes, uncommittedVolumes, nameplateCapacity, availableCapacity, varianceReason] = input.split(',');
        const newRecord = new Record(date, month, year, company, pipeline, keyPoint, latitude, longitude, flowDirection, tradeType, product, throughput, committedVolumes, uncommittedVolumes, nameplateCapacity, availableCapacity, varianceReason);
        addRecord(newRecord);
        console.log('Record added.');
        rl.close();
        promptUser();
    });
}
/**
 * Edits a record.
 * @param {readline.Interface} rl - The readline interface input for editing a record.
 */
function editRecord(rl) {
    rl.question('Enter the index of the record to edit: ', (index) => {
        const record = getRecord(index);
        if (record) {
            rl.question('Enter new details (comma-separated): Date,Month,Year,Company,Pipeline,Key Point,Latitude,Longitude,Flow Direction,Trade Type,Product,Throughput,Committed Volumes,Uncommitted Volumes,Nameplate Capacity,Available Capacity,Variance Reason\n', (input) => {
                const [date, month, year, company, pipeline, keyPoint, latitude, longitude, flowDirection, tradeType, product, throughput, committedVolumes, uncommittedVolumes, nameplateCapacity, availableCapacity, varianceReason] = input.split(',');
                const updatedRecord = new Record(date, month, year, company, pipeline, keyPoint, latitude, longitude, flowDirection, tradeType, product, throughput, committedVolumes, uncommittedVolumes, nameplateCapacity, availableCapacity, varianceReason);
                updateRecord(index, updatedRecord);
                console.log('Record updated.');
                rl.close();
                promptUser();
            });
        } else {
            console.log('Record not found.');
            rl.close();
            promptUser();
        }
    });
}
/**
 * Deletes a record
 * @param {readline.Interface} rl - The readline interface input for deleting a record.
 */
function deleteRecordPrompt(rl) {
    rl.question('Enter the index of the record to delete: ', (index) => {
        deleteRecord(index);
        console.log('Record deleted.');
        rl.close();
        promptUser();
    });
}
function clearConsole(showAuthorAtEnd = false) {
    console.clear();
    process.stdout.write("\u001b[3J\u001b[2J\u001b[1J");
    if (showAuthorAtEnd) {
        console.log('Program by Nouraldin Hassan\n');
    }
}
/**
 * Initializes records and prints the author's name
 */
initializeRecords(() => {
    clearConsole();
    console.log('Program by Nouraldin Hassan\n');
    promptUser();
});
