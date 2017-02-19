package com.divae.firstspirit.access.project;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.project.TemplateSet;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.project.TemplateSetMock.templateSetWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TemplateSetMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return TemplateSetMock.class;
	}

	@Test
	public void testAPresentationChannelName() {
		TemplateSet templateSet = build(templateSetWith("test").aPresentationChannelName("test"));
		assertThat(templateSet.getPresentationChannelName(), is("test"));
	}
}
