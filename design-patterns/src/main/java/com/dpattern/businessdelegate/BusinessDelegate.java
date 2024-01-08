package com.dpattern.businessdelegate;

public class BusinessDelegate {
	
	private String serviceType;
	private BusinessLookupService lookUpService = new BusinessLookupService();	
	
	public void setService(String serviceType) {
		System.out.println("Setting service as : " + serviceType);
		this.serviceType = serviceType;
	}
	
	public void doTask() {
		BusinessService busService = this.lookUpService.getBusinessService(this.serviceType);
		busService.doProcessing();
	}

}