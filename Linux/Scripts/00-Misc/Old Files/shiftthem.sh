#!/bin/bash
# Filename : shiftthem.sh
# Date     : 30 Mar 2021, 15 Nov 2021
# Purpose  : To demonstrate parameter shifting

if [ $# -lt 1 ]
   then
   echo 'Call the script with upto five parameters'
   echo 'enclose parameters with spaces in single quotes'
   echo "For example: 'brussels sprout'"
   echo 'Usage: shiftthem.sh broccoli kale cabbage sprouts'
fi
echo $1 $2 $3 $4 $5
shift 1
echo $1 $2 $3 $4 $5

# eof : shiftthem.sh

