      ******************************************************************
      * Author:
      * Date:
      * Purpose:
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. LAB_3_PROGRAM.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT   CAR-FILE-IN
           ASSIGN TO '..\CARFILE.TXT'
                ORGANIZATION IS LINE SEQUENTIAL.

       DATA DIVISION.
       FILE  SECTION.
       FD  CAR-FILE-IN.
       01 CAR-RECORD-IN.
           05    CAR-MODEL             PIC X(15).
           05    CAR-DATA.
               10  ENGINE              PIC X(25).
               10  TOWING-CAPACITY     PIC 9(8).
               10  OWNER-NAME          PIC X(30).


       WORKING-STORAGE SECTION.
           01  CONTROL-FIELDS.
               05   EOF-FLG    PIC X.

       PROCEDURE DIVISION.
       100-PRODUCE-CAR-LIST. *> Match the program functions to the numbers
       *> I.E. follow the function chart. Names and structure.
           PERFORM 201-INITIATE-CAR-LIST.
           PERFORM 202-DISPLAY-ONE-CAR-RECORD UNTIL EOF-FLG="Y".
           PERFORM 203-CLOSE-CAR-FILE.
           STOP RUN.

           201-INITIATE-CAR-LIST.
               PERFORM 301-OPEN-CAR-FILE.
               PERFORM 305-READ-CAR-RECORD.

               301-OPEN-CAR-FILE.
                   OPEN INPUT CAR-FILE-IN.

           202-DISPLAY-ONE-CAR-RECORD.
          *>   PERFORM 302-DISPLAY-CAR-MODEL.
               PERFORM 305-READ-CAR-RECORD.

               302-DISPLAY-CAR-MODEL.
                   DISPLAY CAR-RECORD-IN.

               305-READ-CAR-RECORD.
                   READ CAR-FILE-IN
                      AT END MOVE 'Y' TO EOF-FLG
                          NOT AT END PERFORM 302-DISPLAY-CAR-MODEL.

           203-CLOSE-CAR-FILE.
               CLOSE CAR-FILE-IN.


      *>      MAIN_PROGRAM.
      *>          PERFORM OPEN_ROUTINE.
      *>          PERFORM READ_ROUTINE UNTIL EOF-FLG='Y'.
      *>          PERFORM CLOSE_ROUTINE.
      *>          STOP RUN.

      *>      OPEN_ROUTINE.
      *>          OPEN INPUT CAR-FILE-IN.

      *>      READ_ROUTINE.
      *>          READ CAR-FILE-IN
      *>              AT END MOVE 'Y' TO EOF-FLG
      *>                  NOT AT END DISPLAY CAR-RECORD-IN.

      *>      CLOSE_ROUTINE.
      *>          CLOSE CAR-FILE-IN.
       END PROGRAM LAB_3_PROGRAM.
