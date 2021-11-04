package com.liferay.rest.client.function;

import javax.annotation.Generated;

/**
 * @author shuai.b.zhang
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}