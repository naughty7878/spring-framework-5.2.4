package com.test.circulardependence;

import org.springframework.beans.factory.annotation.Autowired;

public class InstanceB {

	@Autowired
	private InstanceA instanceA;


	public void say(){
		System.out.println("InstanceB#say(): .......");
	}
}
