package com.dpattern.businessdelegate;

public class DoctorBusinessService implements BusinessService {

	@Override
	public void doProcessing() {
		System.out.println("Doctor is being served..!");
	}

}
