import time
import thread
import os

def print_time(threadname):
	while 1:
		print "Still running -->",threadname
		time.sleep(10)






import json
json_test='{"mac_address":"1.0.0.0.1",\
	"device_name":"Jay S3",\
	"program":"1",\
	"func_call":"get_time()",\
	"start":"200","end":"1000",\
	"data":[1,3,5,7,11,13,17,19]}'

try:
    decoded = json.loads(json_test)
    print json.dumps(decoded, sort_keys=True, indent=4)
    print "JSON parsing example: ", decoded['mac_address']
except (ValueError, KeyError, TypeError):
    print "JSON format error"