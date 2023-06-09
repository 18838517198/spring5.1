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

package org.springframework.aop;

/**
 * Filter that restricts matching of a pointcut or introduction to
 * a given set of target classes.
 * 约束切点或引导到一个给定的目标类集匹配的过滤器
 *
 *
 * <p>Can be used as part of a {@link Pointcut} or for the entire
 * targeting of an {@link IntroductionAdvisor}.
 * 可以用作Pointcut的一部分，也可以用于IntroductionAdvisor的整个目标
 *
 * <p>Concrete implementations of this interface typically should provide proper
 * implementations of {@link Object#equals(Object)} and {@link Object#hashCode()}
 * in order to allow the filter to be used in caching scenarios &mdash; for
 * example, in proxies generated by CGLIB.
 * 这个接口的具体实现通常应该提供适当的equals(Object)和hashCode实现，以便于允许过滤器在缓存场景中使用。
 * 例如，使用CGLIB生成的代理中。
 *
 * @author Rod Johnson
 * @see Pointcut
 * @see MethodMatcher
 */
@FunctionalInterface
public interface ClassFilter {

	/**
	 * Should the pointcut apply to the given interface or target class?
	 * 这个切点能应用于该接口或目标类？
	 * @param clazz the candidate target class
	 *              候选目标类
	 * @return whether the advice should apply to the given target class
	 * 返回: 是否这个建议能被应用于该目标类
	 */
	boolean matches(Class<?> clazz);


	/**
	 * Canonical instance of a ClassFilter that matches all classes.
	 */
	ClassFilter TRUE = TrueClassFilter.INSTANCE;

}
