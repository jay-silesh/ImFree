import create_packet as cp
import DEFS
import db_operations as dbo


def data_packet(g):
	temp= cp.create_packet("00:00:00:00:00","Python_server","Prime","1","NULL")
	return temp

def receive_packet(g,packet_data):
	start_entry=packet_data['start_entry']
	
	if(packet_data['packet_type']==DEFS.DATA_PACKET):
		dbo.insert_data(g,packet_data)
		DEFS.cur_proc.remove_element(start_entry)

	return data_packet(g)