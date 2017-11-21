package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.editor.value.OptionModel;

public class OptionModelMock {

    private OptionModelMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends OptionModel> TruncatedOptionModelBuilder<T> optionModelWith() {
        return new TruncatedDefaultOptionModelBuilder<>();
    }

    public interface OptionModelBuilder<T extends OptionModel, TBUILDER extends OptionModelBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
    }

    public interface TruncatedOptionModelBuilder<T extends OptionModel> extends OptionModelBuilder<T, TruncatedOptionModelBuilder<T>> {
    }

    public static class DefaultOptionModelBuilder<T extends OptionModel, EBUILDER extends OptionModelBuilder<T, EBUILDER>, TBUILDER extends DefaultOptionModelBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements OptionModelBuilder<T, EBUILDER> {

        protected DefaultOptionModelBuilder() {
        }

        protected <OTBUILDER extends OptionModelBuilder<T, OTBUILDER>> DefaultOptionModelBuilder(OTBUILDER optionModelBuilder) {
            super(optionModelBuilder);
        }

    }

    private static final class TruncatedDefaultOptionModelBuilder<T extends OptionModel> extends DefaultOptionModelBuilder<T, TruncatedOptionModelBuilder<T>, TruncatedDefaultOptionModelBuilder<T>> implements TruncatedOptionModelBuilder<T> {

        private TruncatedDefaultOptionModelBuilder() {
        }
    }
}
