#!/bin/bash
# FileName: tax.sh 
# Date : 1 Mar 2021
# Author: Vixen Taar
# Student ID: 010-375-188
# Semester: Winter 2021
# Comments:
# Accepts four numerical values from user
# performs simple arithmetic opeartions
# prints outcomes
# Updates Required: Validate user inputs
# Explore other avenues to happy retirement besides $$$

# get values from user
echo "Enter Age (0 to 120):"
read Age
echo "Enter Annual Income (0 to 70000):"
read Income
echo "Enter Dividend Income (0 to 5000):"
read  DivIncome
echo "Tax Paid"
read TaxPaid
echo "Enter RRSP Contribution (0 to 3000):"
read RRSP

# simple arithmetic calculations
(( TotalIncome = Income + DivIncome ))
(( TotalDeduction = TaxPaid + RRSP ))

echo "Total Income :" $TotalIncome
echo "Total Deduction :" $TotalDeduction

if [ $Age -ge 65 ] && [ $TotalIncome -ge 45000 ]
then
	echo "Happy Retiree"
elif [ $Age -le 25 ] && [ $RRSP -ge 1000 ]
then
	echo "Prudent Saver"
elif [ $Age -ge 65 ] && [ $RRSP -le 500 ]
then
	echo "Suggest Financial Planner"
fi

# eof: tax.sh
