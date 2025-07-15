      ******************************************************************
      * Author:
      * Date:
      * Purpose:
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. YOUR-PROGRAM-NAME.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01   FLD-1   PIC    9(4)V9    VALUE    145.
       01   FLD-2   PIC    9(4)V9    VALUE    222.
       01   FLD-3   PIC    9(4)V9    VALUE    10.
       01   FLD-4   PIC    9(4)V9    VALUE    21.
       01   FLD-5   PIC    9(4)V9    VALUE    33.
       01   FLD-6   PIC    9(4)V9    VALUE    1111.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
      *>       DISPLAY "BEFORE: " FLD-3
      *>       DIVIDE FLD-1 INTO FLD-2 GIVING FLD-3.
      *>       DISPLAY "AFTER: " FLD-3

            DISPLAY "BEFORE: " FLD-1
            COMPUTE FLD-1 = FLD-2 + FLD-3 ** FLD-4.
            DISPLAY "AFTER: " FLD-1

            STOP RUN.
       END PROGRAM YOUR-PROGRAM-NAME.
