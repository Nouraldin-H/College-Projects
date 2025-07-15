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
       01  DATA-ITEMS.
           05 GRADE-IN PIC 9(3).
               88 A-GRADE VALUE 80 THROUGH 100.
               88 B-GRADE VALUE 70 THROUGH 79.
               88 C-GRADE VALUE 60 THROUGH 69.
               88 D-GRADE VALUE 50 THROUGH 59.
               88 F-GRADE VALUE 0 THROUGH 49.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
            DISPLAY "ENTER YOUR GRADE: ".
            ACCEPT GRADE-IN.
            DISPLAY "CONDITIONAL EXAMPLE...".
            IF GRADE-IN > 80
                DISPLAY "YOU GOT AN A!"
            ELSE IF GRADE-IN > 70 AND <= 79
                DISPLAY "YOU GOT A B!"
            ELSE IF GRADE-IN > 60 AND <= 69
                DISPLAY "YOU GOT A C!"
            ELSE IF GRADE-IN > 50 AND <= 59
                DISPLAY "YOU GOT A D!"
            ELSE
                DISPLAY "YOU FAILED!".

            DISPLAY "LEVEL 88 EXAMPLE...".
            IF A-GRADE
                DISPLAY "YOU GOT AN A!"
            ELSE IF B-GRADE
                DISPLAY "YOU GOT A B!"
            ELSE IF C-GRADE
                DISPLAY "YOU GOT A C!"
            ELSE IF D-GRADE
                DISPLAY "YOU GOT A D!"
            ELSE IF F-GRADE
                DISPLAY "YOU FAILED!"
            ELSE
                DISPLAY "INCORRECT GRADE ENTERED...".
            STOP RUN.
       END PROGRAM YOUR-PROGRAM-NAME.
