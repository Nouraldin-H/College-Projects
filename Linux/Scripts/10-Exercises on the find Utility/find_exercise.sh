# Filename : find_exercise.sh
# Date     : 22 Nov 2022
# Purpose  : Creates files for exercise on the "find" utility 

mkdir -p /tmp/kingdom/{protista,plantae,animale}
mkdir -p /tmp/kingdom/plantae/orchidacea/{oncidium,laelia,dendrobium,vanda}
touch /tmp/kingdom/plantae/orchidacea/vanda/{aliceae,alpina,barnesii,furva,punctata}

# change the time stamp to an earlier date.
# then use find utility to locate this order file.
touch -t 198012110000 /tmp/kingdom/plantae/orchidacea/vanda/alpina

# add data to a file
date > /tmp/kingdom/plantae/orchidacea/vanda/barnesii

# add data to a file, then use grep to locate files that
# have this data

echo "blue" > /tmp/kingdom/plantae/orchidacea/vanda/aliceae
echo "red" > /tmp/kingdom/plantae/orchidacea/vanda/punctata
echo "blue" > /tmp/kingdom/plantae/orchidacea/vanda/alpina
echo "blue" > /tmp/kingdom/plantae/orchidacea/vanda/alpina

# eof: find_exercise.sh