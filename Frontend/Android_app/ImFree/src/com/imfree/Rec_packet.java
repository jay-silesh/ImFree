package com.imfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;

public class Rec_packet {

	public static void rec_packet(String json)
	{			
		
		long startTime = System.nanoTime();   
		HashMap<String,String> processed_packet= process_packet(json);
		long cal_time = System.nanoTime() - startTime;
		cal_time= TimeUnit.SECONDS.convert(cal_time, TimeUnit.NANOSECONDS);
		String temp_json_string=MainActivity.create_json(processed_packet.get("packet_type"),Integer.parseInt(processed_packet.get("end_entry")),Integer.parseInt( processed_packet.get("start_entry")),cal_time);
		Packet temp_pack=new Packet();
		temp_pack.send_packet(temp_json_string);
	}

	 static HashMap<String, String> process_packet(String json) {
		// TODO Auto-generated method stub
		HashMap< String, String> temp_map=new HashMap<String, String>();
		try {
			JSONObject obj = new JSONObject(json);
			int start_range=Integer.parseInt( obj.getString("start_entry"));
			ArrayList<String>temp_ll=cal_prime.get_prime_range(start_range);
			
			int ll_size=temp_ll.size();
			temp_map.put("end_entry", temp_ll.get(ll_size-1));
			temp_map.put("start_entry", temp_ll.get(ll_size-2));
			temp_ll.remove(ll_size-1);
			temp_ll.remove(ll_size-2);
			temp_map.put("device_name", android.os.Build.MODEL);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		temp_map.put("packet_type", "2");
		return temp_map;
	}

	
}
