/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * Defines a factory which can return an Object instance
 * (possibly shared or independent) when invoked.
 * 定义一个工厂，该工厂在调用时可以返回Object实例（可能是共享的或者独立的）。
 *
 * <p>This interface is typically used to encapsulate a generic factory which
 * returns a new instance (prototype) of some target object on each invocation.
 * 该接口通常用于封装一个通用工厂，该工厂在每次调用时返回某个目标对象的新实例(原型)。
 *
 * <p>This interface is similar to {@link FactoryBean}, but implementations
 * of the latter are normally meant to be defined as SPI instances in a
 * {@link BeanFactory}, while implementations of this class are normally meant
 * to be fed as an API to other beans (through injection). As such, the
 * {@code getObject()} method has different exception handling behavior.
 *
 * SPI Service Provider Interface 服务提供接口
 * API Application Programming Interface 应用提供接口
 *
 * SPI:服务提供方提供接口并进行实现后，调用方就可以通过调用这个接口拥有服务提供发提供的能力
 * API:当接口是由服务调用方提供，并且由服务提供方进行实现时，服务调用方就可以根据自己的需要选择特定实现，而不用更改业务代码以获取相应的功能
 *
 * 这个接口类似于FactoryBean，但是实现的SPI实例通常被定义为BeanFactory,而该类的实现通常
 * 意味着作为API提供给其他bean(通过注入)。因此getObject()方法具有不同的异常处理行为。
 *
 * @author Colin Sampaleanu
 * @since 1.0.2
 * @param <T> the object type
 * @see FactoryBean
 */
// 函数式接口
@FunctionalInterface
public interface ObjectFactory<T> {

	/**
	 * Return an instance (possibly shared or independent)
	 * 返回一个实例（可能共享或独立）
	 * of the object managed by this factory.
	 * 这个实例对象被该factory管理
	 * @return the resulting instance
	 * 返回: 结果实例
	 * @throws BeansException in case of creation errors
	 * 抛出: BeansException 以防创建错误
	 */
	T getObject() throws BeansException;

}

/*
	当某些方法需要提前初始化的时候则会调用addSingletonFactory方法将
	对应的ObjectFactory初始化策略存储在singletonFactories（三级缓存）
*/
