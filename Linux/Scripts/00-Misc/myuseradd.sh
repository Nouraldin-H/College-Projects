#!/bin/bash
# Filename : myuseradd.sh
# 25 Mar 2021
# to catch the error code and store it in a variable
# run the script as source to see the variable my_err
# run the script twice, 
# the error code should be 9, user exists
# error code will be exported to the shell
# check it using 
# env | grep my_err

sudo useradd -m -d /home/temper -s /bin/bash temper
export my_err=$(echo $?)
echo "My Err is :" $my_err

# eof: myuseradd.sh
