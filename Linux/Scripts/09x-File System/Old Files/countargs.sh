#!/bin/bash
# Filename : countargs.sh
# Purpose : To demonstrate number of arguements 
# Date : 22 Mar 2022

if [ $# -eq 0 ]
  then
  echo "Did not find any agruements"
elif [ $# -eq 1 ]
  then
  echo "Found one arguement, $1"
elif [ $# -eq 2 ]
  then
  echo "Found two arguements, they are $1 and $2"
elif [ $# -eq 3 ]
  then
  echo "Found three arguements, they are $1, $2 and $3"
elif [ $# -gt 3 ]
  then
  echo "Found more than three arguements, the first three are $1, $2 and $3"
fi

exit 0

# eof: check_args.sh

