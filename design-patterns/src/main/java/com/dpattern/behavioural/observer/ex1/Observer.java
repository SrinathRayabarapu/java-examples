package com.dpattern.behavioural.observer.ex1;

/**
 * abstract class to hold subject and update method
 *
 * @author Srinath.Rayabarapu
 */
public abstract class Observer {

	// this field is common for all base classes who are extending this, else this class could have been an interface
	protected Subject subject;

	public abstract void update();

}