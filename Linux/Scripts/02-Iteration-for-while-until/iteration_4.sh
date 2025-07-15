#!/bin/bash
# Filename : iteration_4.sh
# Date : 14 Mar 2021
# Illustrates iteration - for 
# increment is done in the for structure
# Trap: The open brace should have the first iteration 
# immediately after it, i.e. do not put 
# a space between the first iteration and the brace.

# uncomment any one for construct
# for dow in {1..7..1}
# for (( dow = 1; dow <=7; dow++ ))
for dow in 1 2 3 4 5 6 7
  do
  echo -n "$dow" " "
  done
echo

# eof: iteration_4.sh
