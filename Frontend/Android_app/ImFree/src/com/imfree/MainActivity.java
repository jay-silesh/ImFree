package com.imfree;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static String temp_input_ip;
	public static String temp_input_port;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String checkk=create_json("0",0,0,0);
		final String send_json=checkk;
		TextView text=(TextView) findViewById(R.id.textView2);
		final EditText edittext_ip=(EditText) findViewById(R.id.editText1);
		final EditText edittext_port=(EditText) findViewById(R.id.editText2);
		
		edittext_ip.setText("192.168.0.11");
		edittext_port.setText("5000");
		
		if(checkk==null)
		{
			Log.d("TEST_OUTPUT","NULL!!!");
			System.exit(0);
		}
		else
		{
			text.setText(checkk);
		}
		Button request_button=(Button) findViewById(R.id.button1);
		Button stop_button=(Button) findViewById(R.id.button2);
		request_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				temp_input_ip=edittext_ip.getText().toString();
				temp_input_port=edittext_port.getText().toString();
				final Packet pac=new Packet();
				pac.send_packet(send_json);
			}
		});
		
		stop_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
	
	}

	public static String create_json(String packet_type,int end_entry,int start_entry, long cal_time) {
		// TODO Auto-generated method stub
		try {
            JSONObject parent=new JSONObject();
            
            parent.put("mac_address","0000000");
			parent.put("device_name",android.os.Build.MODEL);
			parent.put("program_type","1");
			parent.put("packet_type",packet_type);
			parent.put("end_entry",end_entry);
			parent.put("start_entry",start_entry);
			parent.put("cal_time",cal_time);
			

			/*
			JSONObject program_vars=new JSONObject();
			program_vars.put("func_call","get_time");
			program_vars.put("start","100");
			program_vars.put("end","200");
			
			JSONArray data=new JSONArray();
			data.put("1");
			data.put("3");
			data.put("5");
			data.put("7");
			program_vars.put("data", data);
            
			parent.put("program_data",program_vars);
			
			
            Log.d("output", parent.toString(2));
            //return (parent.toString(2));
            */


            return parent.toString();
		} catch (JSONException e) {
            e.printStackTrace();
        }
		return null;
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	
	

}
