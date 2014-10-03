package org.sca.sca.util;

import android.content.Context;
import android.content.SharedPreferences;



public class Token {

	final String name_token_a= "token_a";
	final String name_token_b= "token_b";
	final String name_session= "session";
	final String name= "michita";
	private static Token t;
	private SharedPreferences token;
	
	private Token(Context context){
		token = context.getSharedPreferences(name, Context.MODE_PRIVATE);
	}
	
	public static Token getTokenInitial(Context c){
		
		if(Token.t == null)
		{
			t= new Token(c);
		}
		
		return t;	
	}
	
	public void update(String tka, String tkb, String session){
		SharedPreferences.Editor editor= token.edit();
		editor.putString(name_token_a, tka);
		editor.putString(name_token_b, tkb);
		editor.putString(name_session, session);
		editor.commit();
	}
	
	public String getToken_a(){
		return token.getString(name_token_a, "None");
	}
	public String getToken_b(){
		return token.getString(name_token_b, "None");
	}
	public String getSession(){
		return token.getString(name_session, "None");
	}
}