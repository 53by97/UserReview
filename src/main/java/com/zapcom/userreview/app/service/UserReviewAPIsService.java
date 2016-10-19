package com.zapcom.userreview.app.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class UserReviewAPIsService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserReviewAPIsService.class);

	private Gson gson = new Gson();

	public String getDataByHotelName(String name) {
		Map<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("Srimanta", "Sahu");
		dataMap.put("Key", "Zap");
		return gson.toJson(dataMap);
	}

}
