package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.editor.value.TargetReference;
import de.espirit.firstspirit.access.store.IDProvider;

import static org.mockito.Mockito.when;

public final class TargetReferenceMock {

	private TargetReferenceMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static TargetReferenceBuilder targetReferenceWith(String uid) {
		return new DefaultTargetReferenceBuilder(uid);
	}

	public interface TargetReferenceBuilder extends Builder<TargetReference, TargetReferenceBuilder> {
		<T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> TargetReferenceBuilder aValue(TBUILDER idProvider);
	}

	public static final class DefaultTargetReferenceBuilder extends DefaultBuilder<TargetReference, TargetReferenceBuilder, DefaultTargetReferenceBuilder> implements TargetReferenceBuilder {

		private DefaultTargetReferenceBuilder(String uid) {
			super(uid);
			anUid(uid);
		}

		@Override
		public final <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> TargetReferenceBuilder aValue(TBUILDER idProvider) {
			when(getBuildable().get()).thenReturn(getBuildable(idProvider));
			return getBuilder();
		}

		private void anUid(String uid) {
			when(getBuildable().getUid()).thenReturn(uid);
		}
	}

}
