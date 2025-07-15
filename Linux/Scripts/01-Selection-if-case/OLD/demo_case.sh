#!/bin/sh
# demonstrate case statement usage

add_fn() {
   echo 'Inside add function'
   echo 'Perform addition here'
}

subtract_fn() {
   echo 'Inside subtract function'
   echo 'Perform subtraction here'
}


echo "Enter + to add or - to subtract"
read choice

case $choice in
  +)
  add_fn
  ;;
  -)
  subtract_fn
  ;;
  *)
  echo 'Enter + or -'
  ;;
esac




