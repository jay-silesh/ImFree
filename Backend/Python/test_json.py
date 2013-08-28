import time
import thread
import os

def print_time(threadname):
	while 1:
		print "Still running -->",threadname
		time.sleep(10)






import json
json_test2='{"mac_address":"0000000","program_type":"1","start_entry":0,"device_name":"SAMSUNG-SGH-I747","packet_type":"0","end_entry":0}'


json_test='{"mac_address":"1.0.0.0.1",\
	"device_name":"Jay S3",\
	"program":"1",\
	"func_call":"get_time()",\
	"start":"200","end":"1000",\
	"data":[1,3,5,7,11,13,17,19]}'

try:
    decoded = json.loads(json_test2)
    print json.dumps(decoded, sort_keys=True, indent=4)
    print "JSON parsing example:************ "#, decoded['mac_address']
    for x in decoded.keys():
    	print x,decoded[x]




except (ValueError, KeyError, TypeError):
    print "JSON format error"