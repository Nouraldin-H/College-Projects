      ******************************************************************
      * Author: Nouraldin Hassan
      * Date: 06-13-2023
      * Purpose: create a file that holds student records via input
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROJECT_1_PROGRAM.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
           FILE-CONTROL.
           SELECT STUDENT-RECORDS-FILE
           ASSIGN TO '..\STUDENT-RECORDS.TXT'
           ORGANIZATION IS LINE SEQUENTIAL.
      *>      SELECT RECORDS-INPUT-FILE
      *>      ASSIGN TO '..\STUDENT-RECORDS.TXT'
      *>      ORGANIZATION IS LINE SEQUENTIAL.

       DATA DIVISION.
       FILE SECTION.
       FD STUDENT-RECORDS-FILE.
       01 STUDENT-FILE-OUT.
           05 STUDENT-NUMBER-OUT           PIC 9(7).
           05 FILLER         PIC X(3) VALUE SPACES.
           05 STUDENT-TUITION-OWED-OUT     PIC 9(5).
           05 FILLER         PIC X(3) VALUE SPACES.
           05 STUDENT-FULL-NAME-OUT        PIC A(40).
      *>          10 STUDENT-FIRST-NAME-OUT   PIC A(15).
      *>          10 STUDENT-LAST-NAME-OUT    PIC A(25).

      *>  FD RECORDS-INPUT-FILE.
      *>  01 RECORD-FILE-IN.
      *>      05 RECORD-NUMBER-IN           PIC 9(7).
      *>      05 FILLER         PIC X(3) VALUE SPACES.
      *>      05 RECORD-TUITION-OWED-IN     PIC 9(5).
      *>      05 FILLER         PIC X(3) VALUE SPACES.
      *>      05 RECORD-FULL-NAME-IN        PIC A(40).
      *> *>          10 STUDENT-FIRST-NAME-OUT   PIC A(15).
      *> *>          10 STUDENT-LAST-NAME-OUT    PIC A(25).

       WORKING-STORAGE SECTION.
      *>  01 STUDENT-INFO-IN.
      *>      05 STUDENT-NUMBER-IN           PIC 9(7).
      *>      05 STUDENT-TUITION-OWED-IN     PIC 9(5).
      *>      05 STUDENT-FULL-NAME-IN         PIC A(40).

      *>  01 STUDENT-INFO-OUT.
      *>      05 STUDENT-NUMBER-INFO       PIC 9(7).
      *>      05 STUDENT-TUITION-OWED-INFO    PIC 9(5).
      *>      05 STUDENT-FULL-NAME-INFO    PIC A(40).

       01 WS-EOF PIC A(1).
       01 WS-YES PIC A(1). *> Checks if the response is yes or no (1 or 0)

       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           PERFORM 201-INITIALIZATION.
           PERFORM 202-PROCESS-STUDENT-RECORDS UNTIL WS-YES = 'N' OR 0.
           PERFORM 203-CLOSE-FILE.
           STOP RUN.

           201-INITIALIZATION.
               PERFORM 301-OPEN-FILE.
               PERFORM 302-INQUIRE-RECORD.

           301-OPEN-FILE.
               OPEN OUTPUT STUDENT-RECORDS-FILE.
      *>          OPEN INPUT RECORDS-INPUT-FILE.

           302-INQUIRE-RECORD.
               DISPLAY "Inquire Record? (Y or N / 1 or 0) "
               ACCEPT WS-YES.
               DISPLAY " ". *> Used for spacing for readability

           202-PROCESS-STUDENT-RECORDS.
               PERFORM 303-GET-STUDENT-RECORD.
      *>          PERFORM 303B-READ-STUDENT-RECORD UNTIL WS-EOF = 'Y'.
               PERFORM 304-WRITE-STUDENT-RECORD.
               PERFORM 302-INQUIRE-RECORD.

           303-GET-STUDENT-RECORD.
               IF WS-YES = 'Y' OR 1 THEN
                   DISPLAY "Enter Student Number: "
                   ACCEPT STUDENT-NUMBER-OUT
                   DISPLAY "Enter Student Tuition Owed: "
                   ACCEPT STUDENT-TUITION-OWED-OUT
                   DISPLAY "Enter Student Name: "
                   ACCEPT STUDENT-FULL-NAME-OUT
      *>              DISPLAY " "
      *>              DISPLAY STUDENT-INFO-IN.
               END-IF.

      *>      303B-READ-STUDENT-RECORD.
      *>          READ RECORDS-INPUT-FILE
      *>          AT END MOVE 'Y' TO WS-EOF.

           304-WRITE-STUDENT-RECORD.
               WRITE STUDENT-FILE-OUT.*> FROM RECORD-FILLER.

      *>          MOVE STUDENT-NUMBER-IN
      *>          TO STUDENT-FILE-OUT STUDENT-INFO-OUT STUDENT-NUMBER-INFO. *> not sure which is correct so I used all. It does work though.
      *>          MOVE STUDENT-TUITION-OWED-IN
      *>          TO STUDENT-TUITION-OWED-OUT
      *>          STUDENT-TUITION-OWED-INFO STUDENT-INFO-OUT.
      *>          MOVE STUDENT-FULL-NAME-IN
      *>          TO STUDENT-FULL-NAME-OUT STUDENT-FULL-NAME-INFO.
      *>          PERFORM 304-WRITE-STUDENT-RECORD.
      *>          READ STUDENT-INPUT-FILE
      *>              AT END MOVE 'Y' TO WS-EOF
      *>                  NOT AT END ADD 1 TO STUDENT-NUMBER-IN
      *>                      DISPLAY STUDENT-FILE-IN.

           203-CLOSE-FILE.
               CLOSE STUDENT-RECORDS-FILE.
      *>          CLOSE RECORDS-INPUT-FILE.

       END PROGRAM PROJECT_1_PROGRAM.
