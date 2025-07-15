      ******************************************************************
      * Author: Nouraldin Hassan
      * Date: 07-25-2023
      * Purpose: Use redefine after declaration for external console for entries
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. LAB_10_PROGRAM.
       ENVIRONMENT DIVISION.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01 WS-DECLARATION.
           05  WS-SHOE-STYLE        PIC X(5). *> Input?
           05  WS-SHOE-SIZE            PIC X(4). *> Output?
       01 HOLD PIC X.
       SCREEN SECTION.
       01  SCREEN-DECLARATION.
      *>      05 BLANK SCREEN.
      *>      05 LINE 5 COLUMN 5 PROMPT "Shoe Style: ".
      *>      05 LINE 5 COLUMN 25 RECEIVE Shoe-Style.
      *>      05 LINE 7 COLUMN 5 PROMPT "Shoe Size: ".
      *>      05 LINE 7 COLUMN 25 RECEIVE Shoe-Size.
           05 VALUE "Enter Shoe Style"
           LINE 5 COLUMN 5.
           05 SS-SHOE-STYLE        PIC X(5) TO WS-SHOE-STYLE
           LINE 5 COLUMN 25. *> Input?
           05 VALUE "Enter Shoe Size"
           LINE 7 COLUMN 5.
           05 SS-SHOE-SIZE         PIC X(4) TO WS-SHOE-SIZE
           LINE 7 COLUMN 25. *> Output?
      *>      05 BLANK SCREEN.
       01 SCREEN-DISPLAY.
           05 VALUE "You Entered Shoe Style: "
           LINE 5 COLUMN 1 FROM WS-SHOE-STYLE.
           05 VALUE "You Entered Shoe Size: "
           LINE 7 COLUMN 1 FROM WS-SHOE-SIZE.
       01 SCREEN-HOLD.
           05 VALUE "Completed! Press enter to continue"
           LINE 10 COLUMN 10.
           05 LINE 9 COLUMN 26 TO HOLD.

       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           DISPLAY SCREEN-DECLARATION.
           ACCEPT SCREEN-DECLARATION.
           DISPLAY SCREEN-DISPLAY.
           ACCEPT SCREEN-HOLD.
      *>      DISPLAY "YOU ENTERED: " WS-DECLARATION.
      *>      DISPLAY "YOU ENTERED: " WS-SHOE-STYLE.
      *>      DISPLAY "YOU ENTERED: " WS-SHOE-SIZE.
           STOP RUN.
       END PROGRAM LAB_10_PROGRAM.
