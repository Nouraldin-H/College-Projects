#!/bin/bash
# Filename : wait.sh
# 4 October 2022
# demonstrate wait 
# Question: will it wait for 15 seconds or 30 seconds? i
# Give a reason for your answer.

sleep 10 &
sleep 15 &
sleep 5 &
echo $( date +%T )
wait
echo $( date +%T )

# eof: wait.sh
