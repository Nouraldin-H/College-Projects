#!/bin/bash
# Filename : createfile.sh
# Date 23 Nov 2021
# creates 100 files
# inserts 7 paragraphs of lorem ipsum in each file
# each time the script is run, data is appended to
# each file

const_y="file"
for (( x=0; x<=99; x++ ))
do
  if [ $x -le 9 ]  
    then
    y=$const_y"00$x"
  elif [ $x -ge 10 ] && [ $x -le 99 ]
    then
    y=$const_y"0$x"
  fi
    
  #touch "$y"
  lorem -p 7 >> "$y"
    
done

# eof: createfile.sh
