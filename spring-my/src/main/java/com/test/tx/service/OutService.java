package com.test.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OutService implements IOutService{

	@Autowired
	private ITargetService targetService;

	@Transactional
	@Override
	public void update(){
		targetService.update();
		//抛异常
//		throw new RuntimeException();
	}
}
