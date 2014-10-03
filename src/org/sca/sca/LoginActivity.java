package org.sca.sca;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.sca.sca.model.ApiLoginConnection;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

	EditText etCorreo, etPasswd;
	TextView tvRemenberPass, tvRegister;
	Button btnLogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		etCorreo = (EditText) findViewById(R.id.editTextLoginemail);
		etPasswd = (EditText) findViewById(R.id.editTextLoginPasswd);
		
		tvRemenberPass = (TextView) findViewById(R.id.textViewLoginRememberPass);
		tvRegister = (TextView) findViewById(R.id.textViewLoginRegister);
		
		btnLogin = (Button) findViewById(R.id.btnLoginLogin);
		
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new Task().execute();
				
			}
		});
		
		tvRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(i);
				
			}
		});
		
	}
	
	private String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
    } 

	
	private String convertSha1(String data){
		
		try {
			MessageDigest dsha1= MessageDigest.getInstance("SHA1");
			dsha1.update(data.getBytes("ASCII"));
			byte[] dat = dsha1.digest();
			
			return convertToHex(dat);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "";
	}
	
	class Task extends AsyncTask<Void, Void, Void>{
		
		@Override
		protected Void doInBackground(Void... params) {
			Log.e("SAFE Asyn", etCorreo.getText().toString() +" Pass: "+ convertSha1(etPasswd.getText().toString()));
			ApiLoginConnection.getInstance("tp=10101&", etCorreo.getText().toString(), convertSha1(etPasswd.getText().toString()), getApplicationContext());
			return null;
		}
		
	}
}
