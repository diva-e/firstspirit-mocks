package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.sitestore.PageRefMock.PageRefBuilder;
import de.espirit.firstspirit.access.schedule.GenerateTask;
import de.espirit.firstspirit.access.store.sitestore.PageRef;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.schedule.GenerateTaskMock.generateTaskWith;
import static com.divae.firstspirit.access.store.sitestore.PageRefMock.pageRefWith;
import static java.lang.Integer.valueOf;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GenerateTaskMockTest extends MockTest {

	@Test
	public void testGenerateTaskWith() {
		assertThat(generateTaskWith("test"), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return GenerateTaskMock.class;
	}

	@Test
	public void testDefaults() {
		GenerateTask generateTask = build(generateTaskWith("test"));
		assertThat(generateTask.getStartNodes().size(), is(valueOf(0)));
	}

	@Test
	public void testStartNodes() {
		PageRefBuilder pageRefBuilder = pageRefWith("pageRef", 2, null);
		GenerateTask generateTask = build(generateTaskWith("test").startNodes(singletonList(pageRefBuilder)));
		PageRef pageRef = build(pageRefBuilder);
		assertThat(generateTask.getStartNodes().size(), is(valueOf(1)));
		assertThat(generateTask.getStartNodes().get(0), is(pageRef));
	}
}
