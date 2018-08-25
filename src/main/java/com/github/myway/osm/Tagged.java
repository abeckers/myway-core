package com.github.myway.osm;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Tagged {
	private String id;
	private Map<String, String> tags = new HashMap<>();
}
