
# 15 Feb 2021
# To verify that the number of arguments are two
# the command and directory name
# will exit with status 0 if true

if test $# -eq 0
  then
  echo "Usage: command must have atleast one agruement" 
  exit 1
fi

