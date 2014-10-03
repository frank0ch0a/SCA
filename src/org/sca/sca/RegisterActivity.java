package org.sca.sca;

import org.sca.sca.model.ApiRegisterConnection;
import org.sca.sca.util.Token;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {

	Button btnRegister;
	EditText name, lastname, passwd, email;
	TextView login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		name = (EditText) findViewById(R.id.editTextName);
		lastname = (EditText) findViewById(R.id.editTextLastName);
		passwd = (EditText) findViewById(R.id.editTextPassword);
		email = (EditText) findViewById(R.id.editTextEmail);
		
		login = (TextView) findViewById(R.id.textViewSesion);
		
		Log.e("SAFE Token_A", Token.getTokenInitial(this).getToken_a());
		Log.e("SAFE Token_b", Token.getTokenInitial(this).getToken_b());
		Log.e("SAFE _seesion", Token.getTokenInitial(this).getSession());
		
		btnRegister = (Button) findViewById(R.id.btnRegister);
		
		btnRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.e("SAFE", name.getText().toString());
				Log.e("SAFE", lastname.getText().toString());
				Log.e("SAFE", passwd.getText().toString());
				Log.e("SAFE", email.getText().toString());
				new Task().execute();
			}
		});
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(i);
				
			}
		});
		
	}
	
	class Task extends AsyncTask<Void, Void, Void>
	{

		@Override
		protected Void doInBackground(Void... params) {
			Log.e("SAFE", "todo bien");
			ApiRegisterConnection api = new ApiRegisterConnection().getInstance("tp=10100&", name.getText().toString(), lastname.getText().toString(), passwd.getText().toString(), email.getText().toString(), getApplicationContext());
			return null;
		}
		
	}
}
