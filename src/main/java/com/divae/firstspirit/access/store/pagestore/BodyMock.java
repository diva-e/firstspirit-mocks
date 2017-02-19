package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.pagestore.PageMock.PageBuilder;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.pagestore.Body;
import de.espirit.firstspirit.access.store.pagestore.Page;

public final class BodyMock {

	private BodyMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends Body, OT extends Page, OTBUILDER extends PageBuilder<OT, OTBUILDER>> TruncatedBodyBuilder<T> bodyWith(String uid, long id, UidType uidType, OTBUILDER parent) {
		return new TruncatedDefaultBodyBuilder<>(uid, id, uidType, parent);
	}

	public static <T extends Body, OT extends Page, OTBUILDER extends PageBuilder<OT, OTBUILDER>> TruncatedBodyBuilder<T> bodyWith(String name, long id, OTBUILDER parent) {
		return new TruncatedDefaultBodyBuilder<>(name, id, parent);
	}

	public interface BodyBuilder<T extends Body, TBUILDER extends BodyBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
	}

	public static class DefaultBodyBuilder<T extends Body, EBUILDER extends BodyBuilder<T, EBUILDER>, TBUILDER extends DefaultBodyBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements BodyBuilder<T, EBUILDER> {

		protected <OT extends Page, OTBUILDER extends PageBuilder<OT, OTBUILDER>> DefaultBodyBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
			super(uid, id, uidType, parent);
		}

		protected <OT extends Page, OTBUILDER extends PageBuilder<OT, OTBUILDER>> DefaultBodyBuilder(String name, long id, OTBUILDER parent) {
			super(name, id, parent);
		}
	}

	public interface TruncatedBodyBuilder<T extends Body> extends BodyBuilder<T, TruncatedBodyBuilder<T>> {
	}

	private static final class TruncatedDefaultBodyBuilder<T extends Body> extends DefaultBodyBuilder<T, TruncatedBodyBuilder<T>, TruncatedDefaultBodyBuilder<T>> implements TruncatedBodyBuilder<T> {

		<OT extends Page, OTBUILDER extends PageBuilder<OT, OTBUILDER>> TruncatedDefaultBodyBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
			super(uid, id, uidType, parent);
		}

		<OT extends Page, OTBUILDER extends PageBuilder<OT, OTBUILDER>> TruncatedDefaultBodyBuilder(String name, long id, OTBUILDER parent) {
			super(name, id, parent);
		}
	}
}
