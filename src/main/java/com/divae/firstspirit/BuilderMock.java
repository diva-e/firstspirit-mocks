package com.divae.firstspirit;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.UUID;

import static java.lang.String.valueOf;
import static org.mockito.Mockito.mock;

public final class BuilderMock {

	private BuilderMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public interface Builder<T, TBUILDER extends Builder<T, TBUILDER>> {
	}

	public static abstract class DefaultBuilder<T, EBUILDER extends Builder<T, EBUILDER>, TBUILDER extends DefaultBuilder<T, EBUILDER, TBUILDER>> implements Builder<T, EBUILDER> {

		private final T buildable;
		private TBUILDER builder;

		@SuppressWarnings("unchecked")
		protected DefaultBuilder() {
			buildable = mock(DefaultBuilder.<T>getTypeClass(getClass()));
			builder = (TBUILDER) this;
		}

		protected DefaultBuilder(Number id) {
			this(valueOf("Mock with id " + valueOf(id)));
		}

		protected DefaultBuilder(UUID uuid) {
			this(valueOf("Mock with uuid " + valueOf(uuid)));
		}

		@SuppressWarnings("unchecked")
		protected DefaultBuilder(String mockName) {
			buildable = mock(DefaultBuilder.<T>getTypeClass(getClass()), mockName);
			builder = (TBUILDER) this;
		}

		@SuppressWarnings("unchecked")
		protected <OTBUILDER extends Builder<T, OTBUILDER>> DefaultBuilder(OTBUILDER builder) {
			this.buildable = getBuildable(builder);
			this.builder = (TBUILDER) builder;
		}

		protected final T getBuildable() {
			return buildable;
		}

		@SuppressWarnings("unchecked")
		protected static <OT, OEBUILDER extends Builder<OT, OEBUILDER>> OT getBuildable(OEBUILDER builder) {
			return builder instanceof DefaultBuilder ? ((DefaultBuilder<OT, OEBUILDER, ?>) builder).getBuildable() : null;
		}

		@SuppressWarnings("unchecked")
		protected static <OT, OEBUILDER extends Builder<OT, OEBUILDER>, OTBUILDER extends DefaultBuilder<OT, OEBUILDER, OTBUILDER>> OTBUILDER getBuilder(OEBUILDER builder) {
			return builder instanceof DefaultBuilder ? ((OTBUILDER) builder).getBuilder() : null;
		}

		protected final TBUILDER getBuilder() {
			return builder;
		}

		@SuppressWarnings("unchecked")
		protected final EBUILDER getInterfaceBuilder() {
			return (EBUILDER) builder;
		}

		static <T> Class<T> getTypeClass(@SuppressWarnings("rawtypes") Class<? extends Builder> clazz) {
			Type genericSuperclassType = clazz.getGenericSuperclass();

			if (genericSuperclassType instanceof ParameterizedType) {
				return getTTypeFromBuilder((ParameterizedType) genericSuperclassType);
			}

			return null;
		}

		@SuppressWarnings("unchecked")
		private static <T> Class<T> getTTypeFromTypeVariable(TypeVariable<Class<T>> typeVariable) {
			Type tType = typeVariable.getBounds()[0];
			if (tType instanceof Class) {
				return (Class<T>) tType;
			}

			return (Class<T>) ((ParameterizedType) tType).getRawType();
		}

		@SuppressWarnings("unchecked")
		private static <T> Class<T> getTTypeFromBuilder(ParameterizedType parameterizedType) {
			Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
			Type tType = actualTypeArguments[actualTypeArguments.length - 3];

			if (tType instanceof Class) {
				return (Class<T>) tType;
			}

			if (tType instanceof ParameterizedType) {
				return (Class<T>) ((ParameterizedType) tType).getRawType();
			}

			return getTTypeFromTypeVariable((TypeVariable<Class<T>>) tType);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T, TBUILDER extends Builder<T, TBUILDER>> T build(TBUILDER builder) {
        return builder instanceof DefaultBuilder ? ((DefaultBuilder<T, TBUILDER, ?>) builder).getBuildable() : null;
    }
}