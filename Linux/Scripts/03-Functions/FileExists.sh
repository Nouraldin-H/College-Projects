#!/bin/bash
# Filename : FileExist.sh
# Objective: To demonstrate return values from a function
# Usage    : FileExist.sh <filename>
# Date     : 10 March 2022, 8 Nov 2021

function FileExist () {
if [ -e $1 ]
  then
  return 0
else
  return 1
fi
}

if FileExist $1
then
   echo $1 "File exists: "
   echo $( ls -l $1 )
else
   echo $1 "File not found."
fi

# eof: FileExist.sh
