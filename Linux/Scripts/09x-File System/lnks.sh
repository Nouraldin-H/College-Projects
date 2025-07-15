#!/bin/bash
# filename: lnks.sh
# Page 404, Sobell, 4e
# Identify links to a file
# Usage: lnks file [directory]

if [ $# -eq 0 -o $# -gt 2 ]; then
   echo "Usage: lnks.sh file [directory]" 1>&2
   exit 1
fi

if [ -d "$1" ]; then
  echo "First arguement cannot be a directory." 1>&2
  echo "Usage: lnks.sh file [directory]" 1>&2
  exit 1
else
  file="$1"
fi

if [ $# -eq 1 ]; then
   directory="."
   elif [ -d "$2" ]; then
   directory="$2"
   else
   echo "Optional second arguement must be a directory." 1>&2
   echo "Usage: lnks file [direcotry]" 1>&2
   exit 1
fi

# Check if file exists and is an ordinary file:
if [ ! -f "$file" ]; then
   echo "lnks.sh: $file not found or is a special file" 1>&2
   exit 1
fi

# Check link count on file
set -- $(ls -l "$file")
linkcount=$2
if [ "$linkcount" -eq 1 ]; then
   echo "lnks.sh: no hard links to $file" 1>&2
   exit 0
fi

# Hard links do exist
# Get inode of file
set $(ls -i "$file")

inode=$1

# Find and print the files with inode number
echo "lnks.sh using find to search for links..." 1>&2
find "$directory" -xdev -inum $inode -print

# eof: lnks.sh
