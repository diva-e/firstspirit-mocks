package com.divae.firstspirit.access.store.templatestore.gom;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.templatestore.gom.GomEditorProvider;
import de.espirit.firstspirit.access.store.templatestore.gom.GomFormElement;
import org.junit.Test;

import java.util.Iterator;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.templatestore.gom.GomEditorProviderMock.gomEditorProviderWith;
import static com.divae.firstspirit.access.store.templatestore.gom.GomFormElementMock.gomFormElementWith;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GomEditorProviderMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return GomEditorProviderMock.class;
	}

	@Test
	public void testValues() {
		GomEditorProvider gomEditorProvider = build(gomEditorProviderWith("test").values(() -> singletonList(gomFormElementWith("test"))));
		Iterator<GomFormElement> iterator = gomEditorProvider.forms().iterator();
		assertThat(iterator.hasNext(), is(TRUE));
		GomFormElement gomFormElement = iterator.next();
		assertThat(gomFormElement.name(), is("test"));
		assertThat(gomEditorProvider.findEditor("test"), is(gomFormElement));
	}

	@Test
	public void testDefaults() {
		GomEditorProvider gomEditorProvider = build(gomEditorProviderWith("test"));
		Iterator<GomFormElement> iterator = gomEditorProvider.forms().iterator();
		assertThat(iterator.hasNext(), is(FALSE));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testWrongIndex() {
		GomEditorProvider gomEditorProvider = build(gomEditorProviderWith("test"));
		gomEditorProvider.get(0);
	}
}
