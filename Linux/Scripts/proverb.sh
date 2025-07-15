#!/bin/bash
# Filename : proverb.sh
# Date     : 7 Dec 2022
# A fitting script to run on the last day of class :-)

proverb=( "All's" "wind" "water" "earth" "well" "copper" "iron" "steel" "that" "flower"
"stem" "root" "end's" "hand" "leg" "shoulder" "well" )
for (( count = 0; count <= 4; count++ )) 
do
   FirstFolio[$count]+="${proverb[$count*4]} "
done

echo "${FirstFolio[*]}"

# eof: proverb.sh
