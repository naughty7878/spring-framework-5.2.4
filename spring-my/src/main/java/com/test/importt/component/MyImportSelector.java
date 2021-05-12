package com.test.importt.component;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

public class MyImportSelector implements ImportSelector, DeferredImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		System.out.println("这里是选择导入类内部selectImports()：选择要导入的类");
		// 返回Student 需要导入
		return new String[]{"com.test.importt.Person"};
	}

//	@Override
//	public Predicate<String> getExclusionFilter() {
//		Predicate<String> predicate = new Predicate<String>() {
//			@Override
//			public boolean test(String s) {
//				System.out.println(s);
//				if (s.matches("com.test.importt.Person")) {
//					return true;
//				}
//				return false;
//			}
//		};
//		return predicate;
//	}
}
