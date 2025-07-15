#!/bin/bash
# Filename : mul_div.sh
# Takes command line argument to multiply or divide
# Date : 22 Mar 2021
# Update : 7 Nov 2021
# Author : S I'Aret

# multiply function calculates the product
multiply() {
   (( product = $1 * $2 ))  
   echo "Product of $1 and $2 is " $product
}

# divide function calculates the quotient
divide() {
   (( quotient = $1 / $2 ))  
   echo "Quotient of $1 and $2 is " $quotient
}

if [ $# -ne 3 ]
  then
  echo "Incorrect Number of Parameters"
  echo "Usage: mul_div 4 x 6"
  echo "Usage: mul_div 21 / 3"  
fi


if [ $# -eq 3 ]  # check number of arguments at command line
   then
   if [ $2 = 'x' ]
   then 
      multiply $1 $3
   elif [ $2 = '/' ]
   then
      divide $1 $3
   else 
      echo "Incorrect Operator" $2
      echo "x to multiply"
      echo "/ to divide"
      echo "Do not use * to multiply"
   fi
fi

# eof: mul_div.sh
