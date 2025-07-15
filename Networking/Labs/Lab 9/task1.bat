arp -d *
netsh interface IP delete arpcache
ipconfig /flushdns
arp -a
ipconfig /displaydns
ping eagle-server.example.com
arp -a
ipconfig /displaydns
pause