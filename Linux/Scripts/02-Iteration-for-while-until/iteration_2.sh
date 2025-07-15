#!/bin/bash
# Filename : iteration_2.sh
# Adapted from A Practical Guide to Ubuntu, 4e, Page 1022
# Purpose  : To illustrate the difference between while & until.
# Simply changing while to until does not work.
# The expression in until must evaluate to FALSE
# for the control to enter the loop.
# In this case the control WILL NOT enter to the loop.
# Date     : 10 Mar 2022, 14 Mar 2021 

dow=1   # Day of Week 
until [ $dow -le 7 ]
   do
   echo -n "$dow" " "
   (( dow += 1 )) # increment by 1
   done
echo

# eof: iteration_2.sh
