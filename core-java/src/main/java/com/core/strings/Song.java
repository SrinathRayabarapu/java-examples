package com.core.strings;

public class Song implements Comparable<Song> {
	String title;
	String artist;
	String rating;
	String bpm;

	public int compareTo(Song song) {
		return artist.compareTo(song.getArtist());
	}

	public Song(String t, String a, String r, String b) {
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}

	public String getArtist() {
		return artist;
	}

	public String getBpm() {
		return bpm;
	}

	public String getRating() {
		return rating;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return title;
	}
}