package com.test.tx;

import com.test.tx.service.IOutService;
import com.test.tx.service.ITargetService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainStarter {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

		ITargetService targetService = context.getBean(ITargetService.class);
		IOutService service = context.getBean(IOutService.class);
		try {
			service.update();
		} catch (Exception e) {
			e.printStackTrace();
		}
		targetService.select();
	}
}
