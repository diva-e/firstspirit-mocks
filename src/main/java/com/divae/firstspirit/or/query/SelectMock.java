package com.divae.firstspirit.or.query;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.or.query.ConstraintMock.ConstraintBuilder;
import de.espirit.or.query.Constraint;
import de.espirit.or.query.Select;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class SelectMock {

    private SelectMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static SelectBuilder selectWith() {
        return new DefaultSelectBuilder();
    }

    public interface SelectBuilder extends Builder<Select, SelectBuilder> {
        SelectBuilder aConstraint(Supplier<ConstraintBuilder> supplier);
    }

    public static final class DefaultSelectBuilder extends DefaultBuilder<Select, SelectBuilder, DefaultSelectBuilder> implements SelectBuilder {

        private DefaultSelectBuilder() {
        }

        @Override
        public final SelectBuilder aConstraint(Supplier<ConstraintBuilder> supplier) {
            Constraint constraint = build(supplier.get());
            when(getBuildable().getConstraint()).thenReturn(constraint);
            return getBuilder();
        }
    }
}
