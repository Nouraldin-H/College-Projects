      ******************************************************************
      * Author: Nouraldin Hassan
      * Date:
      * Purpose: Create an indexed file from a non-indexed file
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. LAB_9_PROGRAM.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
           FILE-CONTROL.
           SELECT INVENT-FILE
           ASSIGN TO '..\INVENTORY.TXT'
           ORGANIZATION IS LINE SEQUENTIAL.
           SELECT INDEXED-INVENT-FILE
           ASSIGN TO '..\INDEXED-INVENTORY.IDX'
           ORGANIZATION IS INDEXED
           ACCESS MODE RANDOM
           RECORD KEY INVENTORY-ID
           ALTERNATE KEY VENDOR-NAME WITH DUPLICATES
           FILE STATUS WS-KEY.

       DATA DIVISION.
       FILE SECTION.

       FD  INVENT-FILE.
       01  INVENTORY-RECORD-IN.
           05  INVENTORY-ID-IN            PIC X(9).
           05  VENDOR-NAME-IN             PIC X(20).
           05  INVENTORY-DESCRIPTION-IN   PIC X(40).

       FD  INDEXED-INVENT-FILE.
       01  INVENTORY-RECORD-OUT.
           05  INVENTORY-ID            PIC X(9).
           05  VENDOR-NAME             PIC X(20).
           05  INVENTORY-DESCRIPTION   PIC X(40).

       WORKING-STORAGE SECTION.
       01  EOF-FLAG                    PIC X(3) VALUE 'NO'.
       01  WS-KEY                      PIC X(2).
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           PERFORM 100-CREATE-INVENTORY-FILE.
           STOP RUN.

           100-CREATE-INVENTORY-FILE.
               PERFORM 101-INITIALIZE-CREATE-FILE.
               PERFORM 102-CREATE-INVENTORY-RECORDS
               UNTIL  EOF-FLAG = 'YES'.
               PERFORM  103-TERMINATE-PROGRAM.

           101-INITIALIZE-CREATE-FILE.
               OPEN INPUT INVENT-FILE
               OUTPUT INDEXED-INVENT-FILE.

           102-CREATE-INVENTORY-RECORDS.
               PERFORM 201-OPEN-INV-FILES.
               PERFORM 203-WRITE-IND-INV-RECORD. *> REQUIRED FIRST BEFORE 202
               PERFORM 202-READ-INVENT-FILE.

           201-OPEN-INV-FILES.
               OPEN I-O INDEXED-INVENT-FILE.

           202-READ-INVENT-FILE.
               READ INVENT-FILE
                   AT END MOVE 'YES' TO EOF-FLAG.

           203-WRITE-IND-INV-RECORD.
               MOVE INVENTORY-RECORD-IN TO INVENTORY-RECORD-OUT.
               MOVE VENDOR-NAME-IN TO VENDOR-NAME.
               MOVE INVENTORY-DESCRIPTION-IN TO INVENTORY-DESCRIPTION.
               WRITE INVENTORY-RECORD-OUT INVALID KEY
                   PERFORM ERROR-ROUTINE
               END-WRITE.

             ERROR-ROUTINE.
                 EVALUATE TRUE
                   WHEN WS-KEY EQUALS "22"
                       DISPLAY "DUPLICATE KEY"
                   WHEN WS-KEY EQUALS "21"
                       DISPLAY "OUT OF SEQUENCE OR INVALID KEY"
                 END-EVALUATE.

           103-TERMINATE-PROGRAM.
               CLOSE INVENT-FILE
               CLOSE INDEXED-INVENT-FILE.

       END PROGRAM LAB_9_PROGRAM.
