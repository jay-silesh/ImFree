import thread
import time

from flask import Flask
import logging
import os
app=Flask(__name__)


file_handler = logging.FileHandler(filename='/home/jay/test/erro.log')
file_handler.setLevel(logging.WARNING)
app.logger.addHandler(file_handler)

a=""

delay_time=2


@app.route('/')
def home():
	return "hello"


@app.route('/welcome')
def welcome():	
	return a

@app.route('/two')
def two():	
	try:
		thread.start_new_thread( print_time, ("Request2",300,400, ) )
	except:
		print "Error : unable to run Request2"
	return "Requested to start the thread..."
	
@app.route('/one')
def one():
	try:
		thread.start_new_thread( print_time, ("Request1",100,200, ) )
	except:
		print "Error: unable to run request1"
	return "Requested to start the thread..."


# Define a function for the thread
def print_time( threadName,range1,range2):
	global a,delay_time
	for x in range(range1,range2):
		print "Running the print_time function with -->",threadName
		time.sleep(delay_time)
		a+=str(x)
		a+=","




if __name__=="__main__":

	print "Starting now..."
	port = int(os.environ.get('PORT', 5000))
	if port == 5000:
		app.debug = True
	
	try:
		thread.start_new_thread( print_time, ("Thread1",0,100, ) )
	except:
		print "Error: unable to start thread"
	

	print "Printing this after the thread is activated"

	app.run(host='0.0.0.0',port=port)

	