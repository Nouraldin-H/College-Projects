#!/bin/bash
# Objective : To check if the directory /mnt/cdrom exists
# will exit with status 0 if true
# Usage : mountpoint.sh <directory>
# Date : 10 Mar 2022, 15 Feb 2021

if test $# -eq 0
  then
  echo "Usage: mountpoint.sh <directory>"
  exit 1
fi

if test -d /mnt/cdrom
  then
  echo "mount point exists"
  exit 0
fi  

