package com.dpattern.businessdelegate;

public class BusinessLookupService {

	public BusinessService getBusinessService(String serviceType) {
		
		if(serviceType.equalsIgnoreCase("police")) {
			return new PoliceBusinessService();
		}
		
		if(serviceType.equalsIgnoreCase("doctor")) {
			return new DoctorBusinessService();
		}
		
		return null;
	}

}