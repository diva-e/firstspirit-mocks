package com.divae.firstspirit.access.editor;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.editor.FormDataProducer;

public final class FormDataProducerMock {

    private FormDataProducerMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends FormDataProducer> TruncatedFormDataProducerBuilder<T> formDataProducerWith() {
        return new DefaultTruncatedFormDataProducerBuilder<>();
    }

    public interface FormDataProducerBuilder<T extends FormDataProducer, TBUILDER extends FormDataProducerBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
    }

    public static class DefaultFormDataProducerBuilder<T extends FormDataProducer, EBUILDER extends FormDataProducerBuilder<T, EBUILDER>, TBUILDER extends DefaultFormDataProducerBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements FormDataProducerBuilder<T, EBUILDER> {

        protected DefaultFormDataProducerBuilder() {
        }
    }

    public interface TruncatedFormDataProducerBuilder<T extends FormDataProducer> extends FormDataProducerBuilder<T, TruncatedFormDataProducerBuilder<T>> {
    }

    private static final class DefaultTruncatedFormDataProducerBuilder<T extends FormDataProducer> extends DefaultFormDataProducerBuilder<T, TruncatedFormDataProducerBuilder<T>, DefaultTruncatedFormDataProducerBuilder<T>> implements TruncatedFormDataProducerBuilder<T> {

        private DefaultTruncatedFormDataProducerBuilder() {
        }
    }
}
