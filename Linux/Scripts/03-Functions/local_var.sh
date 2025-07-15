#!/bin/bash
# Filename : local_var.sh
# Purpose  : To demonstrates the scope of a variable
# Date     : 10 Mar 2022, 7 Nov 2021

# declare function check_x
check_x() {
   local x=5  # declare variable x as local
   echo "Within function check_x.    : " $x
}

(( x = 10 ))
echo "Outside function check_x. 1.: " $x

# call function to check value of x.
check_x

echo "Outside function check_x. 2.: " $x

# eof: local_var.sh
