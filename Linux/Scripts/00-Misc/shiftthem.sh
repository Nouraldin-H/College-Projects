#!/bin/bash
# Filename : shiftthem.sh
# Date     : 15 Nov 2021
# Updated  : 30 Mar 2022, added for loop
# Purpose  : To demonstrate parameter shifting

if [ $# -lt 1 ]
   then
   echo 'Call the script with upto five parameters'
   echo 'enclose parameters with spaces in single quotes'
   echo "For example: 'brussels sprout'"
   echo 'Usage: shiftthem.sh broccoli kale cabbage sprouts'
fi

for (( count = 5; count >= 1; count-- ))
do
  echo $1 $2 $3 $4 $5
  shift 1
done

echo "Nothing remaining, all shifted" $1 $2 $3 $4 $5

# eof : shiftthem.sh
