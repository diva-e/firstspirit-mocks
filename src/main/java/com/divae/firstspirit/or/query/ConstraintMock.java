package com.divae.firstspirit.or.query;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.or.query.Constraint;

public final class ConstraintMock {

    private ConstraintMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static ConstraintBuilder constraintWith() {
        return new DefaultConstraintBuilder();
    }

    public interface ConstraintBuilder extends Builder<Constraint, ConstraintBuilder> {
    }

    private static final class DefaultConstraintBuilder extends DefaultBuilder<Constraint, ConstraintBuilder, DefaultConstraintBuilder> implements ConstraintBuilder {

        private DefaultConstraintBuilder() {
        }
    }
}
