-- Cleanup for lab7

DROP PROCEDURE kingUser.sp_checkInvalidPostalCode;
DROP PROCEDURE kingUser.sp_checkInvalidTelephone;
DROP USER kingUser CASCADE;
DROP USER testUser;
DROP ROLE applicationAdmin;
DROP ROLE applicationUser;
DROP TABLESPACE CST2355 INCLUDING CONTENTS AND DATAFILES;

-- End of File