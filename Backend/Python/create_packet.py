import json

def create_packet(mac_address,device_name,program_type,packet_type,func_call,start,end,data):
	temp_dict={"mac_address":mac_address,\
	"device_name":device_name,\
	"program_type":program_type,\
	"packet_type":packet_type,\
	"program_data":{"func_call":func_call,\
	"start":start,\
	"end":end,\
	"data":data}
	}	

	temp_json=json.dumps(temp_dict)

	return temp_json
	