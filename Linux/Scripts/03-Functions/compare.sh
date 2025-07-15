#!/bin/bash
# Filename: compare.sh
# Usage : compare.sh 1 3
# Purpose : To demonstrates use of function and if statements.
# Updated : 10 March 2022
#
compare ()
{
if [ $1 -eq $2 ]
   then
   echo $1 "equals" $2
elif [ $1 -gt $2 ]
   then
   echo $1 "is greater than " $2
   else
   echo $1 "is less than " $2
fi
}

compare $1 $2

# eof: compare.sh
