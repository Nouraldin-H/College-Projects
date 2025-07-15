const mysql = require('mysql2');

const pool = mysql.createPool({
    host: '127.0.0.1',
    user: 'root',
    password: 'password-goes-here',
    database: 'NodeJS-Instance'
});

module.exports = pool.promise();