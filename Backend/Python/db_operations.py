

def insert_data(g,decoded):
	g.db.execute('insert into entries (end_entry, start_entry,device_name,cal_time) values (?, ?,?,?)',
                 [decoded['end_entry'],decoded['start_entry'], decoded['device_name'],decoded['cal_time'] ])
	g.db.commit()


def get_data(g):
	cur = g.db.execute('select end_entry,start_entry,device_name,cal_time from entries order by end_entry desc')
	entries = [dict(end_entry=row[0], start_entry=row[1],device_name=row[2],cal_time=row[3]) for row in cur.fetchall()] 
	return entries

def delete_data(g,decoded,decoded_key):
	temp='delete from entries where '+decoded_key+'='+decoded[decoded_key]
	cur = g.db.execute(temp)

def get_rank(g):
	cur = g.db.execute('select device_name,COUNT(device_name) as cc,sum(cal_time) as tot from entries group by device_name order by cc desc')
	entries = [dict(dev_entry=row[0],total_count=row[1],total_time=row[2]) for row in cur.fetchall()] 
	return entries