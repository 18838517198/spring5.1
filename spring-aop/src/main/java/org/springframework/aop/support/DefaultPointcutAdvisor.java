/*
 * Copyright 2002-2017 the original author or authors.
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

package org.springframework.aop.support;

import java.io.Serializable;

import org.aopalliance.aop.Advice;

import org.springframework.aop.Pointcut;
import org.springframework.lang.Nullable;

/**
 * Convenient Pointcut-driven Advisor implementation.
 * 方便的切点驱动的Advisor实现。
 *
 * <p>This is the most commonly used Advisor implementation. It can be used
 * with any pointcut and advice type, except for introductions. There is
 * normally no need to subclass this class, or to implement custom Advisors.
 * 这是最常用的Advisor实现。它可以被用于任何切点和建议类型，除了introductions，
 * 通常不需要子类化这个类，也不需要实现自定义advisor。
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see #setPointcut
 * @see #setAdvice
 */
@SuppressWarnings("serial")
public class DefaultPointcutAdvisor extends AbstractGenericPointcutAdvisor implements Serializable {

	private Pointcut pointcut = Pointcut.TRUE;


	/**
	 * Create an empty DefaultPointcutAdvisor.
	 * 创建一个空的DefaultPointcutAdvisor。
	 * <p>Advice must be set before use using setter methods.
	 * 在使用setter方法之前必须设置建议。
	 * Pointcut will normally be set also, but defaults to {@code Pointcut.TRUE}.
	 * 通常也会设置Pointcut，但默认为Pointcut. true。
	 */
	public DefaultPointcutAdvisor() {
	}

	/**
	 * Create a DefaultPointcutAdvisor that matches all methods.
	 * 创建一个匹配所有方法的DefaultPointcutAdvisor。
	 * <p>{@code Pointcut.TRUE} will be used as Pointcut.
	 * Pointcut.Ture将被用作Pointcut
	 * @param advice the Advice to use
	 *               使用的建议
	 */
	public DefaultPointcutAdvisor(Advice advice) {
		this(Pointcut.TRUE, advice);
	}

	/**
	 * Create a DefaultPointcutAdvisor, specifying Pointcut and Advice.
	 * 创建一个DefaultPointcutAdvisor，指定切点和建议。
	 * @param pointcut the Pointcut targeting the Advice
	 *                 针对建议的切点
	 * @param advice the Advice to run when Pointcut matches
	 *               当切点匹配时运行的建议
	 */
	public DefaultPointcutAdvisor(Pointcut pointcut, Advice advice) {
		this.pointcut = pointcut;
		setAdvice(advice);
	}


	/**
	 * Specify the pointcut targeting the advice.
	 * 指定针对建议的切入点。
	 * <p>Default is {@code Pointcut.TRUE}.
	 * 默认是Pointcut.TRUE
	 * @see #setAdvice
	 */
	public void setPointcut(@Nullable Pointcut pointcut) {
		this.pointcut = (pointcut != null ? pointcut : Pointcut.TRUE);
	}

	@Override
	public Pointcut getPointcut() {
		return this.pointcut;
	}


	@Override
	public String toString() {
		return getClass().getName() + ": pointcut [" + getPointcut() + "]; advice [" + getAdvice() + "]";
	}

}
