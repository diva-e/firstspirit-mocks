package com.divae.firstspirit;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class BuilderMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return BuilderMock.class;
	}

	@Test
	public void testGetBuildable() {
		assertThat(new DefaultBuilderProxy<>().getBuildable(), is(notNullValue()));
	}

	@Test
	public void testGetBuilder() {
		assertThat(new DefaultBuilderProxy<>().getBuilder(), is(notNullValue()));
	}

	@Test
	public void testGetTypeClassWithNoGenerics() {
		assertThat(DefaultBuilder.getTypeClass(DefaultBuilder.class), is(nullValue()));
	}

	@Test
	public void testBuild() {
		DefaultBuilderProxy<Object> builder = new DefaultBuilderProxy<>();
		assertThat(build(builder), is(builder.getBuildable()));
	}

	private interface BuilderProxy<T> extends Builder<T, BuilderProxy<T>> {

	}

	private class DefaultBuilderProxy<T> extends DefaultBuilder<T, BuilderProxy<T>, DefaultBuilderProxy<T>> implements BuilderProxy<T> {

	}
}
