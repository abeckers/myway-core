package com.github.myway.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate implements Location {
	private double latitude;
	private double longitude;

	/**
	 * Distance in meters.
	 */
	public double distance(Coordinate b) {
		return Earth.distance(latitude, longitude, b.getLatitude(), b.getLongitude());
	}
}
