package com.core.garbagecollector;

public class GrandFather {
	String age;
	String secret;

	public GrandFather() {
		for (int i = 0; i < 100; i++) {
			age = new String("" + i);
		}
	}

	public String getSecret(String name) {
		if (name.equals("krishna")) {
			return "Gold is Under Tree";
		} else
			return "Go to Hell";
	}

	protected void finalize() throws Throwable {
		new GrandFather().getSecret("krishna");
		// super.finalize();
		// System.out.println("gold is under tree");
	}
}
