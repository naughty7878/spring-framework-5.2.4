/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.framework;

import java.io.Serializable;
import java.lang.reflect.Proxy;

import org.springframework.aop.SpringProxy;


/**
 * Default {@link AopProxyFactory} implementation, creating either a CGLIB proxy
 * or a JDK dynamic proxy.
 *
 * <p>Creates a CGLIB proxy if one the following is true for a given
 * {@link AdvisedSupport} instance:
 * <ul>
 * <li>the {@code optimize} flag is set
 * <li>the {@code proxyTargetClass} flag is set
 * <li>no proxy interfaces have been specified
 * </ul>
 *
 * <p>In general, specify {@code proxyTargetClass} to enforce a CGLIB proxy,
 * or specify one or more interfaces to use a JDK dynamic proxy.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 12.03.2004
 * @see AdvisedSupport#setOptimize
 * @see AdvisedSupport#setProxyTargetClass
 * @see AdvisedSupport#setInterfaces
 */
@SuppressWarnings("serial")
public class DefaultAopProxyFactory implements AopProxyFactory, Serializable {

	/**
	 * 下面是对JDK和CGLIB方式的总结。
	 * 1、如果目标对象实现了接口，默认情况下会采用JDK的动态代理实现AOP；
	 * 2、如果目标对象实现了接口，可以强制使用CGLIB实现AOP；
	 * 3、如果目标对象没有实现接口，必须采用CGLIB库，Spring会自动在JDK动态代理和CGLIB之间转换；
	 * @param config the AOP configuration in the form of an
	 * AdvisedSupport object
	 * @return
	 * @throws AopConfigException
	 */
	// 创建AOP代理
	@Override
	public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
		// 1）optimize：用来控制通过CGLIB创建的代理是否使用激进的优化策略。
		// 除非完全了解AOP代理如何处理优化，否则不推荐用户使用这个设置。
		// 目前这个属性仅用于CGLIB代理，对于JDK动态代理（缺省代理）无效；
		//
		// 2）proxyTargetClass：是否是代理目标类，这个属性为true时，目标类本身被代理而不是目标类的接口。
		// 如果这个属性值被设为true，CGLIB代理将会被创建，设置方式：@EnableAspectJAutoProxy(proxyTargetClass = true)
		// true使用cglib代理，false使用jdk代理
		//
		// 3) hasNoUserSuppliedProxyInterfaces: 被代理类有没有可代理的接口
		if (config.isOptimize() || config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(config)) {
			Class<?> targetClass = config.getTargetClass();
			if (targetClass == null) {
				throw new AopConfigException("TargetSource cannot determine target class: " +
						"Either an interface or a target is required for proxy creation.");
			}
			//  如果被代理类的类型是接口，或者被代理类是 JDK 动态代理生成的代理类，则使用 JDK 动态代理
			if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
				// 创建JDK动态代理
				return new JdkDynamicAopProxy(config);
			}
			// 创建Cglib动态代理
			return new ObjenesisCglibAopProxy(config);
		}
		else {
			// 创建JDK动态代理
			return new JdkDynamicAopProxy(config);
		}
	}

	/**
	 * Determine whether the supplied {@link AdvisedSupport} has only the
	 * {@link org.springframework.aop.SpringProxy} interface specified
	 * (or no proxy interfaces specified at all).
	 */
	private boolean hasNoUserSuppliedProxyInterfaces(AdvisedSupport config) {
		Class<?>[] ifcs = config.getProxiedInterfaces();
		return (ifcs.length == 0 || (ifcs.length == 1 && SpringProxy.class.isAssignableFrom(ifcs[0])));
	}

}
