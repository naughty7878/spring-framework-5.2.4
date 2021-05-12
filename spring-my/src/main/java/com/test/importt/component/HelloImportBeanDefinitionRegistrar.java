package com.test.importt.component;

import com.test.importt.service.HelloService;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.util.Map;

public class HelloImportBeanDefinitionRegistrar
		implements ImportBeanDefinitionRegistrar {

	// AnnotationMetadata:当前类的注解信息；
	// BeanDefinitionRegistry：注册类，其registerBeanDefinition()可以注册bean
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
										BeanDefinitionRegistry registry) {

		// 获取导入配置类上的注解元信息
		Map<String, Object> annotationAttributes = importingClassMetadata
				.getAnnotationAttributes(ComponentScan.class.getName());
		String[] basePackages = (String[]) annotationAttributes.get("basePackages");

		// 生成类路径Bean定义扫描器
		ClassPathBeanDefinitionScanner scanner =
				new ClassPathBeanDefinitionScanner(registry, false);
		TypeFilter helloServiceFilter = new AssignableTypeFilter(HelloService.class);
		// 添加过滤器
		scanner.addIncludeFilter(helloServiceFilter);
		// 扫描（主要是扫描报中的资源，并读取、然后注册Bean定义）
		scanner.scan(basePackages);
	}

}