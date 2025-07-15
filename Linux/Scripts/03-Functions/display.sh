#!/bin/bash
# Filename : DisplayIt.sh
# Purpose: Demonstrate parameter positions
#          swaps the parameters in the function
function DisplayIt()
{
  echo $1 $2
}

DisplayIt $2 $1

# eof: DisplayIt.sh
