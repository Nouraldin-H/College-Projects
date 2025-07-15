      ******************************************************************
      * Author:
      * Date:
      * Purpose:
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. LAB_8_PROGRAM.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
           FILE-CONTROL.
           SELECT PAY-FILE-IN
           ASSIGN TO '..\PAY-FILE-IN.TXT'
           ORGANIZATION IS LINE SEQUENTIAL.
       DATA DIVISION.
       FILE SECTION.

       FD       PAY-FILE-IN.
       01    PAY-RECORD-IN.
           05    SALARY  PIC 9(2)V99.
               88 VALID-SALARY  VALUE  4.50  THROUGH 50.00.
           05     HOURS    PIC 9(2) VALUE 70.
               88    REG-HOURS  VALUE    0  THROUGH 40.
               88    OT-HOURS      VALUE  41 THROUGH 80.

       WORKING-STORAGE SECTION.
       01     PAY-TABLE-VALUES-TBL.
         05    PAY-VALUES-TBL   OCCURS 5000 TIMES.
               10  JOB-TYPE-TBLE    PIC X(3).
               10  PAY-VALUE-TBLE  PIC 9(3)V99.

       01   FLAGS-WORKING-FIELDS.
           05   FOUND-FLAG    PIC X(3)  VALUE  "NO".
           05   SUB-1                 PIC 9(4).
           05   JOB-TYPE-IN     PIC X(3).
           05   PAY-VALUE-EDITED  PIC $$$9.99.

       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
      *>      SET VALID-SALARY   TO TRUE.
      *>       DISPLAY HOURS.

           DISPLAY "Enter Job Type: ".
            ACCEPT JOB-TYPE-IN.
            MOVE 1 TO SUB-1.
            MOVE "NO" TO FOUND-FLAG.

            PERFORM SEARCH-TABLE UNTIL SUB-1 > 5000
            OR FOUND-FLAG = "YES".

            IF FOUND-FLAG = "YES" THEN
                DISPLAY "PAY VALUE: $" PAY-VALUE-EDITED
            ELSE
                DISPLAY "JOB TYPE NOT FOUND IN TABLE."

            STOP RUN.

        SEARCH-TABLE.
            IF JOB-TYPE-IN = JOB-TYPE-TBLE(SUB-1)
                MOVE PAY-VALUE-TBLE(SUB-1) TO PAY-VALUE-EDITED
                MOVE "YES" TO FOUND-FLAG
            END-IF.

            ADD 1 TO SUB-1.

       END PROGRAM LAB_8_PROGRAM.
