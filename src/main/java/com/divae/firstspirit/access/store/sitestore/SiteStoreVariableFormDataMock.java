package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.forms.FormDataMock.DefaultFormDataBuilder;
import com.divae.firstspirit.forms.FormDataMock.FormDataBuilder;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreVariableFormData;


public final class SiteStoreVariableFormDataMock {

	private SiteStoreVariableFormDataMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static SiteStoreVariableFormDataBuilder siteStoreVariableFormDataWith() {
		return new DefaultSiteStoreVariableFormDataBuilder();
	}

	public interface SiteStoreVariableFormDataBuilder extends FormDataBuilder<SiteStoreVariableFormData, SiteStoreVariableFormDataBuilder> {
	}

	public static final class DefaultSiteStoreVariableFormDataBuilder extends DefaultFormDataBuilder<SiteStoreVariableFormData, SiteStoreVariableFormDataBuilder, DefaultSiteStoreVariableFormDataBuilder> implements SiteStoreVariableFormDataBuilder {

		DefaultSiteStoreVariableFormDataBuilder() {
		}
	}
}
