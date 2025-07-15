#!/bin/bash
# Filename : pid.sh
# Date     : 15 Mar 2021
# Author   : S I'Aret
# displays the current process id and 
# the parent process id.
# run the script 
# 1. on its own 
# 2. using either source pid.sh or . pid.sh 
echo "Parent  Process ID is " $PPID
echo "Current Process ID is " $$

# uncomment the exit command below and
# run the script as . pid.sh or
# source  pid.sh
# observe the results

#exit

# eof: pid.sh
