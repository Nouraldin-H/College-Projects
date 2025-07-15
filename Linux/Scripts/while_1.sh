#!/bin/bash
# Filename : while_1.sh
# Date     : 31 Mar 2022
# Demonstrate while loop with menu options

displaymenu() {
   clear
   echo "A. Option A"
   echo "B. Option B"
   echo "Q. Quit"
}

choiceA(){
   echo "Inside function A"
   sleep 3
}

choiceB(){
   echo "Inside function B"
   sleep 3
}

loopcondition=TRUE
while [ $loopcondition == TRUE ]
do
   displaymenu
   read -p "Enter your choice: " choice
   if [ $choice = "A" ] || [ $choice = "a" ] ; then
      choiceA
   elif [ $choice = "B" ] || [ $choice = "b" ] ; then
      choiceB
   elif [ $choice = "Q" ] || [ $choice = "q" ] ; then
      echo "Quitting"
      sleep 3
      (( loopcondition = FALSE ))
   fi
done

# eof: while_1.sh
