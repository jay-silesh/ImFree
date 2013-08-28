import receive_packet as rp
import send_packet as sp
import json
import thread
import time
from flask import Flask
import flask
import logging
import os
import sqlite3
from flask import Flask, request, session, g, redirect, url_for, \
     abort, render_template, flash

from contextlib import closing
import db_operations as dbo
import DEFS


# configuration
DATABASE = '/tmp/flaskr.db'
DEBUG = True
app=Flask(__name__)
app.config.from_object(__name__)

cur_dir=os.getcwd()
error_file_name=cur_dir+"/error.log"
file_handler = logging.FileHandler(filename=error_file_name)
file_handler.setLevel(logging.WARNING)
app.logger.addHandler(file_handler)


def connect_db():
	return sqlite3.connect(app.config['DATABASE'])


@app.route('/reset')
def init_db():
    with closing(connect_db()) as db:
        with app.open_resource('schema.sql', mode='r') as f:
            db.cursor().executescript(f.read())
        db.commit()
    print "Finished initializing DB..."

@app.route('/')
def show_entries():
    entries=dbo.get_data(g)
    
   
    entries2=dbo.get_rank(g)

   
    return render_template('show_entries.html', entries=entries,entriess=entries2)


@app.before_request
def before_request():
    g.db = connect_db()
    
@app.teardown_request
def teardown_request(exception):
    db = getattr(g, 'db', None)
    if db is not None:
        db.close()
    

@app.route('/test')
def test():
	print "Server working...."
	return "Hello World"


@app.route("/send_pac", methods=['POST'])
def rec_pack():
	print "Entered right"
	temp=""
	temp_packet=None
	decoded=None
	if flask.request.method == 'POST':
		fname = flask.request.data
		if fname:
			try:
				decoded = json.loads(fname)
			
			except (ValueError, KeyError, TypeError):
				print "JSON format error in the rec_pac function"
	temp_packet=rp.receive_packet(g,decoded)
	return temp_packet
    		


if __name__=="__main__":

	
	DEFS.init()
	
	if(not os.path.isfile(DATABASE)):
		print "Initializing the DB"
	init_db()

	port = int(os.environ.get('PORT', 5000))
	if port == 5000:
		app.debug = True
	app.run(host='0.0.0.0',port=port)

	