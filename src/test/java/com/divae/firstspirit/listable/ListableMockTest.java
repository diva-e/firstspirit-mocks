package com.divae.firstspirit.listable;

import com.divae.firstspirit.MockTest;
import de.espirit.common.util.Listable;
import de.espirit.firstspirit.access.store.pagestore.Section;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;
import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.pagestore.SectionMock.sectionWith;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ListableMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ListableMock.class;
	}

	@Test
	public void testElements() {
		Section<SectionTemplate> section = build(sectionWith("test", 2, null));
		List<Section<SectionTemplate>> sections = Collections.singletonList(section);
		Listable<Section<SectionTemplate>> listable = build(ListableMock.<Section<SectionTemplate>>listableWith().elements(sections));
		Iterator<Section<SectionTemplate>> iterator = listable.iterator();
		assertThat(iterator.hasNext(), is(TRUE));
		assertThat(iterator.next(), is(section));
		assertThat(iterator.hasNext(), is(FALSE));
		assertThat(listable.toList(), is(sections));
	}

	@Test
	public void testElementsWithCallingIteratorFunctionMultiple() {
		Section<SectionTemplate> section1 = build(sectionWith("section1", 2, null));
		Section<SectionTemplate> section2 = build(sectionWith("section2", 3, null));
		List<Section<SectionTemplate>> sections = asList(section1, section2);
		Listable<Section<SectionTemplate>> listable = build(ListableMock.<Section<SectionTemplate>>listableWith().elements(sections));
		assertThat(listable.iterator().hasNext(), is(TRUE));
		assertThat(listable.iterator().next(), is(section1));
		assertThat(listable.iterator().hasNext(), is(TRUE));
		assertThat(listable.iterator().next(), is(section1));
	}
}
