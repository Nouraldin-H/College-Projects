#!/bin/bash
# filename: dirfiles.sh
# page 410, Sobell, 4e

for i in *
do
   if [ -d "$i" ]
      then
      echo "$i"
   fi
done

# eof: dirfiles.sh
