#!/bin/bash
# File Name: CalculateDays.sh
# Author: Xuejing Duan
# Date : 2022-Oct-19
# Objective : Calculates the number of days between two 
#             given dates. Adds one day to round up the 
#             number of days.
# Future Changes : Backquotes could be replaced with 
#                  Command Substitution.
#                  Use Arithmetic Expressions.


Currentdate=`date +%Y-%m-%d`;
CurrentdateUTC=`date +%s -d "$Currentdate"`;
StartDate="1970-01-01";
StartDateUTC=`date +%s -d $StartDate`;

# get current date from system
echo Current date is: $Currentdate

echo Start date is: $StartDate
echo Current date in UTC is: $CurrentdateUTC seconds
echo Start date in UTC is: $StartDateUTC
UTCbetween=$( expr $CurrentdateUTC - $StartDateUTC );

# 60 x 60 x 24 
SecondsInOneDay=86400;

echo UTC time between current date and start date is: $UTCbetween seconds 
echo The days between current date and start date is: $((($UTCbetween/$SecondsInOneDay)+1))

# eof : CalculateDays.sh
