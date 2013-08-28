package com.imfree;

import java.util.ArrayList;
import java.util.LinkedList;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

public class cal_prime {

	
	
	
	
	
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
	ArrayList<String> all_data=new ArrayList<String>();
	for (int x=start;x<end;x++)
	{
		if(isPrime(x))
			all_primes.add(Integer.toString(x));
	}
	
	
	all_primes.add(Integer.toString(start));
	all_primes.add(Integer.toString(end));	
	return all_primes;
}

static ArrayList<String> get_prime_range(int start)
{
	
	int end=start+(10250);
	String temp="Start->"+start+"  End->"+end;
	Log.d("PRIME_CAL",temp);
	return get_prime_range(start,end);
}



}


