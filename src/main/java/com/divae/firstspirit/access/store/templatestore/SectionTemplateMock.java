package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.PreviewImageProviderMock.PreviewImageProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.SectionTemplatesMock.SectionTemplatesBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateMock.DefaultTemplateBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateMock.TemplateBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;

import static org.mockito.Mockito.when;

public final class SectionTemplateMock {

    private SectionTemplateMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends SectionTemplate, TBUILDER extends SectionTemplateBuilder<T, TBUILDER>> TruncatedSectionTemplateBuilder<T> sectionTemplateWith(String uid, long id, UidType uidType, SectionTemplatesBuilder parent) {
        return new TruncatedDefaultSectionTemplateBuilder<>(uid, id, uidType, parent);
    }

    public interface SectionTemplateBuilder<T extends SectionTemplate, TBUILDER extends SectionTemplateBuilder<T, TBUILDER>> extends TemplateBuilder<T, TBUILDER>, PreviewImageProviderBuilder<T, TBUILDER> {
        TBUILDER aChannelSource(String channelSource, TemplateSetBuilder templateSet);
    }

    public static class DefaultSectionTemplateBuilder<T extends SectionTemplate, EBUILDER extends SectionTemplateBuilder<T, EBUILDER>, TBUILDER extends DefaultSectionTemplateBuilder<T, EBUILDER, TBUILDER>> extends DefaultTemplateBuilder<T, EBUILDER, TBUILDER> implements SectionTemplateBuilder<T, EBUILDER> {

        protected DefaultSectionTemplateBuilder(String uid, long id, UidType uidType, SectionTemplatesBuilder parent) {
            super(uid, id, uidType, parent);
        }

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultSectionTemplateBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }

        @Override
        public final EBUILDER aChannelSource(String channelSource, TemplateSetBuilder templateSet) {
            when(getBuildable().getChannelSource(getBuildable(templateSet))).thenReturn(channelSource);
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedSectionTemplateBuilder<T extends SectionTemplate> extends SectionTemplateBuilder<T, TruncatedSectionTemplateBuilder<T>> {
    }

    private static final class TruncatedDefaultSectionTemplateBuilder<T extends SectionTemplate> extends DefaultSectionTemplateBuilder<T, TruncatedSectionTemplateBuilder<T>, TruncatedDefaultSectionTemplateBuilder<T>> implements TruncatedSectionTemplateBuilder<T> {

        TruncatedDefaultSectionTemplateBuilder(String uid, long id, UidType uidType, SectionTemplatesBuilder parent) {
            super(uid, id, uidType, parent);
        }
    }

}
