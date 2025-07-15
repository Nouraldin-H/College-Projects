-- Filename: LearnTrig-Query.sql
-- Query statements to test trigger in LearnTrigger lab

SELECT * FROM Employee_T;
SELECT * FROM Employee_Audit_T;

-- update successful
UPDATE Employee_T SET Last_Name = 'King' WHERE Last_Name = 'Khan';
UPDATE Employee_T SET Last_Name = 'Khan' WHERE Last_Name = 'King';
UPDATE Employee_T SET First_Name = 'Doug' WHERE First_Name = 'Sarfraz';
UPDATE Employee_T SET First_Name = 'Sarfraz' WHERE First_Name = 'Doug';


SELECT * from Employee_Audit_T;

-- eof: LearnTrig-Query.sql