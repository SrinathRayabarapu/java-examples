package com.core.garbagecollector;

import java.lang.ref.SoftReference;

public class KingGarbageCollDemo {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Before King's Birth " + runtime.freeMemory());

		WealthyKing king = new WealthyKing();
		System.out.println("After King's Birth " + runtime.freeMemory());

		SoftReference reference = new SoftReference(king);
		king = null;

		System.out.println("After King's Death " + runtime.freeMemory());

		runtime.gc();
		System.out.println("After King's Cremation " + runtime.freeMemory());
		king = (WealthyKing) reference.get();
		System.out.println(king.getSecrete("srinath"));
	}
}
