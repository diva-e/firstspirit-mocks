package com.divae.firstspirit.access;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.MessageService;

public final class MessageServiceMock {

	private MessageServiceMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static MessageServiceBuilder messageServiceWith() {
		return new DefaultMessageServiceBuilder();
	}

	public interface MessageServiceBuilder extends Builder<MessageService, MessageServiceBuilder> {
	}

	public static final class DefaultMessageServiceBuilder extends DefaultBuilder<MessageService, MessageServiceBuilder, DefaultMessageServiceBuilder> implements MessageServiceBuilder {

		private DefaultMessageServiceBuilder() {
		}
	}
}
