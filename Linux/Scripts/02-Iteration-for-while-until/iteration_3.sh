#!/bin/bash
# Date     : 14 Mar 2021
# Filename : iteration_3.sh
# Illustrates iteration - until 

dow=1   # Day of Week 
until [ $dow -gt 7 ]
   do
   echo -n "$dow" " "
   (( dow += 1 )) # increment by 1
   done
echo

# eof: iteration_3.sh
