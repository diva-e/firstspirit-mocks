package com.divae.firstspirit.access.link;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.forms.FormDataMock.FormDataBuilder;
import de.espirit.firstspirit.access.link.Link;
import de.espirit.firstspirit.forms.FormData;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class LinkMock {

    private LinkMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static LinkBuilder linkWith() {
        return new DefaultLinkBuilder();
    }

    public interface LinkBuilder extends Builder<Link, LinkBuilder> {
        <T extends FormData, TBUILDER extends FormDataBuilder<T, TBUILDER>> LinkBuilder aFormData(Supplier<TBUILDER> supplier);
    }

    public static final class DefaultLinkBuilder extends DefaultBuilder<Link, LinkBuilder, DefaultLinkBuilder> implements LinkBuilder {

        private DefaultLinkBuilder() {
        }

        @Override
        public final <T extends FormData, TBUILDER extends FormDataBuilder<T, TBUILDER>> LinkBuilder aFormData(Supplier<TBUILDER> supplier) {
            FormData formData = build(supplier.get());
            when(getBuildable().getFormData()).thenReturn(formData);
            return getBuilder();
        }
    }

}
