import receive_packet as rp
import send_packet as sp



import thread
import time
from flask import Flask
import logging
import os
app=Flask(__name__)


cur_dir=os.getcwd()
error_file_name=cur_dir+"/error.log"
file_handler = logging.FileHandler(filename=error_file_name)
file_handler.setLevel(logging.WARNING)
app.logger.addHandler(file_handler)


@app.route('/')
@app.route('/test')
def test():
	return "Hello World"

def start_program():
	"""
	Write any background program in this file....
	"""
	pass



@app.route('/send_packet')
def rec_packet_from_device():
	rp.rec_packet()





if __name__=="__main__":

	try:
		thread.start_new_thread( start_program, ( ) )
	except:
		print "Error: unable to start Server thread"


	print "The connection is going to start now...."
	port = int(os.environ.get('PORT', 5000))
	if port == 5000:
		app.debug = True
	app.run(host='0.0.0.0',port=port)

	

	






































"""


@app.route('/one')
def one():
	try:
		thread.start_new_thread( print_time, ("Request1",100,200, ) )
	except:
		print "Error: unable to run request1"
	return "Requested to start the thread..."


"""	