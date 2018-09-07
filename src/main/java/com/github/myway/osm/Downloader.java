package com.github.myway.osm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Locale;

import com.github.myway.core.BoundingBox;

public class Downloader {
	private static final double ADDITION = 0.002d;
	private static final String OSM_MAP_URL = "https://api.openstreetmap.org/api/0.6/map?bbox=";

	public static void saveMapToFile(BoundingBox bbx, String filename) throws IOException {
		String l = String.format(Locale.US, "%f", bbx.getLongitudeMin() - ADDITION);
		String r = String.format(Locale.US, "%f", bbx.getLongitudeMax() + ADDITION);
		String b = String.format(Locale.US, "%f", bbx.getLatitudeMin() - ADDITION);
		String t = String.format(Locale.US, "%f", bbx.getLatitudeMax() + ADDITION);
		URL url = new URL(OSM_MAP_URL + l + "," + b + "," + r + "," + t);
		try (ReadableByteChannel in = Channels.newChannel(url.openStream());
				FileOutputStream fo = new FileOutputStream(filename);
				FileChannel out = fo.getChannel()) {
			out.transferFrom(in, 0, Long.MAX_VALUE);
		}
	}
}
