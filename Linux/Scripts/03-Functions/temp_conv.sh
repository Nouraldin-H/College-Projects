#!/bin/bash
# Filename : temp_conv.sh
# Date     : 15 Mar 2021
# Updated  : 20 Mar 2021, exit statement removed.
#            Quit option corrected.
#            initial value of choice corrected.
#          : 7 Nov 2021, spelling corrected
#          : 15 Mar 2022, Commends added.
# Objective: 
# demonstrate functions
# convert temperature from 
#    - celsius to fahrenheit 
#    - fahrenheit to celsius

# simple menu display function
display_menu() {
   clear
   echo ' Temperature Converter '
   echo ' --------------------- '
   echo 'C. Convert Celsius to Fahrenheit'
   echo 'F. Convert Fahrenheit to Celsius '
   echo 'Q. Quit'
   echo ''
   echo -n 'Select C, F or Q: '
}


# function to convert Celcius to Fahrenheit
cels_to_farh() {
   # echo 'inside c to f'
   # uses automatic variable REPLY
   read -p "Enter Temperature " 
   (( temperature = REPLY ))
   (( farh = ( temperature * 9 / 5 ) + 32 )) 
   echo "$temperature Celsius is $farh Fahrenheit"  
   sleep 3
}


# function to convert Fahrenheit to Celcius
farh_to_cels() {
   # echo 'inside f to c'
   read -p "Enter Temperature " farh
   (( cels = ( farh - 32 ) * 5 / 9 )) 
   echo "$farh Fahrenheit is $cels Celsius" 
   sleep 3
}


choice=n   # initialize choice to a dummy value

# accept user choice, call appropriate function
while [ $choice != "Q" ] && [ $choice != "q" ]
do
   display_menu
   read choice

   if [ $choice = 'C' ] || [ $choice = 'c' ]
      then
      cels_to_farh
   elif [ $choice = 'F' ] || [ $choice = 'f' ]
      then
      farh_to_cels
   elif [ $choice != 'Q' ] && [ $choice != 'q' ]
      then
      echo 'Valid options are C, F or [Q]uit'
      sleep 3
   fi

done

# eof: temp_conv.sh
