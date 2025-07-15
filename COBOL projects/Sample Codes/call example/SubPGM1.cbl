       IDENTIFICATION DIVISION.
       PROGRAM-ID. SubPGM1.
       ENVIRONMENT DIVISION.
       DATA DIVISION.
       LINKAGE SECTION.
       01 LS-LINK-AREA.
           05 LS-NAME-IN      PIC  X(10).
           05 LS-AMOUNT-IN    PIC  9(06).

       PROCEDURE DIVISION USING LS-LINK-AREA.
           DISPLAY '********SUB PGM START***********'
               DISPLAY 'NAME RECIEVED IS   -->' LS-NAME-IN
               DISPLAY 'AMOUNT RECIEVED IS -->' LS-AMOUNT-IN
      *    Now we will modify the amount by subtracting 100000
           COMPUTE LS-AMOUNT-IN = LS-AMOUNT-IN - 100000
           DISPLAY 'CHANGED AMOUNT IS  -->' LS-AMOUNT-IN
           DISPLAY '********SUB PGM END*************'
       GOBACK.
