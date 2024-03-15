package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController2 {
	
private static final String serviceKey = "Va8g%2BwrI2rBylM2BYEtI2nMGQz0tlWWqvFNg6SiQlqZaMizJqW9jQ15LoKxKTXWaPCs7eqiADX3QMVswr8DMLQ%3D%3D";
	
	@ResponseBody
	@RequestMapping(value="busroute.do", produces = "application/json; charset=utf-8")
	public String tsunamShelter() throws IOException {
		
		System.out.println("controller call");
		
		String url = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
		
		url += "?serviceKey=" +serviceKey;
		url += "&strSrch=" + 3;
		url += "&resultType=json";
		//url += "&ver=1.0";
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));		
		String responseText="";
		String line;
		
		while((line = br.readLine()) != null) {
			responseText += line;
		}
		br.close();
		urlConnection.disconnect();
		
		return responseText;
				
				
	}
}
