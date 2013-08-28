import cur_process as curp


INITIAL_PACKET="0"
DATA_PACKET="2"


mac_address="00:00:00:00:00"
device_name="Python_Server"




def init():
	global cur_proc
	cur_proc=curp.cur_process()