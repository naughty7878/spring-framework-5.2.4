package com.test.tx.service;


import org.springframework.transaction.annotation.Transactional;

public interface ITargetService {

	void update();

	void select();
}
