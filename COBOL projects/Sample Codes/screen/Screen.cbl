      ******************************************************************
      * Author:
      * Date:
      * Purpose:
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. YOUR-PROGRAM-NAME.
       ENVIRONMENT DIVISION.
       DATA DIVISION.
.      WORKING-STORAGE SECTION.
       01 STUDENT-RECORD-IN.
           05 STUDENT-ID-WS PIC X(4).
           05 PROGRAM-NAME-WS PIC X(20).

       SCREEN SECTION.
       01  INPUT-SCREEN.
           05 VALUE "INPUT" BLANK SCREEN LINE 1 COL 35.
           05 VALUE "STUDENT ID" LINE 3 COL 10.
           05 STUDENT-ID-IN LINE 3 COL 25
                   PIC  X(4) TO STUDENT-ID-WS.
           05 VALUE "PROGRAM NAME" LINE 5 COL 10.
           05 PROGRAM-NAME-IN LINE 5 COL 25
                   PIC X(20) TO PROGRAM-NAME-WS.
       01  USING-SCREEN.
           05 VALUE "USING" BLANK SCREEN LINE 1 COL 35.
           05 VALUE "STUDENT ID" LINE 3 COL 10.
           05 STUDENT-ID-IN LINE 3 COL 25
                   PIC  X(4) USING STUDENT-ID-WS.
           05 VALUE "PROGRAM NAME" LINE 5 COL 10.
           05 PROGRAM-NAME-IN LINE 5 COL 25
                   PIC X(20) USING PROGRAM-NAME-WS.
       01  OUTPUT-SCREEN.
           05 VALUE "OUTPUT" BLANK SCREEN LINE 1 COL 35.
           05 VALUE "STUDENT ID" LINE 3 COL 10.
           05 STUDENT-ID-IN LINE 3 COL 25
                   PIC  X(4) FROM STUDENT-ID-WS.
           05 VALUE "PROGRAM NAME" LINE 5 COL 10.
           05 PROGRAM-NAME-IN LINE 5 COL 25
                   PIC X(20) FROM PROGRAM-NAME-WS.

       PROCEDURE DIVISION.
       MAIN-PROCEDURE.

           DISPLAY INPUT-SCREEN.
           ACCEPT INPUT-SCREEN.
           DISPLAY USING-SCREEN.
           ACCEPT USING-SCREEN.
           DISPLAY OUTPUT-SCREEN.


       END PROGRAM YOUR-PROGRAM-NAME.
