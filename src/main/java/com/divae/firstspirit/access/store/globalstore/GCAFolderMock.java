package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.globalstore.GCAFolder;

public final class GCAFolderMock {

	private GCAFolderMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> GCAFolderBuilder gcaFolderWith(String name, long id, TBUILDER parent) {
		return new DefaultGCAFolderBuilder(name, id, parent);
	}

	public interface GCAFolderBuilder extends IDProviderBuilder<GCAFolder, GCAFolderBuilder> {
	}

	public static final class DefaultGCAFolderBuilder extends DefaultIDProviderBuilder<GCAFolder, GCAFolderBuilder, DefaultGCAFolderBuilder> implements GCAFolderBuilder {

		private <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> DefaultGCAFolderBuilder(String name, long id, TBUILDER parent) {
			super(name, id, parent);
		}
	}
}
