package com.core.garbagecollector;

public class WealthyKing {
	public String getSecrete(String string) {
		if (string.endsWith("srinath"))
			return "Diamonds are in Wallet beneath the Pond!!";
		else {
			return "Go and kill your self by jumping into Pond.";
		}
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		new WealthyKing().getSecrete("srinath");
	}
}
