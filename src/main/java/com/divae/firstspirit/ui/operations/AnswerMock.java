package com.divae.firstspirit.ui.operations;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.ui.operations.RequestOperation.Answer;

public final class AnswerMock {

    private AnswerMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static AnswerBuilder answerWith() {
        return new DefaultAnswerBuilder();
    }

    public interface AnswerBuilder extends Builder<Answer, AnswerBuilder> {
    }

    private static final class DefaultAnswerBuilder extends DefaultBuilder<Answer, AnswerBuilder, DefaultAnswerBuilder> implements AnswerBuilder {

        private DefaultAnswerBuilder() {
        }
    }
}
