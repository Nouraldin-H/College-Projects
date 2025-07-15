#!/bin/bash
# Filename : global_var.sh
# Purpose  : Demonstrates the scope of a variable
# Date     : Winter 2021
# Updated  : 7 Nov 2021

check_x() {
   (( x = 5 ))
   echo "Inside function check_x: " $x
}

(( x = 10 ))
echo "Outside function check_x: " $x

check_x

echo "Outside function check_x: " $x

# eof: global_var.sh
