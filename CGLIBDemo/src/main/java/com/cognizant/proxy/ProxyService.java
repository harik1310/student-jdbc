package com.cognizant.proxy;

import com.cognizant.service.BusinessService;
import com.cognizant.service.BusinessServiceImpl;

public class ProxyService implements BusinessService {

	public void businessMethod() {
		BusinessService businessService=new BusinessServiceImpl();
		businessService.businessMethod();

	}

}
