# FileName : trap_error.sh
# Objective : Sample Code to demonstrate error trapping 
# The useradd command sample can be used in the lab/assignment
# refer useradd manual pages for error codes 
# do not use 2>/dev/null, this statement redirects all errors to
# /dev/null. This script uses this statement so that error codes can be 
# checked later and appropriate error messages displayed.
# Date : 22 Mar 2022
# 
     
read -p 'Username: ' username
read -p 'Home directory: ' homedir
read -p 'Default login shell: ' defaultshell
sudo useradd -d $homedir -m -s $defaultshell $username 2>/dev/null
(( error_code = $? ))
echo "Error code is $error_code"

if [ $error_code -eq 12 ]
   then
   echo "Incorrect pathname"
elif [ $error_code -eq 0 ]
   then
   echo "User $username successfully added."
   tail -1 /etc/passwd
elif [ $error_code -eq 9 ]
   then
   echo "User $username exists in system."
fi
    
# eof : trap_error.sh
