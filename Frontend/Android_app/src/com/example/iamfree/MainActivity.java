package com.example.iamfree;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private class ClickButton implements OnClickListener {

		@Override
		public void onClick(View v) {
			int startrange = Integer.parseInt(editText1.getText().toString());
			int endrange = Integer.parseInt(editText2.getText().toString());
			int answer = calculate_prime_numbers(startrange, endrange);
			editText3.setText(Integer.toString(answer));
		}
	}

	EditText editText1;
	EditText editText2;
	EditText editText3;
	Button make_connection_button;
	Button calculate_prime_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);
		make_connection_button = (Button) findViewById(R.id.button1);
		calculate_prime_button = (Button) findViewById(R.id.button2);
		
		calculate_prime_button.setOnClickListener(new ClickButton());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public int calculate_prime_numbers(Integer startrange, Integer endrange) {
		ArrayList<Integer> arr= new ArrayList<Integer>();
		int count = 0;
		for(int i = startrange;i <= endrange;i++){
			if(isPrime(i)) {
				arr.add(i);
				count++;
			}
		}
		return count;
	}

	private boolean isPrime(int i) {
		if(i%2 == 0 && i!=2)
			return false;
		else{
			if(i == 1) return false;
			for(int p=3;p<=i/2;p+=2){
				if(i%p == 0)
					return false;
			}
			return true;
		}
	}

	String get_mac_address()
	{
		WifiManager manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		WifiInfo info = manager.getConnectionInfo();
		String address = info.getMacAddress());
		return address;
	}


}
