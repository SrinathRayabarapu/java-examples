package com.core.exceptions;

import java.lang.reflect.Method;

class Suspect {
	int diamondOne;

	public void haveYouStolenDiamond() {
		System.out.println("Parent : Did you stolen Diamond..?");
	}
}

class Thief extends Suspect {
	int diamondTwo;

	public void haveYouStolenDiamond() {
		System.out.println("Child : Did you stolen Diamond..?");
	}

	public void whereIsDiamond() {
		System.out.println("Child : Where is the Diamond...?");
	}
}

class Police {
	public void introspect(Suspect suspect) throws Exception {
		suspect = new Thief();
		Class<? extends Suspect> class1 = suspect.getClass();
		Method method = class1.getMethod("whereIsDiamond", new Class[] {});
		// Method[] method = class1.getMethods();
		method.invoke(suspect, new Object[] {});
	}
}

public class Scenario {
	public static void main(String[] args) throws Exception {
		Police police = new Police();
		Suspect suspect = new Suspect();
		police.introspect(suspect);
	}
}