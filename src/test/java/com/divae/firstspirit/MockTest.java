package com.divae.firstspirit;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.reflect.Modifier.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

public abstract class MockTest {

	protected abstract Class<?> getFactoryClass();

	@Test(expected = InvocationTargetException.class)
	public void testDefaultConstructor() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Constructor<?> declaredConstructor = getFactoryClass().getDeclaredConstructor();
		assertThat(declaredConstructor.getModifiers(), is(PRIVATE));
		declaredConstructor.setAccessible(true);
		declaredConstructor.newInstance();
	}

	@Test
	public void testPublicFactoryMethodsWithoutParameters() throws IllegalAccessException, InvocationTargetException {
		for (Method method : getFactoryClass().getDeclaredMethods()) {
			int modifiers = method.getModifiers();
			assumeTrue(isStatic(modifiers) && isPublic(modifiers) && method.getParameterTypes().length == 0);
			assertThat(method.invoke(null), is(notNullValue()));
		}
	}
}
