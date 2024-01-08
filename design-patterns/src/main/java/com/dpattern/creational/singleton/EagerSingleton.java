package com.dpattern.creational.singleton;

/**
 * This method works fine, but has one drawback. Instance is created irrespective of it is required in runtime or not.
 * If this instance is not big object and you can live with it being unused, then can go for it.
 */
public class EagerSingleton{

	private static final EagerSingleton singleton = new EagerSingleton();//NO option to exception handling

	//cann't create an object by any class but a class loader
	private EagerSingleton() {
	}

	public static EagerSingleton getInstance(){
		return singleton;
	}
}
