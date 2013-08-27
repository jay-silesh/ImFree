import create_packet as cp
import DEFS


def first_packet():
	return cp.create_packet("00:00:00:00:00","Python_server","Prime","1","NULL",100,90000)

def real_packet():
	return cp.create_packet("00:00:00:00:00","Python_server","Prime","1","NULL",90001,99999)


def receive_packet(packet_data):
	if(packet_data['packet_type']==DEFS.INITIAL_PACKET):
		return first_packet()
	elif(packet_data['packet_type']==DEFS.REAL_PACKET):
		return data_packet()