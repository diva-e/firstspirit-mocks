package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.access.store.globalstore.GCABodyMock.GCABodyBuilder;
import com.divae.firstspirit.access.store.pagestore.SectionMock.DefaultSectionBuilder;
import com.divae.firstspirit.access.store.pagestore.SectionMock.SectionBuilder;
import de.espirit.firstspirit.access.store.globalstore.GCASection;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;

public final class GCASectionMock {

    private GCASectionMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static GCASectionBuilder gcaSectionWith(String name, long id, GCABodyBuilder parent) {
        return new DefaultGCASectionBuilder(name, id, parent);
    }

    public interface GCASectionBuilder extends SectionBuilder<SectionTemplate, GCASection, GCASectionBuilder> {
    }

    private static final class DefaultGCASectionBuilder extends DefaultSectionBuilder<SectionTemplate, GCASection, GCASectionBuilder, DefaultGCASectionBuilder> implements GCASectionBuilder {

        private DefaultGCASectionBuilder(String name, long id, GCABodyBuilder parent) {
            super(name, id, parent);
        }

    }

}
