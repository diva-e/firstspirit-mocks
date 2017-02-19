package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.pagestore.BodyMock.BodyBuilder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.DataProviderBuilder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.DefaultDataProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateProviderMock.TemplateProviderBuilder;
import de.espirit.firstspirit.access.store.pagestore.Body;
import de.espirit.firstspirit.access.store.pagestore.Section;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;

import static org.mockito.Mockito.when;

public final class SectionMock {

	private SectionMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <ST extends SectionTemplate, T extends Section<ST>, OT extends Body, OTBUILDER extends BodyBuilder<OT, OTBUILDER>> TruncatedSectionBuilder<ST, T> sectionWith(String uid, long id, OTBUILDER parent) {
		return new TruncatedDefaultSectionBuilder<>(uid, id, parent);
	}

	public interface SectionBuilder<ST extends SectionTemplate, T extends Section<ST>, TBUILDER extends SectionBuilder<ST, T, TBUILDER>> extends DataProviderBuilder<T, TBUILDER>, IDProviderBuilder<T, TBUILDER>, TemplateProviderBuilder<ST, T, TBUILDER> {
		TBUILDER aTemplate(ST sectionTemplate);
	}

	public static class DefaultSectionBuilder<ST extends SectionTemplate, T extends Section<ST>, EBUILDER extends SectionBuilder<ST, T, EBUILDER>, TBUILDER extends DefaultSectionBuilder<ST, T, EBUILDER, TBUILDER>> extends DefaultDataProviderBuilder<T, EBUILDER, TBUILDER> implements SectionBuilder<ST, T, EBUILDER> {

		protected <OT extends Body, OTBUILDER extends BodyBuilder<OT, OTBUILDER>> DefaultSectionBuilder(String name, long id, OTBUILDER parent) {
			super(name, id, parent);
		}

		@Override
		public final EBUILDER aTemplate(ST sectionTemplate) {
			when(getBuildable().getTemplate()).thenReturn(sectionTemplate);
			return getInterfaceBuilder();
		}
	}

	public interface TruncatedSectionBuilder<ST extends SectionTemplate, T extends Section<ST>> extends SectionBuilder<ST, T, TruncatedSectionBuilder<ST, T>> {
	}

	private static final class TruncatedDefaultSectionBuilder<ST extends SectionTemplate, T extends Section<ST>> extends DefaultSectionBuilder<ST, T, TruncatedSectionBuilder<ST, T>, TruncatedDefaultSectionBuilder<ST, T>> implements TruncatedSectionBuilder<ST, T> {

		<OT extends Body, OTBUILDER extends BodyBuilder<OT, OTBUILDER>> TruncatedDefaultSectionBuilder(String name, long id, OTBUILDER parent) {
			super(name, id, parent);
		}
	}
}
