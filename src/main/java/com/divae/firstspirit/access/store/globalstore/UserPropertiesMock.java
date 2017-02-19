package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.GlobalStoreRootBuilder;
import de.espirit.firstspirit.access.store.globalstore.UserProperties;

public final class UserPropertiesMock {

	private UserPropertiesMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static UserPropertiesBuilder userPropertiesWith(String name, long id, GlobalStoreRootBuilder parent) {
		return new DefaultUserPropertiesBuilder(name, id, parent);
	}

	public interface UserPropertiesBuilder extends IDProviderBuilder<UserProperties, UserPropertiesBuilder> {
	}

	public static final class DefaultUserPropertiesBuilder extends DefaultIDProviderBuilder<UserProperties, UserPropertiesBuilder, DefaultUserPropertiesBuilder> implements UserPropertiesBuilder {

		private DefaultUserPropertiesBuilder(String name, long id, GlobalStoreRootBuilder parent) {
			super(name, id, parent);
		}
	}

}
