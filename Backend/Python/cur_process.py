

class cur_process:
	
	def __init__(self):
		self.cur_data=[]
		self.next_data=0

	def get_next(self):
		temp=self.next_data
		self.cur_data.append(temp)
		self.next_data=self.cur_data[-1]+10251
		return temp

	def remove_element(self,remove_element):		
		remove_element=int(remove_element)
		if remove_element in self.cur_data:
			temp_index=self.cur_data.index(remove_element)
			self.cur_data.pop(temp_index-1)		
