package com.test.importt;

import com.test.importt.component.HelloImportBeanDefinitionRegistrar;
import com.test.importt.component.MyImportBeanDefinitionRegistrar;
import com.test.importt.component.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan("com.test.componnet.compon")
@ComponentScan("com.test.importt.service")
//@Import(Person.class)
@Import(MyImportSelector.class)
//@Import(MyImportBeanDefinitionRegistrar.class)
//@Import({Person.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig {
}
