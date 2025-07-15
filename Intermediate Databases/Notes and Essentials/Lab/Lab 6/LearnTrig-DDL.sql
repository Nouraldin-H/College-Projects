-- Filename: LearnTrig-DDL.sql
-- Last Modified: March 7th 2023

-- Drop Trigger & Its Function IF EXISTS 
DROP TRIGGER IF EXISTS Emp_Last_Name_Change ON Employee_T;
DROP FUNCTION IF EXISTS Log_Last_Name_Change();

-- DROP Employee_T and Employee_T_Audit Table
DROP TABLE IF EXISTS Employee_T;
DROP TABLE IF EXISTS Employee_Audit_T;

-- create Employee_T table
CREATE TABLE Employee_T(
   Employee_ID  SERIAL  PRIMARY KEY,
   First_name   VARCHAR( 40 ) NOT NULL,
   Last_Name    VARCHAR( 40 ) NOT NULL
);
-- populating the employee_t table 
INSERT INTO Employee_T( First_Name, Last_Name ) VALUES( 'Roly', 'Algonquin' );
INSERT INTO Employee_T( First_Name, Last_Name ) VALUES( 'Dan', 'CST' );
INSERT INTO Employee_T( First_Name, Last_Name ) VALUES( 'Sandra', 'Database' );
INSERT INTO Employee_T( First_Name, Last_Name ) VALUES( 'Sarfraz', 'Bond' );
INSERT INTO Employee_T( First_Name, Last_Name ) VALUES( 'Doug', 'Khan' );

-- create table to store audit detail
CREATE TABLE Employee_Audit_T(
   ID SERIAL      PRIMARY KEY,
   Employee_ID    INT4 NOT NULL,
   Old_Last_Name  VARCHAR( 40 ),
   Changed_ON     TIMESTAMP( 6 ) NOT NULL
);

-- Now We Will Create a Trigger Function
CREATE OR REPLACE FUNCTION Log_Last_Name_Change()
  RETURNS TRIGGER AS
$$
BEGIN
    -- check if last_name has changed
    -- compare NEW. to OLD.
    IF NEW.last_name <> OLD.last_name THEN
    INSERT INTO Employee_Audit_T( Employee_ID, Old_Last_Name, Changed_ON )
    VALUES( OLD.Employee_ID, OLD.Last_Name, NOW() );
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgSQL;

-- Now, we associate the above trigger function with the trigger. 
CREATE TRIGGER Emp_Last_Name_Change 
   BEFORE UPDATE ON Employee_T
   FOR EACH ROW 
   EXECUTE PROCEDURE Log_Last_Name_Change();

-- eof: LearnTrig-DDL.sql