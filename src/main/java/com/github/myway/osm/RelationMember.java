package com.github.myway.osm;

import lombok.Data;

@Data
public class RelationMember {
	private String type;
	private String reF;
	private String role;
	
	private Node node;
	private Way way;
	private Relation relation;
}
