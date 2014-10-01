package org.sca.sca.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Network {

	HttpClient client;
	String url;

	public Network() {
		client = new DefaultHttpClient();
	}

	public JSONObject getDataJSONObject(String url) {
		client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);

		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();

			if (response.getStatusLine().getStatusCode() == 200) {
				JSONObject json = new JSONObject(EntityUtils.toString(entity));
				return json;
			}

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
