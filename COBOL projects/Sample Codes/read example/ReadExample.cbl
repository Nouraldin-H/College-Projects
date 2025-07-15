       IDENTIFICATION DIVISION.
       PROGRAM-ID. READ-EXAMPLE.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
      *This will select a file to be used for the program.
      *And then it will assign it to a real file.
      *Organization will be line sequential.
           SELECT STUDENT
           ASSIGN TO "\Users\jasonmombourquette\INPUT.txt"
           ORGANIZATION IS LINE SEQUENTIAL.
       DATA DIVISION.
       FILE SECTION.
       FD STUDENT.
       01 STUDENT-FILE.
           05 STUDENT-ID PIC 9(5).
           05 NAME PIC A(25).

       WORKING-STORAGE SECTION.

       01 WS-EOF PIC A(1).

       PROCEDURE DIVISION.
           MAIN_PROGRAM.
               PERFORM OPEN_ROUTINE.
               PERFORM READ_ROUTINE UNTIL WS-EOF='Y'.
               PERFORM CLOSE_ROUTINE.
               STOP RUN.

           OPEN_ROUTINE.
               OPEN INPUT STUDENT.

           READ_ROUTINE.
               READ STUDENT
                   AT END MOVE 'Y' TO WS-EOF
                       NOT AT END DISPLAY STUDENT-FILE.

           CLOSE_ROUTINE.
               CLOSE STUDENT.

           END PROGRAM READ-EXAMPLE.
