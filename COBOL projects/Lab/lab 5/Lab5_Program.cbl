      ******************************************************************
      * Author:
      * Date:
      * Purpose:
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. LAB_5_PROGRAM.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01   FLD-1   PIC	9(3)	VALUE	145.
       01   FLD-2   PIC	9(3)	VALUE	222.
       01   FLD-3   PIC	9(2)	VALUE	10.
   	   01   FLD-4   PIC	9(3)	VALUE	21.
       01   FLD-5   PIC	9(2)	VALUE	33.
       01   FLD-6   PIC	9(4)	VALUE	1111.

       01 VAL_1-1   PIC 9(3)V99 VALUE 123.
       01 VAL_1-2   PIC 9(3)V99.
       01 VAL_2-1   PIC S9(6) VALUE +123456. *> positive
       01 VAL_2-2   PIC 999999.99+.
       01 VAL_3-1   PIC 9(3)V99 VALUE 12345. *> positive
       01 VAL_3-2   PIC 999.99-.
       01 VAL_4-1   PIC S9(3)V99 VALUE +12345. *> positive
       01 VAL_4-2   PIC 999.99-.
       01 VAL_5-1   PIC S9(5)V99 VALUE -1234567. *> negative
       01 VAL_5-2   PIC 99,999.99+.
       01 VAL_6-1   PIC 9(5)V99 VALUE 1234567. *> positive
       01 VAL_6-2   PIC 99,999.99+.
       01 VAL_7-1   PIC S9(5)V99 VALUE +1234567. *> positive
       01 VAL_7-2   PIC 99,999.99DB.
       01 VAL_8-1   PIC S9(5)V99 VALUE -1234567. *> negative
       01 VAL_8-2   PIC 99,999.99DB.

       PROCEDURE DIVISION.
       MAIN-PROCEDURE.

      *>       DISPLAY "Q1 BEFORE: " FLD-2
      *>       MULTIPLY FLD-1 BY FLD-3 GIVING FLD-2
      *>       DISPLAY "Q1 AFTER: " FLD-2

      *>       DISPLAY "Q2 BEFORE: " FLD-6
      *>       DIVIDE FLD-5 BY FLD-3 GIVING FLD-6 ROUNDED.
      *>       DISPLAY "Q2 AFTER: " FLD-6

      *>       DISPLAY "Q3 BEFORE: " FLD-4
      *>       ADD FLD-6 FLD-4 TO FLD-3.
      *>       DISPLAY "Q3 AFTER: " FLD-4

      *>       DISPLAY "Q4 BEFORE: " FLD-1
      *>       SUBTRACT FLD-4 FLD-2 FLD-1 FROM FLD-5.
      *>       DISPLAY "Q4 AFTER: " FLD-1

      *>       DISPLAY "Q5 BEFORE: " FLD-5
      *>       COMPUTE FLD-5 ROUNDED = (FLD-2 + FLD-4) / 3.
      *>       DISPLAY "Q5 AFTER: " FLD-5

      *>       DISPLAY "Q6 BEFORE: " FLD-2
      *>       SUBTRACT FLD-3 FLD-4 FLD-5 FROM FLD-2.
      *>       DISPLAY "Q6 AFTER: " FLD-2
           DISPLAY ""
           MOVE VAL_1-1 TO VAL_1-2
           MOVE VAL_2-1 TO VAL_2-2
           MOVE VAL_3-1 TO VAL_3-2
           MOVE VAL_4-1 TO VAL_4-2
           MOVE VAL_5-1 TO VAL_5-2
           MOVE VAL_6-1 TO VAL_6-2
           MOVE VAL_7-1 TO VAL_7-2
           MOVE VAL_8-1 TO VAL_8-2

           DISPLAY "SEND 1: " VAL_1-1
            DISPLAY "REC 1: " VAL_1-2
            DISPLAY "SEND 2: " VAL_2-1
            DISPLAY "REC 2: " VAL_2-2
            DISPLAY "SEND 3: " VAL_3-1
            DISPLAY "REC 3: " VAL_3-2
            DISPLAY "SEND 4: " VAL_4-1
            DISPLAY "REC 4: " VAL_4-2
            DISPLAY "SEND 5: " VAL_5-1
            DISPLAY "REC 5: " VAL_5-2
            DISPLAY "SEND 6: " VAL_6-1
            DISPLAY "REC 6: " VAL_6-2
            DISPLAY "SEND 7: " VAL_7-1
            DISPLAY "REC 7: " VAL_7-2
            DISPLAY "SEND 8: " VAL_8-1
            DISPLAY "REC 8: " VAL_8-2

            STOP RUN.
       END PROGRAM LAB_5_PROGRAM.
