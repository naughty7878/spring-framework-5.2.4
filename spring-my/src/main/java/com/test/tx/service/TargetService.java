package com.test.tx.service;

import com.test.tx.service.ITargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class TargetService implements ITargetService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(){
		//3: 编写SQL
		String sql="update user_tx set name = '王四' where id = 3";

		int update = jdbcTemplate.update(sql);

		System.out.println(update == 0 ? "修改失败" : "修改成功");
	}

	@Override
	public void select(){
		//3: 编写SQL
		String sql="select id,name from user_tx";

		List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

		maps.forEach(t ->  System.out.println("id:"+t.get("id")+"\t名称:"+t.get("name")));
	}
}
