package com.test.circulardependence;

import org.springframework.beans.factory.annotation.Autowired;

public class InstanceA {


	@Autowired
	private InstanceB instanceB;

	public void say(){
		System.out.println("InstanceA#say(): .......");
	}
}
