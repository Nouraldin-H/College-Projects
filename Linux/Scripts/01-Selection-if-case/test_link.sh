#!/bin/bash
# Filename : test_link.sh
# 29 Sep 2022
# checks for broken link
# Usage: broken.sh a.lnk
# work in progress

# checks for number of arguements
#if [ $# -lt 1 ] || [ $# -ge 2 ]
if [[ $# -lt 1 || $# -ge 2 ]]
  then
  echo "Usage: broken.sh <link>"
  exit
fi 

# test if the status of symbolic link 
if [[ -h $1 && ! -e $1 ]]
  then echo "$1 is an inactive symbolic link"
else
  echo "$1 is an active symbolic link"
fi

# eof: broken.sh
