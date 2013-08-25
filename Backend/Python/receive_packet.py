import create_packet as cp
import DEFS



def receive_packet(packet_data):
	if(packet_data['packet_type']==DEFS.INITIAL_PACKET):
		cba,csa,cbaduc,cndu=get_info()
		cp.create_packet(DEFS.mac_adress,DEFS.device_name,)
		def create_packet(mac_address,device_name,program_type,packet_type,func_call,start,end,data):

