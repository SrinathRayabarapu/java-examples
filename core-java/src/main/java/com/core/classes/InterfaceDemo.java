package com.core.classes;

/**
 * interfaces can extend
 */
public class InterfaceDemo {

	public static void main(String[] args) {
		new Student().teachSinger();
		new Student().teachArtist();
		new Student().teachPlay();
	}
}

class Student implements Player {
	public void teachPlay() {
		System.out.println("I can play");
	}

	public void teachSinger() {
		System.out.println("I can Sing");
	}

	public void teachArtist() {
		System.out.println("I can Art");
	}
}

interface Player extends Singer, Artist {
	void teachPlay();
}

interface Singer {
	void teachSinger();
}

interface Artist {
	void teachArtist();
}
