!#/bin/bash
# Filename: balance.sh
# Author  : S I'Aret
# Date    : 8 Mar 2022
# Comment: Read credit card balance from user.
# Identify the value and print nessage.
# This script has 5 errors.
# Identify the errors and correct them.


echo "Enter Balance :"
read balance

if [ $balance -eq 0 ]
then 
echo "Sleep well, you don't owe any amount"
fi

if [$balance -gt 0 ]
echo "You have a Credit Balance'
fi

if [ $balance -lt 0 ] then
echo "You have a Debit Balance"
fi

# eof: balance.sh
