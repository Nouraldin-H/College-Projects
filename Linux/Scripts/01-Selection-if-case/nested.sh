#!/bin/bash
# nested.sh
# demonstrates nested if statements
# updated : 22 Nov 2021

seven=7
eight=8
nine=9

if [ $seven = 7 ]
  then
  echo "Seven is: " $seven
  
  if [ $eight = 8 ]
    then
    echo "Eigth is: " $eight
  fi

  if [ $nine -eq 9 ]
    then
    echo "Nine is not 10 but it is: " $nine
  fi
fi

# eof: nested.sh
