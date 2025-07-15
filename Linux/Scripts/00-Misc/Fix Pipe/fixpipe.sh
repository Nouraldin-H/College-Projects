# Filename: fixpipe.sh
# Comment: script to fix pipe and backslash for non-US keyboards
# Date : 20 Jan 2021
# Author: S I'Aret

# take backup of .bashrc
cp .bashrc .bashrc.bak

# insert xmodmap statement at the end of .bashrc
echo xmodmap -e \"keycode 94 = backslash bar\" >> .bashrc

# run .bashrc
source .bashrc

# eof: fixpipe.sh