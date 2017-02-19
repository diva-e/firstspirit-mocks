package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.editor.value.DomElement;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public final class DomElementMock {

	private DomElementMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static DomElementBuilder domElementWith() {
		return new DefaultDomElementBuilder();
	}

	public interface DomElementBuilder extends Builder<DomElement, DomElementBuilder> {
		DomElementBuilder toText(String html, boolean asHtml);
	}

	public static final class DefaultDomElementBuilder extends DefaultBuilder<DomElement, DomElementBuilder, DefaultDomElementBuilder> implements DomElementBuilder {

		private DefaultDomElementBuilder() {
			doAnswer(invocation -> {
				Object[] args = invocation.getArguments();
				toText((String) args[0], true);
				return null;
			}).when(getBuildable()).parseHtml(anyString());
		}

		@Override
		public final DomElementBuilder toText(String html, boolean asHtml) {
			when(getBuildable().toText(asHtml)).thenReturn(html);
			return getBuilder();
		}
	}
}
