       IDENTIFICATION DIVISION.
       PROGRAM-ID. MAINP1.
       ENVIRONMENT DIVISION.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
       01 WW-SEND-AREA.
           05 WW-NAME        PIC X(10)  VALUE 'JASON'.
           05 WW-AMOUNT      PIC 9(06)  VALUE 123456.

       01 WK-SUB-PROG       PIC X(75)
           VALUE '/Users/jasonmombourquette/Call/bin/SubPGM1'.

       PROCEDURE DIVISION.
           DISPLAY '********MAIN PGM START*********'
               DISPLAY 'NAME PASSED IS   -->' WW-NAME
               DISPLAY 'AMOUNT PASSED IS -->' WW-AMOUNT
           DISPLAY '********************************'
               CALL WK-SUB-PROG USING WW-SEND-AREA
               DISPLAY 'NAME AFTER RETURN  -->' WW-NAME
               DISPLAY 'AMOUNT AFTER RETURN-->' WW-AMOUNT
           DISPLAY '*******MAIN PGM END*************'
       STOP RUN.
