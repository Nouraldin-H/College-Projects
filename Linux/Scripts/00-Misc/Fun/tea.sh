#!/bin/bash
# Date: 8 Mar 2021
# Sleeps for 3 minutes, then plays .wav file
# one error in .wav file, hence the redirection 

sleep 180
echo -n "Cha (tea) is ready."

# plays in quiet mode
# download play, and other audio utilites, using 
# sudo apt install sox
play -q ~/Music/01-Vivaldi-Four-Seasons-Spring-1.wav 2>/dev/null &

# eof: tea.sh
