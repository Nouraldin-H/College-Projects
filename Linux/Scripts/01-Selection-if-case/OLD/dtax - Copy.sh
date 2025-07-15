#!/bin/bash
# filename : sample_assignmnets.sh

Age=35
(( Income = 5000 ))
TaxPaid=3000
RRSP=5000

# simple calculations
(( TotalIncome    = Income  + DivIncome ))
(( TotalDeduction = TaxPaid + RRSP ))

TotalDeduction_1=$TaxPaid+$RRSP
echo "Total Deduction 1: " $TotalDeduction_1

TotalDeduction_2=TaxPaid+RRSP
echo "Total Deduction 2: " $TotalDeduction_2

(( TotalDeduction_3 = TaxPaid + RRSP ))
echo "Total Deduction 3: " $TotalDeduction_3

# eof: sample_assignmnets.sh
