#!/bin/bash
# filename: display.sh
# Date: 8 Nov 2021
# Verify that parameters passed to a function
# are position dependent.

function Display() {
  echo $1 $2
}

Display $1 $2
Display $2 $1

# eof: display.sh
