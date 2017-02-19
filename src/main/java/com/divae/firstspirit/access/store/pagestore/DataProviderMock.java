package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.forms.FormDataMock.FormDataBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.pagestore.DataProvider;
import de.espirit.firstspirit.forms.FormData;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class DataProviderMock {

	private DataProviderMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends DataProvider, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDataProviderBuilder<T> dataProviderWith(String name, long id, OTBUILDER parent) {
		return new TruncatedDefaultDataProviderBuilder<>(name, id, parent);
	}

	public static <T extends DataProvider, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDataProviderBuilder<T> dataProviderWith(String uid, long id, UidType uidType, OTBUILDER parent) {
		return new TruncatedDefaultDataProviderBuilder<>(uid, id, uidType, parent);
	}

	public static <T extends DataProvider, OTUILDER extends DataProviderBuilder<T, OTUILDER>> TruncatedDataProviderBuilder<T> dataProviderWith(OTUILDER dataProvider) {
		return new TruncatedDefaultDataProviderBuilder<>(dataProvider);
	}

	public interface DataProviderBuilder<T extends DataProvider, TBUILDER extends DataProviderBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
		<OT extends FormData, OTUILDER extends FormDataBuilder<OT, OTUILDER>> TBUILDER aFormData(Supplier<OTUILDER> supplier);
	}

	public static class DefaultDataProviderBuilder<T extends DataProvider, EBUILDER extends DataProviderBuilder<T, EBUILDER>, TBUILDER extends DefaultDataProviderBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements DataProviderBuilder<T, EBUILDER> {

		protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultDataProviderBuilder(String name, long id, OTBUILDER parent) {
			super(name, id, parent);
		}

		protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultDataProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
			super(uid, id, uidType, parent);
		}

		protected <OTBUILDER extends DataProviderBuilder<T, OTBUILDER>> DefaultDataProviderBuilder(OTBUILDER builder) {
			super(builder);
		}

		@Override
		public final <OT extends FormData, OTBUILDER extends FormDataBuilder<OT, OTBUILDER>> EBUILDER aFormData(Supplier<OTBUILDER> supplier) {
			FormData formData = build(supplier.get());
			when(getBuildable().getFormData()).thenReturn(formData);
			return getInterfaceBuilder();
		}
	}

	public interface TruncatedDataProviderBuilder<T extends DataProvider> extends DataProviderBuilder<T, TruncatedDataProviderBuilder<T>> {
	}

	private static final class TruncatedDefaultDataProviderBuilder<T extends DataProvider> extends DefaultDataProviderBuilder<T, TruncatedDataProviderBuilder<T>, TruncatedDefaultDataProviderBuilder<T>> implements TruncatedDataProviderBuilder<T> {

		<OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultDataProviderBuilder(String name, long id, OTBUILDER parent) {
			super(name, id, parent);
		}

		<OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultDataProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
			super(uid, id, uidType, parent);
		}

		<OTBUILDER extends DataProviderBuilder<T, OTBUILDER>> TruncatedDefaultDataProviderBuilder(OTBUILDER builder) {
			super(builder);
		}
	}
}
