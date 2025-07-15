#!/bin/bash
# Date     : 07 Apr 2021
# Filename : while_break.sh
# Illustrates break 
# Displays 52 weeks and 7 days in a week.
# Notes: uncomment break and break 2 statements and run the code.

(( dow = 1 ))
(( week = 1 ))

while [ $week -le 52 ]
   do
   while [ $dow -le 7 ]
   do
      echo "Week $week, Day $dow"
      (( dow += 1 )) # increment by 1
      # break will exit only the inner loop
      # uncomment break and test the script.
      # break
      # break 2 will exit two levels of nested while loops
      # break or break n, indicate rough code suitable for quick prototyping
      # not for production use.
      # break 2
   done
   (( dow = 1 ))
   (( week += 1 )) # increment by 1
   done
echo

# eof: while_break.sh
