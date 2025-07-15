      ******************************************************************
      * Author: Nouraldin Hassan
      * Date: 05/23/2023
      * Purpose: establish the required environment devision and data
      * division entries for student data
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. LAB_2_PROGRAM.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
           FILE-CONTROL.
           SELECT STUDENT-INPUT-FILE
           ASSIGN TO '..\STUDENT.TXT'.
           SELECT STUDENT-REPORT-OUT-FILE
           ASSIGN TO '..\STUDENT-OUT.TXT'
           ORGANIZATION IS LINE SEQUENTIAL.
       DATA DIVISION.
       FILE SECTION.
       FD STUDENT-INPUT-FILE
           RECORD CONTAINS 200 CHARACTERS. *> the maximum capacity of the record.
      *>     DATA RECORD IS STUDENT-IN.
       01 STUDENT-IN.
           05 STUDENT-NUMBER       PIC X(10).
           05 STUDENT-PROGRAM      PIC X(8).
           05 STUDENT-YEAR         PIC 9(6).
           05 STUDENT-DATA.
               30 STUDENT-FULL-NAME.
                   45 STUDENT-TITLE    PIC X(6).
                   45 STUDENT-FIRST-NAME   PIC X(15).
                   45 STUDENT-INITIAL  PIC X(2).
                   45 STUDENT-LAST-NAME    PIC X(28).
               30 STUDENT-ADDRESS.
                   45 STREET-ADDRESS   PIC X(25).
                   45 CITY-NAME        PIC X(15).
                   45 PROVINCE         PIC X(15).
                   45 POSTAL-CODE      PIC X(7).

       WORKING-STORAGE SECTION.
      *> 01 WS-EOF PIC A(1).
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
      *>      DISPLAY "Hello world"
      *>      STOP RUN.
       END PROGRAM LAB_2_PROGRAM.
