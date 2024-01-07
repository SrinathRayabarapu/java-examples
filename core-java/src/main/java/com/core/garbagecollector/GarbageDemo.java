package com.core.garbagecollector;

public class GarbageDemo {

	public static void main(String[] args) throws Exception {
		Runtime r = Runtime.getRuntime();
		System.out.println("before GF birth" + r.freeMemory());
		GrandFather gf = new GrandFather();
		System.out.println("after GF birth:" + r.freeMemory());
		/*
		 * System.out.println("After goes to kasi"); SoftReference sf=new
		 * SoftReference(gf); WeakReference wf=new WeakReference(gf);
		 * PhantomReference pf=new PhantomReference(gf);
		 * gf=(GrandFather)sf.get();
		 * System.out.println(gf.getSecret("krishna"));
		 */
		// gf=null;
		System.out.println("after GF death:" + r.freeMemory());
		r.gc();
		System.out.println("after GF ceremation" + r.freeMemory());
		System.out.println(gf.getSecret("krishna"));
	}
}
