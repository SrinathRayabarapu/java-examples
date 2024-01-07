package com.core.threads.racecondition;

public class SharedResource {
	
	static SharedResource resource;
	static int i = 0;

	/**
	 * important: this method is read by two methods in parallel yet it's not synchronized which can
	 * lead i value to be unexpected.
	 *
	 * @return
	 */
	public static SharedResource getInstance(){
		if(resource == null){
			i++;
			resource = new SharedResource();
			return resource;
		}
		return resource;
	}
	
	@Override
	public String toString() {
		return i+"";
	}
}