#!/bin/bash
# Filename: simple_if.sh
# Updated: 9 March 2022

DayOfWeek=$(date +"%A")
if [ $DayOfWeek = "Saturday" ]
then
   echo "Start of Weekend"
fi 

# eof: simple_if.sh