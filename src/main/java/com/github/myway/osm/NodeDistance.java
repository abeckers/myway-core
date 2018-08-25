package com.github.myway.osm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NodeDistance {
	private Node node;
	private double distance;
}
