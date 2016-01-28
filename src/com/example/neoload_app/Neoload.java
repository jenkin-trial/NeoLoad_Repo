package com.example.neoload_app;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Neoload extends Activity implements OnClickListener{
Button b;
EditText getURl;
ViewPager mViewPager;
CustomPagerAdapter mCustomPagerAdapter;
Timer timer;
int page =0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		b = (Button) findViewById(R.id.submit);
		b.setOnClickListener(this);
		getURl = (EditText) findViewById(R.id.seturl);
		// slider

		mCustomPagerAdapter = new CustomPagerAdapter(this);




		mViewPager = (ViewPager) findViewById(R.id.pager);

		mViewPager.setAdapter(mCustomPagerAdapter);

		pageSwitcher(3);


	}
	public void pageSwitcher(int seconds) {

		timer = new Timer(); // At this line a new Thread will be created

		timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay

		// in

		// milliseconds

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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//goToUrl ( "http://www.starwoodhotels.com/");
		//goToUrl ( "http://www.eon.com/en.html");
		goToUrl(getURl.getText().toString());
		 
		 
		 
	}
	 private void goToUrl (String url) {
	        Uri uriUrl = Uri.parse(url);
	        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
	        startActivity(launchBrowser);
	    }
	 
	 
	 class RemindTask extends TimerTask {




		 @Override

		 public void run() {




		 // As the TimerTask run on a seprate thread from UI thread we have

		 // to call runOnUiThread to do work on UI thread.

		 runOnUiThread(new Runnable() {

		 @Override

		 public void run() {




		 if (page > 4) { // In my case the number of pages are 5

		 // timer.cancel();

		 page = 0;

		 // Showing a toast for just testing purpose

		 /*

		 * Toast.makeText(getApplicationContext(),

		 * "Timer stoped", Toast.LENGTH_LONG).show();

		 */

		 } else {

		 mViewPager.setCurrentItem(page++);




		 }

		 }

		 });




		 }

		 }


	 
}
