package com.sockethttp.ws.rest.service;

import com.sockethttp.ws.rest.vo.VOUser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestClient {

    public static void main(String[] args) {
        VOUser vo = new VOUser();
        vo.setUser("admin");
        vo.setPassword("1234");
        vo.setStatus(false);

        ClientConfig config = new DefaultClientConfig();
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);//para castear

        Client client = Client.create(config);
        WebResource webRes = client.resource("http://localhost:8080/44908/rest/login/validation");
        
        ClientResponse response = webRes.type("application/json").post(ClientResponse.class, vo);//get
        vo = response.getEntity(VOUser.class);
        System.out.print("********** Response: [USUARIO: "+vo.getUser()+"] \r\n");
        System.out.print("********** Response: [user is valid: "+vo.isStatus()+"]\r\n");

        //testing rest get
        
        try {

        	 /*URIBuilder builder = new URIBuilder();
        	    builder.setScheme("https")
        	        .setHost("api.insideview.com")
        	        .setPath("/api/v1")
        	        .setParameter("people", peopleId)
        	        .setParameter("active", "true")
        	    URI uri = builder.build();*/
    		URL url = new URL("http://localhost:8080/44908/rest/login/message/?user="+vo.getUser()+"&pass="+vo.isStatus());
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    		conn.setRequestMethod("GET");
    		conn.setRequestProperty("Accept", "application/json");

    		if (conn.getResponseCode() != 200) {
    			throw new RuntimeException("Failed : HTTP error code : "
    					+ conn.getResponseCode());
    		}

    		BufferedReader br = new BufferedReader(new InputStreamReader(
    			(conn.getInputStream())));

    		String output;
    		System.out.println("Output from Server .... \n");
    		while ((output = br.readLine()) != null) {
    			System.out.println(output);
    		}

    		conn.disconnect();

    	  } catch (MalformedURLException e) {

    		e.printStackTrace();

    	  } catch (IOException e) {

    		e.printStackTrace();

    	  }
        
    }

}
