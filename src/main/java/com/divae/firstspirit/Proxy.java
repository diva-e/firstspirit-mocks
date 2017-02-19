package com.divae.firstspirit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Proxy {

	private Proxy() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <O> ProxyBuilder<O> with(final O object, Class<O> objectClass) {
		return new ProxyBuilder<>(objectClass, object);
	}

	public static <O, T> T proxy(ProxyBuilder<O> proxyBuilder) {
		return proxyBuilder.build();
	}

	public final static class ProxyBuilder<O> {

		private final Class<O> objectInterfaceClass;
		private final Map<Class<?>, Object> targets = new HashMap<>();

		ProxyBuilder(Class<O> interfaceClass, final O object) {
			this.objectInterfaceClass = interfaceClass;
			targets.put(interfaceClass, object);
		}

		public <T> ProxyBuilder<O> aTarget(T object, Class<T> interfaceClass) {
			targets.put(interfaceClass, object);
			return this;
		}

		public <T> ProxyBuilder<O> aTarget(Class<T> interfaceClass) {
			targets.put(interfaceClass, null);
			return this;
		}

		@SuppressWarnings("unchecked")
		private <T> T build() {
			return (T) java.lang.reflect.Proxy.newProxyInstance(objectInterfaceClass.getClassLoader(), targets.keySet().toArray(new Class[targets.size()]),
					(proxy, method, args) -> {

						List<Class<?>> classes = new ArrayList<>();
						if (args != null) {
							for (Object arg : args) {
								classes.add(arg.getClass());
							}
						}

						Class<?> proxyClass = proxy.getClass();
						Object targetObject = targets.containsKey(proxyClass) ? targets.get(proxyClass) : targets.get(objectInterfaceClass);

						return targetObject.getClass().getMethod(method.getName(), classes.toArray(new Class[classes.size()])).invoke(targetObject, args);
					});
		}
	}
}
