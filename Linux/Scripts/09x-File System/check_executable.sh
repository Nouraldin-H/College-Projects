#!/bin/bash
# Purpose : checks if the file is executable
# exits with 0 if file has execute permission
# exits with 1 if file does not have execute permission
# Uses traditional syntax
# Date : 10 Mar 2022, 15 Feb 2021

if test -x checkargs.sh
  then
  echo "shell script checkargs.sh is executable"
  exit 0
else
  echo "shell script checkargs.sh does not have execute permission"
  exit 1
fi

# eof: check_executable.sh
