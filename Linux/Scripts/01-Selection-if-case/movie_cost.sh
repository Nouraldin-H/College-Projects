#!/bin/bash
# filename : movie_cost.sh
# Determine the price of an admission ticket
# based on the age of the customer
# updated : 22 Nov 2021

(( childprice = 5 ))   # age 0 to 12
(( adultprice = 10 ))  # age 13 to 59
(( seniorprice = 6 ))  # age 60 to 99

read -p "Enter your age: " age

case $age in

# the next two lines will not evaluate the age
# incorrect regex
[13-59]) echo "Senior Price does not work" $seniorprice ;;
[0-12]) echo "Child Price does not work" $childprice ;;

[0-9]|[1][0-2])      echo "Child Price"  $childprice ;;
[1][3-9]|[2-5][0-9]) echo "Adult Price" $adultprice ;;
[6-9][0-9])          echo "Senior Price" $seniorprice ;;

*) echo "Incorrect Age" ;;

esac


# eof: movie_cost.sh
