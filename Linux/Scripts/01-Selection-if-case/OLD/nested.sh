#!/bin/bash
# nested.sh

seven=7
eight=8
nine=10

if [ $seven = 7 ]
  then
  echo "Seven is: " $seven
  
  if [ $eight = 8 ]
    then
    echo "Eigth is: " $eight
  fi

  if [ $nine -ne 9 ]
    then
    echo "Nine is not 9 but it is: " $nine
  fi
fi

# eof: nested.sh
