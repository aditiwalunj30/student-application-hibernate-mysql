package com.abw.factory;

import com.abw.service.RegistrationService;
import com.abw.service.RegistrationServiceImpl;

public class RegistrationServiceFactory {
	
	private static RegistrationService registrationService;
	
	private RegistrationServiceFactory() {}
	
	public static RegistrationService getRegistrationServiceInstance()
	{
		if(registrationService == null)
		{
			registrationService = new RegistrationServiceImpl();
		}
		return registrationService;
	}

}
