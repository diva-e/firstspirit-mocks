package com.divae.firstspirit.forms;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.editor.FormDataProducerMock;
import de.espirit.firstspirit.access.editor.fslist.IdProvidingFormData;
import de.espirit.firstspirit.forms.FormDataList;
import org.junit.Test;

import java.util.Iterator;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.editor.fslist.IdProvidingFormDataMock.idProvidingFormDataWith;
import static com.divae.firstspirit.forms.FormDataListMock.formDataListWith;
import static java.lang.Boolean.FALSE;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class FormDataListMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return FormDataListMock.class;
	}

	@Test
	public void testValues() {
		FormDataList formDataList = build(formDataListWith().values(() -> singletonList(idProvidingFormDataWith(0L))));
		assertThat(formDataList.iterator().next().getId(), is(0L));
	}

	@Test
	public void testDefaultsWithoutEntries() {
		FormDataList formDataList = build(formDataListWith());
		assertThat(formDataList.iterator().hasNext(), is(FALSE));
	}

	@Test
	public void testDefaultsClear() {
		FormDataList formDataList = build(formDataListWith());
		IdProvidingFormData idProvidingFormData = build(idProvidingFormDataWith(0L));
		formDataList.add(idProvidingFormData);
		assertThat(formDataList.size(), is(1));
		formDataList.clear();
		assertThat(formDataList.size(), is(0));
	}

	@Test
	public void testDefaultsWithEntries() {
		FormDataList formDataList = build(formDataListWith().values(() -> asList(idProvidingFormDataWith(0L), idProvidingFormDataWith(1L))));
		assertThat(formDataList.size(), is(2));
		assertThat(formDataList.get(0).getId(), is(0L));
		assertThat(formDataList.get(1).getId(), is(1L));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testWrongIndex() {
		FormDataList formDataList = build(formDataListWith());
		formDataList.get(0);
	}

	@Test
	public void testWithMultipleValues() {
		FormDataList formDataList = build(formDataListWith().values(() -> asList(idProvidingFormDataWith(0L), idProvidingFormDataWith(1L))));
		Iterator<IdProvidingFormData> iterator = formDataList.iterator();
		assertThat(iterator.next().getId(), is(0L));
		assertThat(iterator.next().getId(), is(1L));
	}

	@Test
	public void testAProducer() {
		FormDataList formDataList = build(formDataListWith().aProducer(FormDataProducerMock::formDataProducerWith));
		assertThat(formDataList.getProducer(), is(notNullValue()));
	}
}
