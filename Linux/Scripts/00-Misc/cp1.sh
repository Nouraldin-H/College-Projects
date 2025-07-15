#!/bin/bash
error_code=1
while [ ! ] 
do
  if [ -f fileX.txt ] 
     then
     echo "Attempting to copy..."
     cp fileX.txt fileY.txt > /dev/null
     error_code=$?
  else
     error_code=7
  fi

  if [ $error_code -eq 0 ]
  then
     echo "Copy successful"
  elif [ $error_code -ne 0 ]
     then
     echo "Copy failed"
     exit $error_code
  fi
  sleep 1
  break
done


