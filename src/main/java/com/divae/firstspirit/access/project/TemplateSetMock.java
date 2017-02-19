package com.divae.firstspirit.access.project;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.project.TemplateSet;

import static org.mockito.Mockito.when;

public final class TemplateSetMock {

	private TemplateSetMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static TemplateSetBuilder templateSetWith(String uid) {
		return new DefaultTemplateSetBuilder(uid);
	}

	public interface TemplateSetBuilder extends Builder<TemplateSet, TemplateSetBuilder> {
		TemplateSetBuilder aPresentationChannelName(String presentationChannelName);
	}

	public static final class DefaultTemplateSetBuilder extends DefaultBuilder<TemplateSet, TemplateSetBuilder, DefaultTemplateSetBuilder> implements TemplateSetBuilder {

		private DefaultTemplateSetBuilder(String uid) {
			super(uid);
			anUid(uid);
		}

		@Override
		public final TemplateSetBuilder aPresentationChannelName(String presentationChannelName) {
			when(getBuildable().getPresentationChannelName()).thenReturn(presentationChannelName);
			return getBuilder();
		}

		private void anUid(String uid) {
			when(getBuildable().getUid()).thenReturn(uid);
		}
	}
}
