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

package org.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * Base interface holding AOP <b>advice</b> (action to take at a joinpoint)
 * and a filter determining the applicability of the advice (such as
 * a pointcut).
 * 包含AOP建议(在连接点执行的操作)的基础接口和决定建议适用性的过滤器(例如切点)。
 * <i>This interface is not for use by Spring users, but to
 * allow for commonality in support for different types of advice.</i>
 * 这个接口不是供Spring用户使用的，而是为了支持不同类型的建议。
 *
 * <p>Spring AOP is based around <b>around advice</b> delivered via method
 * <b>interception</b>, compliant with the AOP Alliance interception API.
 * The Advisor interface allows support for different types of advice,
 * such as <b>before</b> and <b>after</b> advice, which need not be
 * implemented using interception.
 * Spring AOP基于坏绕（环绕建议）传递通过方法过滤器，与AOP联盟拦截器API兼容。
 * 这个建议器接口允许支持不同类型的建议，例如before和after建议，不需要适用拦截器实现。
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 */
public interface Advisor {

	/**
	 * Common placeholder for an empty {@code Advice} to be returned from
	 * {@link #getAdvice()} if no proper advice has been configured (yet).
	 * 从getAdvice()返回的空Advice的通用占位符，如果没有配置合适的建议(还没有)。
	 * @since 5.0
	 * 自 5.0
	 */
	Advice EMPTY_ADVICE = new Advice() {};


	/**
	 * Return the advice part of this aspect. An advice may be an
	 * interceptor, a before advice, a throws advice, etc.
	 * 返回切面的建议部分。一个建议可能是一个拦截器，一个前置建议，一个抛出建议，等。
	 * @return the advice that should apply if the pointcut matches
	 * 返回: 如果切入点匹配，应该应用的建议
	 * @see org.aopalliance.intercept.MethodInterceptor
	 * @see BeforeAdvice
	 * @see ThrowsAdvice
	 * @see AfterReturningAdvice
	 */
	Advice getAdvice();

	/**
	 * Return whether this advice is associated with a particular instance
	 * (for example, creating a mixin) or shared with all instances of
	 * the advised class obtained from the same Spring bean factory.
	 * 返回该建议是否与特定实例(例如，创建mixin)相关联，还是与从同一个Spring bean工厂获得的被建议类的所有实例共享。
	 * <p><b>Note that this method is not currently used by the framework.</b>
	 * 注意，框架目前没有使用这个方法。
	 * Typical Advisor implementations always return {@code true}.
	 * Use singleton/prototype bean definitions or appropriate programmatic
	 * proxy creation to ensure that Advisors have the correct lifecycle model.
	 * @return whether this advice is associated with a particular target instance
	 */
	boolean isPerInstance();

}
