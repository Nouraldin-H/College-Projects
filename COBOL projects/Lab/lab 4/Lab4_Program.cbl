      ******************************************************************
      * Author: Nouraldin Hassan
      * Date:
      * Purpose:
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. LAB_4_PROGRAM.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01 VAL_1-1      PIC 9(3) VALUE 123.
       01 VAL_1-2      PIC 9(3)V9.
       01 VAL_2-1      PIC X(6) VALUE 1234  .
       01 VAL_2-2      PIC X(5).
       01 VAL_3-1      PIC 9(3)V99 VALUE 123.45.
       01 VAL_3-2      PIC 9(3)V9.
       01 VAL_4-1      PIC X(5) VALUE '12AB5'.
       01 VAL_4-2      PIC 9(5).
       01 VAL_5-1      PIC X(4) VALUE "JOHN".
       01 VAL_5-2      PIC X(6).
       01 VAL_6-1      PIC X(6) VALUE 123456.
       01 VAL_6-2      PIC X(4).
       01 VAL_7-1      PIC A(6) VALUE "  ABCD".
       01 VAL_7-2      PIC X(4).
       01 VAL_8-1      PIC 9(5) VALUE 12345.
       01 VAL_8-2      PIC X(7).
       01 VAL_9-1      PIC 9(5) VALUE 12345.
       01 VAL_9-2      PIC X(3).

       01 VAL_10-1     PIC 9(7) VALUE 1.
       01 VAL_10-2     PIC 9(7) VALUE 2.
       01 VAL_10-3     PIC 9(9) VALUE 3.
       01 VAL_10-4     PIC 9(8) VALUE 4.
       01 VAL_10-5     PIC 9(32).
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           MOVE VAL_1-1 TO VAL_1-2
           MOVE VAL_2-1 TO VAL_2-2
           MOVE VAL_3-1 TO VAL_3-2
           MOVE VAL_4-1 TO VAL_4-2
           MOVE VAL_5-1 TO VAL_5-2
           MOVE VAL_6-1 TO VAL_6-2
           MOVE VAL_7-1 TO VAL_7-2
           MOVE VAL_8-1 TO VAL_8-2
           MOVE VAL_9-1 TO VAL_9-2

      *>      ADD VAL_10-1 VAL_10-2 TO VAL_10-4 VAL_10-5.

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
            DISPLAY "SEND 9: " VAL_9-1
            DISPLAY "REC 9: " VAL_9-2
            STOP RUN.
       END PROGRAM LAB_4_PROGRAM.
