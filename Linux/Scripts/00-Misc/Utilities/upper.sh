#!/bin/bash
# 16 Mar 2021
# converts lower case to upper case
# uses tr utility

read -p "Enter Choice :" choice
uchoice=$( echo $choice | tr [:lower:] [:upper:] )

echo "Your choice is :" $choice
echo "Upper case is  :" $uchoice

# eof: upper.sh
