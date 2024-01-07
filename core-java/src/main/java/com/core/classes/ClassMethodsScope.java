package com.core.classes;

class HumptyDumpty{
	private void myMethod() {}//valid as it's scope is lesser than implemented class scope
}

public class ClassMethodsScope extends HumptyDumpty	{
	
	//private void myMethod() { //not correct as it is decreasing the scope (default to private) 
	//public void myMethod() { 	//valid as it is increasing the scope
	protected void myMethod() {	//valid as it is increasing the scope
		
	}
}