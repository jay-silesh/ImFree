import json
import db_operations as dbo
import DEFS

def create_packet(mac_address,device_name,program_type,packet_type,func_call):#,start,end):
	
	start_ele=DEFS.cur_proc.get_next()
	temp_dict={"mac_address":mac_address,\
	"device_name":device_name,\
	"program_type":program_type,\
	"packet_type":packet_type,\
	"end_entry":99999,\
	"start_entry":start_ele}

	
	temp_json=json.dumps(temp_dict)
	return temp_json
	