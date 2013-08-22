package com.imfree;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import android.os.AsyncTask;

public class Packet {

	public void send_packet(String json)
	{
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
			HttpPost httppost = new HttpPost("http://10.246.17.158:5000/ss");
 
			try {
				// Add your data
				StringEntity se = new StringEntity( valueIWantToSend);  
	            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
	            httppost.setEntity(se);
 
				// Execute HTTP Post Request
				HttpResponse response = httpclient.execute(httppost);
 
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		}
 
	}

}
	
	
