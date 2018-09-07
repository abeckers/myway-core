package com.github.myway.core;

import lombok.Data;

@Data
public class BoundingBox {
	private double latitudeMin;
	private double latitudeMax;
	private double longitudeMin;
	private double longitudeMax;

	public static BoundingBox join(BoundingBox bbx1, BoundingBox bbx2) {
		BoundingBox bbxn = new BoundingBox();
		bbxn.setLatitudeMax(bbx1.getLatitudeMax());
		bbxn.setLatitudeMin(bbx1.getLatitudeMin());
		bbxn.setLongitudeMax(bbx1.getLongitudeMax());
		bbxn.setLongitudeMin(bbx1.getLongitudeMin());
		if (bbx2.getLatitudeMin() < bbxn.getLatitudeMin()) {
			bbxn.setLatitudeMin(bbx2.getLatitudeMin());
		}
		if (bbx2.getLatitudeMax() > bbxn.getLatitudeMax()) {
			bbxn.setLatitudeMax(bbx2.getLatitudeMax());
		}
		if (bbx2.getLongitudeMin() < bbxn.getLongitudeMin()) {
			bbxn.setLongitudeMin(bbx2.getLongitudeMin());
		}
		if (bbx2.getLongitudeMax() > bbxn.getLongitudeMax()) {
			bbxn.setLongitudeMax(bbx2.getLongitudeMax());
		}
		System.out.println(bbx1 + " + " + bbx2 + " => " + bbxn);
		return bbxn;
	}

	public static BoundingBox join(BoundingBox bbx, Location point) {
		BoundingBox bbxn = new BoundingBox();
		bbxn.setLatitudeMax(bbx.getLatitudeMax());
		bbxn.setLatitudeMin(bbx.getLatitudeMin());
		bbxn.setLongitudeMax(bbx.getLongitudeMax());
		bbxn.setLongitudeMin(bbx.getLongitudeMin());
		if (point.getLatitude() < bbxn.getLatitudeMin()) {
			bbxn.setLatitudeMin(point.getLatitude());
		}
		if (point.getLatitude() > bbxn.getLatitudeMax()) {
			bbxn.setLatitudeMax(point.getLatitude());
		}
		if (point.getLongitude() < bbxn.getLongitudeMin()) {
			bbxn.setLongitudeMin(point.getLongitude());
		}
		if (point.getLongitude() > bbxn.getLongitudeMax()) {
			bbxn.setLongitudeMax(point.getLongitude());
		}
		System.out.println(bbx + " + " + point + " => " + bbxn);
		return bbxn;
	}

	public static BoundingBox fromPoint(Location point) {
		BoundingBox bbx = new BoundingBox();
		bbx.setLatitudeMax(point.getLatitude());
		bbx.setLatitudeMin(point.getLatitude());
		bbx.setLongitudeMax(point.getLongitude());
		bbx.setLongitudeMin(point.getLongitude());
		System.out.println(point + " => " + bbx);
		return bbx;
	}
}
