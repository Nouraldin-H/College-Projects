#!/bin/bash
# Filename : traverse_array.sh
# Date     : 6 April 2022

read -p "Total number of entries: " total
for (( n = 0; n < $total; n++ ))
do
   read -p "Enter Value: " fruit[$n]
done

# traverse the array
echo
echo "Displaying array elements:"
for (( n = 0; n < $total; n++ ))
do
   echo ${fruit[n]}
done

echo "Total Elements displayed: " $(echo ${#fruit[*]})

# eof : traverse_array.sh
