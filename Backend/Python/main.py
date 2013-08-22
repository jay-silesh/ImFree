import receive_packet as rp
import send_packet as sp


import json
import thread
import time
from flask import Flask
import flask
import logging
import os
app=Flask(__name__)


cur_dir=os.getcwd()
error_file_name=cur_dir+"/error.log"
file_handler = logging.FileHandler(filename=error_file_name)
file_handler.setLevel(logging.WARNING)
app.logger.addHandler(file_handler)


ax="first"

@app.route('/')
@app.route('/test')
def test():
	print "Server working...."
	return "Hello World"


@app.route('/rett')
def test1():
	print "Entering rett..."
	global ax
	return ax


def start_program():
	"""
	Write any background program in this file...
	"""
	pass



@app.route("/ss", methods=['GET','POST'])
def updateWPProject():
	print "\n\n*********************************************Finally connnected!!.*************************************************\n\n"
	global ax
	if flask.request.method == 'POST':
		fname = flask.request.data
		if fname:
			try:
				decoded = json.loads(fname)
				print json.dumps(decoded, sort_keys=True, indent=4)
				print "JSON parsing example: ", decoded['mac_address']
				ax=decoded['mac_address']
				
			except (ValueError, KeyError, TypeError):
				print "JSON format error"

	print "Finsihed without errors!!"
	return ax
    		




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