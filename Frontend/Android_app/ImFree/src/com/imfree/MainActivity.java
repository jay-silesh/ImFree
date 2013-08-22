package com.imfree;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String checkk=check_json();
		final String send_json=checkk;
		TextView text=(TextView) findViewById(R.id.textView2);
		if(checkk==null)
		{
			Log.d("TEST_OUTPUT","NULL!!!");
		}
		else
		{
			text.setText(checkk);
		}
		
		final Packet pac=new Packet();
		
		Button but1=(Button) findViewById(R.id.button1);
		but1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pac.send_packet(send_json);
			}
		});
		
		
		
	
	}

	private String check_json() {
		// TODO Auto-generated method stub
		try {
            /*
			JSONObject parent = new JSONObject();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("lv1");
            jsonArray.put("lv2");

            jsonObject.put("mk1", "mv1");
            jsonObject.put("mk2", jsonArray);
            parent.put("k2", jsonObject);
            */
			
			
			JSONObject parent=new JSONObject();
			parent.put("mac_address","00:00:00:00:00");
			parent.put("device_name","Python_server");
			parent.put("program_type","1");
			
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
