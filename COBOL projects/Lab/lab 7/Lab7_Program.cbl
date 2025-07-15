      ******************************************************************
      * Author: Nouraldin Hassan
      * Date: 06-20-2023
      * Purpose: establish / declare a table of 200 occurences with a car
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. LAB_7_PROGRAM.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
           01 RATING           PIC X.
           01 GAS              PIC 9(3).

           88 RATING-E VALUE 0 THRU 5.
           88 RATING-G VALUE 6 THRU 10.
           88 RATING-F VALUE 11 THRU 15.
           88 RATING-P VALUE 16 THRU 99.

           01 CLIENT-INFORMATION.
               05 CLIENT-NAME PIC X(25).
               05 CLIENT-ADDRESS PIC X(40).
           01 NUMBER-LABELS PIC 9(3).
           01 PRINT-VALUE  PIC 9(3).

           01 SUB-1            PIC 9(3).
           01 EOF-FLG          PIC X(1).
           01 FILE-STATUS      PIC X(9).
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           DISPLAY "Enter the number of labels to print: "
           ACCEPT NUMBER-LABELS

           PERFORM ACTION_PRINT-LABELS VARYING PRINT-VALUE
           FROM 1 BY 1 UNTIL PRINT-VALUE > NUMBER-LABELS.

           DISPLAY "Enter the gas consumption value"
           ACCEPT GAS.
           PERFORM ACTION_GET-RATING.
           DISPLAY "RATING: " RATING.

           ACTION_PRINT-LABELS.
               DISPLAY "Printing Label " PRINT-VALUE.

           ACTION_GET-RATING.
               *> UMCOMMENT ONLY ONE APPROACH

               *> FIRST VERSION APPROACH
      *>          IF GAS LESS THAN 5 AND GREATER THAN 0
      *>              MOVE 'E' TO RATING
      *>          ELSE IF GAS <= 10
      *>              MOVE 'G' TO RATING
      *>          ELSE IF GAS <= 15
      *>              MOVE 'F' TO RATING
      *>          ELSE
      *>              MOVE 'P' TO RATING
      *>          END-IF.

               *> SECOND VERSION APPROACH
                  IF RATING-E
                      MOVE 'E' TO RATING
                  ELSE IF RATING-G
                      MOVE 'G' TO RATING
                  ELSE IF RATING-F
                      MOVE 'F' TO RATING
                  ELSE
                      MOVE 'P' TO RATING
                  END-IF.

           STOP RUN.
       END PROGRAM LAB_7_PROGRAM.

      *> 1. What are two advantages of using a Condition Name instead of a full conditional statement?
       *> The first advantage is readability. Using rating fields themselves make it easier to see which rating goes where,
       *> effectively providing condition names instead of using complex logical expressions.
       *> The second advantage is the improvement to maintainability.
       *> If the condition logic needs to change, only the condition name definition changes, not multiple occurences.
      *> 2. Can a condition name be used to check the validity of data input from a file?
       *> No, condition names are used within the program logic to evalate other conditions based on data values and calculations.
      *> 3. Can more than one value be used in a Condition Name?
       *> Yes, condition names can represent multiple values, as shown in the second version approach.
      *> 4. Can more than one range of values be checked with a Condition Name.
       *> No, Condition names can only check one range of values. You can define multiple conditions to check multiple ranges.
