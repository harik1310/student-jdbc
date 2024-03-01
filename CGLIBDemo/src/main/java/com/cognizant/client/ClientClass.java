package com.cognizant.client;

import com.cognizant.proxy.ProxyService;
import com.cognizant.service.BusinessService;

public class ClientClass {

	public static void main(String[] args) {
		BusinessService proxyObject=new ProxyService();
		proxyObject.businessMethod();
	}

}
