/*
 * Copyright 2002-2019 the original author or authors.
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
import java.lang.reflect.Method;

import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.util.Assert;

/**
 * Pointcut constants for matching getters and setters,
 * and static methods useful for manipulating and evaluating pointcuts.
 * 用于匹配getter和setter的切入点常量，
 * 以及用于操作和计算切入点的静态方法。
 *
 * <p>These methods are particularly useful for composing pointcuts
 * using the union and intersection methods.
 * 这些方法对于组合切入点特别有用
 * 使用合并和交叉方法。
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 */
public abstract class Pointcuts {

	/** Pointcut matching all bean property setters, in any class. */
	// 切点匹配所有bean属性setters，在任何类
	public static final Pointcut SETTERS = SetterPointcut.INSTANCE;

	// 切点匹配所有bean属性getters，在任何类
	/** Pointcut matching all bean property getters, in any class. */
	public static final Pointcut GETTERS = GetterPointcut.INSTANCE;


	/**
	 * Match all methods that <b>either</b> (or both) of the given pointcuts matches.
	 * 匹配所有两者之一的给定切入点匹配的方法。
	 * @param pc1 the first Pointcut
	 *            第一个切点
	 * @param pc2 the second Pointcut
	 *            第二个切点
	 * @return a distinct Pointcut that matches all methods that either
	 * 返回: 一个截然不同的匹配所有方法的切点（两者之一）
	 * of the given Pointcuts matches
	 */
	public static Pointcut union(Pointcut pc1, Pointcut pc2) {
		return new ComposablePointcut(pc1).union(pc2);
	}

	/**
	 * Match all methods that <b>both</b> the given pointcuts match.
	 * 匹配所有两者的给定切入点匹配的方法
	 * @param pc1 the first Pointcut
	 *            第一个切点
	 * @param pc2 the second Pointcut
	 *            第二个切点
	 * @return a distinct Pointcut that matches all methods that both
	 * 返回: 一个截然不同的匹配所有方法的切点（两者）
	 * of the given Pointcuts match
	 */
	public static Pointcut intersection(Pointcut pc1, Pointcut pc2) {
		return new ComposablePointcut(pc1).intersection(pc2);
	}

	/**
	 * Perform the least expensive check for a pointcut match.
	 * 对给定切点匹配执行最低性的检查
	 * @param pointcut the pointcut to match
	 *                 去匹配的切点
	 * @param method the candidate method
	 *               候选方法
	 * @param targetClass the target class
	 *                    目标类
	 * @param args arguments to the method
	 *             方法参数
	 * @return whether there's a runtime match
	 * 返回: 是否有一个运行时匹配
	 */
	public static boolean matches(Pointcut pointcut, Method method, Class<?> targetClass, Object... args) {
		Assert.notNull(pointcut, "Pointcut must not be null");
		if (pointcut == Pointcut.TRUE) {
			return true;
		}
		if (pointcut.getClassFilter().matches(targetClass)) {
			// Only check if it gets past first hurdle.
			MethodMatcher mm = pointcut.getMethodMatcher();
			if (mm.matches(method, targetClass)) {
				// We may need additional runtime (argument) check.
				return (!mm.isRuntime() || mm.matches(method, targetClass, args));
			}
		}
		return false;
	}


	/**
	 * Pointcut implementation that matches bean property setters.
	 * 匹配bean属性setters的切点实现
	 */
	@SuppressWarnings("serial")
	private static class SetterPointcut extends StaticMethodMatcherPointcut implements Serializable {

		public static final SetterPointcut INSTANCE = new SetterPointcut();

		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return (method.getName().startsWith("set") &&
					method.getParameterCount() == 1 &&
					method.getReturnType() == Void.TYPE);
		}

		private Object readResolve() {
			return INSTANCE;
		}

		@Override
		public String toString() {
			return "Pointcuts.SETTERS";
		}
	}


	/**
	 * Pointcut implementation that matches bean property getters.
	 * 匹配bean属性getters的切点实现
	 */
	@SuppressWarnings("serial")
	private static class GetterPointcut extends StaticMethodMatcherPointcut implements Serializable {

		public static final GetterPointcut INSTANCE = new GetterPointcut();

		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return (method.getName().startsWith("get") &&
					method.getParameterCount() == 0);
		}

		private Object readResolve() {
			return INSTANCE;
		}

		@Override
		public String toString() {
			return "Pointcuts.GETTERS";
		}
	}

}
