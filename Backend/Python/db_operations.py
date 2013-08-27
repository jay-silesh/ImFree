

def insert_data(g,decoded):
	print "Inserting data--->",decoded['end_entry'],decoded['start_entry'],decoded['device_name']
	g.db.execute('insert into entries (end_entry,start_entry,device_name) values (?, ?,?)',[decoded['end_entry'], decoded['start_entry'],decoded['device_name']])
	g.db.commit()


def get_data(g):
	cur = g.db.execute('select end_entry,start_entry,device_name from entries order by end_entry desc')
	entries = [dict(end_entry=row[0], start_entry=row[1],device_name=row[2]) for row in cur.fetchall()] 
	return entries