import create_packet as cp
import DEFS
import db_operations as dbo


def first_packet(g):
	cur = g.db.execute('select end_entry,start_entry,device_name from entries order by end_entry desc')
	last_end_entry=None
	if cur is not None:
		last_end_entry=-1
	else:
		last_end_entry=cur.fetchall()[0][0]

	return cp.create_packet("00:00:00:00:00","Python_server","Prime","1","NULL",last_end_entry+1,90000)

def data_packet(g):
	cur = g.db.execute('select end_entry,start_entry,device_name from entries order by end_entry desc')
	last_end_entry=cur.fetchall()[0][0]
	return cp.create_packet("00:00:00:00:00","Python_server","Prime","1","NULL",last_end_entry+1,99999)


def receive_packet(g,packet_data):
	if(packet_data['packet_type']==DEFS.INITIAL_PACKET):
		return first_packet(g)
	elif(packet_data['packet_type']==DEFS.DATA_PACKET):
		dbo.insert_data(g,packet_data)
		return data_packet(g)