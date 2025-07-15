      ******************************************************************
      * Author: Nouraldin Hassan
      * Date: 06-20-2023
      * Purpose: establish / declare a table of 200 occurences with a car
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. LAB_6_PROGRAM.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
           FILE-CONTROL.
           SELECT CAR-FILE
           ASSIGN TO '..\CAR-FILE.TXT'
           ORGANIZATION IS LINE SEQUENTIAL. *> change to INDEXED to use below commented code, or else use LINE SEQUENTIAL
      *>      ACCESS MODE RANDOM
      *>      RECORD KEY THISKEY
      *>      FILE STATUS FILE-STATUS.
       DATA DIVISION.
       FILE SECTION.
       FD CAR-FILE.
       01 THISKEY        PIC X(9).
       01 CAR-RECORD OCCURS 200 TIMES.
           05 CAR-TYPE           PIC X(5).
      *>      05 FILLER         PIC X(3) VALUE SPACES.
           05 CAR-YEAR     PIC 9(4).
      *>      05 FILLER         PIC X(3) VALUE SPACES.
           05 ENGINE-SIZE        PIC 9(1).
       WORKING-STORAGE SECTION.
          01 SUB-1         PIC 9(3).
          01 EOF-FLG       PIC X(1).
      *>     01 FILE-STATUS PIC X(9).
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
      *>      OPEN I-O CAR-FILE.
           OPEN INPUT CAR-FILE.
           PERFORM 01-ACTION VARYING SUB-1 FROM 1 BY 1
           UNTIL EOF-FLG = 'Y' OR SUB-1 > 200.
           CLOSE CAR-FILE.
           STOP RUN.

           01-ACTION.
               READ CAR-FILE
                AT END MOVE 'Y' TO EOF-FLG
                   NOT AT END ADD 1 TO SUB-1
                        MOVE THISKEY TO CAR-RECORD(SUB-1)
                       DISPLAY CAR-RECORD(SUB-1).
      *>          END READ.

       END PROGRAM LAB_6_PROGRAM.
