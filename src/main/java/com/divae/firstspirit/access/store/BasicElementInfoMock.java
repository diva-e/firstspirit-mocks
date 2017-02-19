package com.divae.firstspirit.access.store;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.store.BasicElementInfo;

import static org.mockito.Mockito.when;

public final class BasicElementInfoMock {

	private BasicElementInfoMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static BasicElementInfoBuilder basicElementInfoWith(String uid) {
		return new DefaultBasicElementInfoBuilder(uid);
	}

	public interface BasicElementInfoBuilder extends Builder<BasicElementInfo, BasicElementInfoBuilder> {
	}

	public static class DefaultBasicElementInfoBuilder extends DefaultBuilder<BasicElementInfo, BasicElementInfoBuilder, DefaultBasicElementInfoBuilder> implements BasicElementInfoBuilder {

		private DefaultBasicElementInfoBuilder(String uid) {
			super(uid);
			anUid(uid);
		}

		private void anUid(String uid) {
			when(getBuildable().getUid()).thenReturn(uid);
		}
	}
}
