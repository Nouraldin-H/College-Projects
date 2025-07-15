#!/bin/bash
# Filename : create_lines.sh
# Date : 20-Jan-2022
# Creates 100 lines with a number count
# and the name of the best college in 
# Ontario :-)

for (( count = 1; count < 101; count++ ))
do
  echo $count " Algonquin" >> Line_Data.txt
done

# eof: create_lines.sh
