#!/bin/sh
# Purpose: To Illustrate usage of case statement
# User enters an arithmetic operator: +, -
# Based on the choice the arithmetic function 
# add_fn or sub_fn is called.
# Updated : 10 Mar 2022


add_fn() {
   echo 'Inside add function'
   echo 'Perform addition here'
}

subtract_fn() {
   echo 'Inside subtract function'
   echo 'Perform subtraction here'
}


echo "Enter + to add or - to subtract"
read choice

case $choice in
  +)
  add_fn
  ;;
  -)
  subtract_fn
  ;;
  *)
  echo 'Enter + or -'
  ;;
esac

# eof: demo_case.sh


