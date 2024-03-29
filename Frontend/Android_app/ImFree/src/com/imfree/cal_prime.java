package com.imfree;

import java.util.ArrayList;
import java.util.LinkedList;

public class cal_prime {


	
	//fastest no of primes that can be calculated is 46877
	
	
	
static boolean isPrime(int i)
{
	if( (i%2== 0 && (i!=2)) || i==1)
		return false;

	for(int x=3;x<=i/2;x+=2)
	{
		if(i%x==0)
			return false;
	
	}
	return true;
}

static ArrayList<String> get_prime_range(int start,int end)
{
	
	ArrayList<String> all_primes=new ArrayList<String>();
	
	for (int x=start;x<end;x++)
	{
		if(isPrime(x))
			all_primes.add(Integer.toString(x));
	}
	return all_primes;
}

static ArrayList<String> get_prime_range(int start)
{
	int end=start+(10250);
	return get_prime_range(start,end);
}



/*
	def get_prime_time(start_range,cal_time=5):	
		all_primes=[]
		import time
		i=start_range
		flag=True
		
		start=time.time()
		final=0
		while(final<cal_time):
			if(isPrime(i)):
				all_primes.append(i)
			i+=1
			final=time.time()-start	
		return all_primes,i
	
*/
}


