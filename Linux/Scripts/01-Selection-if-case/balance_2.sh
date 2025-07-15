#!/bin/bash
# Filename: balance.sh
# Author  : S I'Aret
# Date    : 4 Mar 2021
# 

echo "Enter Balance :"
read balance

if [ $balance -eq 0 ]
  then 
  echo "Sleep well, you don't owe any amount"
elif [ $balance -gt 0 ]
  then
  echo "You have a Credit Balance"
  # this check is redundant
elif [ $balance -lt 0 ]
  then
  echo "You have a Debit Balance"
fi


# eof: balance.sh
