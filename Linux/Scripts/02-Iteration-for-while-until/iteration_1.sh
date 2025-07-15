#!/bin/bash
# Filename : iteration_1.sh
# Date     : 14 Mar 2021
# Adapted from A Practical Guide to Ubuntu, 4e
# Page 1022
# Displays numbers from 1 to 7
# The loop is run while the condition is TRUE

dow=1   # Day of Week 
while [ $dow -le 7 ]
   do
   echo -n "$dow" " "
   (( dow += 1 )) # increment by 1
   done
echo

# eof: iteration_1.sh
