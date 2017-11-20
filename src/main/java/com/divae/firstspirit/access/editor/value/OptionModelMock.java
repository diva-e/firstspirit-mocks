package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.editor.value.OptionModel;

public class OptionModelMock {

    private OptionModelMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static OptionModelBuilder optionModelWith() {
        return new DefaultOptionModelBuilder();
    }

    public interface OptionModelBuilder extends Builder<OptionModel, OptionModelBuilder> {
    }

    public static final class DefaultOptionModelBuilder extends DefaultBuilder<OptionModel, OptionModelBuilder, DefaultOptionModelBuilder> implements OptionModelBuilder {

        private DefaultOptionModelBuilder() {
        }

    }
}
