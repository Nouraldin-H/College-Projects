#!/bin/bash
# FileName: tax.sh 
# Date : 1 Mar 2021
# Author: Vixen Taar
# Student ID: 010-375-188
# Semester: Winter 2021
# Comments:
# Accepts four numerical values from user
# performs simple arithmetic operations
# prints outcomes
# Updates Required: Validate user inputs
# Explore other avenues to happy retirement besides $$$

# get values from user
echo "Enter Age (0 to 120):"
   read Age

TotalIncome=45000

if [ $Age -ge 65 ] && [ $TotalIncome -ge 45000 ]
   then
   echo "Happy Retiree"
fi

# eof: tax.sh
