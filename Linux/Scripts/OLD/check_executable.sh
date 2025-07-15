# checks if the file is executable

if test -x checkargs.sh
  then
  echo "shell script checkargs.sh is executable"
  exit 0
else
  echo "shell script checkargs.sh does not have execute permission"
  exit 1
fi
