package com.cognizant.client;

import com.cognizant.service.DepartmentService;
import com.cognizant.service.EmployeeServiceImpl;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

public class CGLIBDemo {

	public static void main(String[] args) {
		
		Enhancer enhancer1=new Enhancer();
		enhancer1.setSuperclass(EmployeeServiceImpl.class);
		/*
		 * class ProxyClass extends EmployeeServiceImpl{
		 * 
		 * @Override
		 * public String getEmpName(){
		 * return "dummy data";
		 * }
		 * }
		 */
		enhancer1.setCallback(new FixedValue() {

			public Object loadObject() throws Exception {
				// TODO Auto-generated method stub
				return "Dummy Data";
			}
			
		});
		EmployeeServiceImpl proxyObject1=(EmployeeServiceImpl)enhancer1.create();
		System.out.println(proxyObject1.getEmpName());
		
		Enhancer enhancer2=new Enhancer();
		enhancer2.setSuperclass(DepartmentService.class);
		/*
		 * class ProxyClass implements DepartmentService{
		 * 
		 * @Override
		 *String getDepartmentName()
		 *{
		 *return "dummy dept name";
		 *}
		 * }
		 */
		enhancer2.setCallback(new FixedValue() {

			public Object loadObject() throws Exception {
				// TODO Auto-generated method stub
				return "Dummy Department Name";
			}
			
		});
		DepartmentService proxyObject2=(DepartmentService)enhancer2.create();
		System.out.println(proxyObject2.getDepartmentName());
		

	}

}
