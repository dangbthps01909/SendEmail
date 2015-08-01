package com.example.sendemail;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	EditText editTextEailTo;
	EditText editTextEmailSubject;
	EditText editTextEmailContent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		editTextEailTo = (EditText) findViewById(R.id.editTextEmailTo);
		editTextEmailSubject = (EditText) findViewById(R.id.editTextEmailSubject);
		editTextEmailContent = (EditText) findViewById(R.id.editTextEmailContent);
	}
	public void onButtonClickSend(View v){
		 String emailTo 		= editTextEailTo.getText().toString();
		 String emailSubject 	= editTextEmailSubject.getText().toString();
		 String emailContent 	= editTextEmailContent.getText().toString();
		 
		 Intent emailIntent = new Intent(Intent.ACTION_SEND);
		 emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ emailTo});
		 emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
		 emailIntent.putExtra(Intent.EXTRA_TEXT, emailContent);
		 // use below 2 commented lines if need to use BCC an CC feature in email
		 //emailIntent.putExtra(Intent.EXTRA_CC, new String[]{ to});
		 //emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{to});
		 
		 emailIntent.setType("image/jpeg");
		 emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My Picture");
		 emailIntent.putExtra(Intent.EXTRA_STREAM, 
				 Uri.parse("file://sdcard/captureimage.png"));
		 
		 emailIntent.setType("message/rfc822");
		 
		 startActivity(Intent.createChooser(emailIntent, "Select an Email Client:"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
