#!/bin/bash
# Filename: essentials.sh
# will install essential utilities in Ubuntu
# Author: S I'Aret
# Created: 16 Feb 2021
# Updated: 27 Jan 2022, 20 Jan 2022, 18 Jan 2022, 16 Mar 2021
# 13 Mar 2021, 7 Mar 2021, 23 Feb 2021
# 19 Oct 2022, Notepad++, courtesy Bo Shu

# Note: To uninstall a package use
# sudo apt-get remove <package>

#install updates
sudo apt-get update
 
# VMWare Tools
# should be done in Lab 01
sudo apt install open-vm-tools-desktop

sudo apt install vim

# lorem generates Latin like (meaningless) text
# to be used for testing and learning, e.g. grep
sudo apt install libtext-lorem-perl

# for a visual representation of the file hierarchy
sudo apt install tree

# will install mail utilities
# required user interaction during installation 
# for selecting an option 
# sudo apt install mailutils

# audio player and audio conversion utility
sudo apt install sox

# gcc compiler
# does not install as sudo
# install as root user
# apt install gcc

# once in a while you will type sl instead of ls
# here is a relief
sudo apt install sl

# notepad++
# added 19 Oct 2022
# Note: notepad runs as notepadqq in Linux
sudo apt-get install notepad++

# dos2unix
sudo get-apt install dos2unix

# eof: essentials.sh
