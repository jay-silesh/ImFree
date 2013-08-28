package com.imfree;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class Packet {

	private String ip_address,port_no,complete_address;
	
	public Packet() {
		// TODO Auto-generated constructor stub
		ip_address=MainActivity.temp_input_ip;
		port_no=MainActivity.temp_input_port;
		complete_address="http://"+ip_address+":"+port_no+"/";
		Log.d("Output after the packet is finished",complete_address);

	}
	
	
	

	public void send_packet(String json)
	{
		/*
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
		System.out.println(Arrays.toString(threadArray));
		*/
		new MyAsyncTask().execute(json);
    }
	
	private class MyAsyncTask extends AsyncTask<String, Integer, Double>{
		 
		@Override
		protected Double doInBackground(String... params) {
			// TODO Auto-generated method stub
			postData(params[0]);
			return null;
		}
 
		public void postData(String valueIWantToSend) {
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			String send_address=complete_address+"send_pac";
			Log.d("Address while doing the postaat",send_address);
			HttpPost httppost = new HttpPost(send_address);
 
			try {
				// Add your data
				StringEntity se = new StringEntity( valueIWantToSend);  
	            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
	            httppost.setEntity(se);
 
				// Execute HTTP Post Request
				ResponseHandler<String> responseHandler=new BasicResponseHandler();
				
				String response = httpclient.execute(httppost,responseHandler);
				JSONObject response_body = null;
				try {
					response_body = new JSONObject(response);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Rec_packet.rec_packet(response.toString());
				
				
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		}
		
		
		
		
		
		
		
 
	}

}
	
	
