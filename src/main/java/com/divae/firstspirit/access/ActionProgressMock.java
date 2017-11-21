package com.divae.firstspirit.access;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.ActionProgress;

public final class ActionProgressMock {

    private ActionProgressMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends ActionProgress> TruncatedActionProgressBuilder<T> actionProgressWith() {
        return new TruncatedDefaultActionProgressBuilder<>();
    }

    public interface ActionProgressBuilder<T extends ActionProgress, TBUILDER extends ActionProgressBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
    }

    public static class DefaultActionProgressBuilder<T extends ActionProgress, EBUILDER extends ActionProgressBuilder<T, EBUILDER>, TBUILDER extends DefaultActionProgressBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements ActionProgressBuilder<T, EBUILDER> {

        protected DefaultActionProgressBuilder() {
        }
    }

    public interface TruncatedActionProgressBuilder<T extends ActionProgress> extends ActionProgressBuilder<T, TruncatedActionProgressBuilder<T>> {
    }

    private static final class TruncatedDefaultActionProgressBuilder<T extends ActionProgress> extends DefaultActionProgressBuilder<T, TruncatedActionProgressBuilder<T>, TruncatedDefaultActionProgressBuilder<T>> implements TruncatedActionProgressBuilder<T> {

        private TruncatedDefaultActionProgressBuilder() {
        }
    }
}