package com.spring.openapi.data.service;

import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.spring.common.openapi.URLConnectUtil;
import com.spring.openapi.data.vo.OpenApiDTO;

@Service
public class ShelterServiceImpl implements ShelterService {
	@Override
	public StringBuffer shelterList() throws Exception {
		StringBuffer site = new StringBuffer("http://apis.data.go.kr/1741000/TsunamiShelter4");
		site.append("?" + URLEncoder.encode("serviceKey", "UTF-8")+ "=Va8g%2BwrI2rBylM2BYEtI2nMGQz0tlWWqvFNg6SiQlqZaMizJqW9jQ15LoKxKTXWaPCs7eqiADX3QMVswr8DMLQ%3D%3D");
		site.append("&" + URLEncoder.encode("pageNo","UTF-8")+"=" +URLEncoder.encode("1","UTF-8"));
		site.append("&" + URLEncoder.encode("numOfRows","UTF-8")+ "=" +URLEncoder.encode("2","UTF-8"));
		site.append("&" + URLEncoder.encode("type","UTF-8")+ "=" +URLEncoder.encode("json","UTF-8"));
		
		OpenApiDTO openApi = new OpenApiDTO (site.toString(), "GET");
		StringBuffer result = URLConnectUtil.openAPIData(openApi);
		return result;
	}
}
