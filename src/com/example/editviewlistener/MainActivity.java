package com.example.editviewlistener;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	String tag = "tag";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText et_text = (EditText) findViewById(R.id.et_text);
		final TextView tv_prompt = (TextView) findViewById(R.id.tv_prompt);

		et_text.addTextChangedListener(new TextWatcher() {

			private String string;

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				Log.i("tag", "onTextChanged.......");
				string = et_text.getText().toString();
				
				
				Log.i(tag, "Êý×Ö£º"+s);
				
				Log.i("tag", "³¤¶È£º"+string.length());
				
				if (string.length() % 2 == 0) {
					tv_prompt
							.setTextColor(getResources().getColor(R.color.red));
				} else {
					tv_prompt.setTextColor(getResources().getColor(
							R.color.tv_settle_state));
				}

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				Log.i("tag", "beforeTextChanged.......");
			}

			@Override
			public void afterTextChanged(Editable s) {
				Log.i("tag", "afterTextChanged.......");
				tv_prompt.setText(string);
			}
		});
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
}
