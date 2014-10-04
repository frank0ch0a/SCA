package org.sca.sca;

import org.sca.sca.util.Token;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StarViewActivity extends Activity {

	Button btnLogin, btnRegister;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		String token= Token.getTokenInitial(getApplicationContext()).getToken_a();
		Log.e("SAFE -- SAFE", token);
		if( token.equals("None") )
		{
			setContentView(R.layout.activity_start_view);
			
			btnLogin = (Button) findViewById(R.id.btnLogin);
			btnRegister = (Button) findViewById(R.id.btnRegister);
			
			btnLogin.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent(getApplicationContext(), LoginActivity.class);
					startActivity(i);
					finish();
				}
			});
			
			btnRegister.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
					startActivity(i);
					finish();
				}
			}); 
			
			
		}
		else{
		
			Log.e("SAFE -- SAFE Else", Token.getTokenInitial(getApplicationContext()).getToken_a());
			Intent i = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(i);
			finish();
		}
	}
}
