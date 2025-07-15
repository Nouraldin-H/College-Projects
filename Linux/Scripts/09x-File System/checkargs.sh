#!/bin/bash
# Purpose : To verify that there are two arguments
# the command and directory name
# will exit with status 0 if true
# Date : 10 Mar 2022, 15 Feb 2021

if test $# -eq 0
  then
  echo "Usage: command must have atleast one arguement" 
  exit 1
fi

exit 0

# eof: check_args.sh

