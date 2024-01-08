package com.dpattern.businessdelegate;

public class PoliceBusinessService implements BusinessService {

	@Override
	public void doProcessing() {
		System.out.println("Police is being served..!");
	}

}