package com.github.myway.osm;

import java.lang.reflect.Member;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Relation extends Tagged {
	private List<Member> members;
}
