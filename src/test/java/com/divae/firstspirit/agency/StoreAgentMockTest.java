package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.contentstore.ContentStoreRootMock.ContentStoreRootBuilder;
import com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.GlobalStoreRootBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaStoreRootMock.MediaStoreRootBuilder;
import com.divae.firstspirit.access.store.pagestore.PageStoreRootMock.PageStoreRootBuilder;
import com.divae.firstspirit.access.store.sitestore.SiteStoreRootMock.SiteStoreRootBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.TemplateStoreRootBuilder;
import de.espirit.firstspirit.access.store.contentstore.ContentStoreRoot;
import de.espirit.firstspirit.access.store.globalstore.GlobalStoreRoot;
import de.espirit.firstspirit.access.store.mediastore.MediaStoreRoot;
import de.espirit.firstspirit.access.store.pagestore.PageStoreRoot;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreRoot;
import de.espirit.firstspirit.access.store.templatestore.TemplateStoreRoot;
import de.espirit.firstspirit.agency.StoreAgent;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.contentstore.ContentStoreRootMock.contentStoreRootWith;
import static com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.globalStoreRootWith;
import static com.divae.firstspirit.access.store.mediastore.MediaStoreRootMock.mediaStoreRootWith;
import static com.divae.firstspirit.access.store.pagestore.PageStoreRootMock.pageStoreRootWith;
import static com.divae.firstspirit.access.store.sitestore.SiteStoreRootMock.siteStoreRootWith;
import static com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.templateStoreRootWith;
import static com.divae.firstspirit.agency.StoreAgentMock.storeAgentWith;
import static de.espirit.firstspirit.access.store.Store.Type.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StoreAgentMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return StoreAgentMock.class;
	}

	@Test
	public void testAContentStoreRootContentStoreRootBoolean() {
		ContentStoreRootBuilder contentStoreRootBuilder = contentStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aContentStoreRoot(contentStoreRootBuilder, true));
		ContentStoreRoot contentStoreRoot = build(contentStoreRootBuilder);
		assertThat(storeAgent.getStore(CONTENTSTORE, TRUE), is(contentStoreRoot));
	}

	@Test
	public void testAContentStoreRootContentStoreRootBoolean2() {
		ContentStoreRootBuilder contentStoreRootBuilder = contentStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aContentStoreRoot(contentStoreRootBuilder, false));
		ContentStoreRoot contentStoreRoot = build(contentStoreRootBuilder);
		assertThat(storeAgent.getStore(CONTENTSTORE, FALSE), is(contentStoreRoot));
		assertThat(storeAgent.getStore(CONTENTSTORE), is(contentStoreRoot));
	}

	@Test
	public void testAContentStoreContentStoreRootRoot() {
		ContentStoreRootBuilder contentStoreRootBuilder = contentStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aContentStoreRoot(contentStoreRootBuilder));
		ContentStoreRoot contentStoreRoot = build(contentStoreRootBuilder);
		assertThat(storeAgent.getStore(CONTENTSTORE), is(contentStoreRoot));
		assertThat(storeAgent.getStore(CONTENTSTORE, false), is(contentStoreRoot));
	}


	@Test
	public void testAGlobalStoreRootGlobalStoreRootBoolean() {
		GlobalStoreRootBuilder globalStoreRootBuilder = globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aGlobalStoreRoot(globalStoreRootBuilder, true));
		GlobalStoreRoot globalStoreRoot = build(globalStoreRootBuilder);
		assertThat(storeAgent.getStore(GLOBALSTORE, TRUE), is(globalStoreRoot));
	}

	@Test
	public void testAGlobalStoreRootGlobalStoreRootBoolean2() {
		GlobalStoreRootBuilder globalStoreRootBuilder = globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aGlobalStoreRoot(globalStoreRootBuilder, false));
		GlobalStoreRoot globalStoreRoot = build(globalStoreRootBuilder);
		assertThat(storeAgent.getStore(GLOBALSTORE, FALSE), is(globalStoreRoot));
		assertThat(storeAgent.getStore(GLOBALSTORE), is(globalStoreRoot));
	}

	@Test
	public void testAGlobalStoreRootGlobalStoreRoot() {
		GlobalStoreRootBuilder globalStoreRootBuilder = globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aGlobalStoreRoot(globalStoreRootBuilder));
		GlobalStoreRoot globalStoreRoot = build(globalStoreRootBuilder);
		assertThat(storeAgent.getStore(GLOBALSTORE), is(globalStoreRoot));
		assertThat(storeAgent.getStore(GLOBALSTORE, false), is(globalStoreRoot));
	}

	@Test
	public void testAMediaStoreRoot() {
		MediaStoreRootBuilder mediaStoreRootBuilder = mediaStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aMediaStoreRoot(mediaStoreRootBuilder));
		MediaStoreRoot mediaStoreRoot = build(mediaStoreRootBuilder);
		assertThat(storeAgent.getStore(MEDIASTORE), is(mediaStoreRoot));
		assertThat(storeAgent.getStore(MEDIASTORE, false), is(mediaStoreRoot));
	}

	@Test
	public void testAhMediaStoreRootBoolean() {
		MediaStoreRootBuilder mediaStoreRootBuilder = mediaStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aMediaStoreRoot(mediaStoreRootBuilder, true));
		MediaStoreRoot mediaStoreRoot = build(mediaStoreRootBuilder);
		assertThat(storeAgent.getStore(MEDIASTORE, TRUE), is(mediaStoreRoot));
	}

	@Test
	public void testAMediaStoreRootBoolean2() {
		MediaStoreRootBuilder mediaStoreRootBuilder = mediaStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aMediaStoreRoot(mediaStoreRootBuilder, false));
		MediaStoreRoot mediaStoreRoot = build(mediaStoreRootBuilder);
		assertThat(storeAgent.getStore(MEDIASTORE, FALSE), is(mediaStoreRoot));
		assertThat(storeAgent.getStore(MEDIASTORE), is(mediaStoreRoot));
	}

	@Test
	public void testASiteStoreRoot() {
		SiteStoreRootBuilder siteStoreRootBuilder = siteStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aSiteStoreRoot(siteStoreRootBuilder));
		SiteStoreRoot siteStoreRoot = build(siteStoreRootBuilder);
		assertThat(storeAgent.getStore(SITESTORE), is(siteStoreRoot));
		assertThat(storeAgent.getStore(SITESTORE, false), is(siteStoreRoot));
	}

	@Test
	public void testASiteStoreRootBoolean() {
		SiteStoreRootBuilder siteStoreRootBuilder = siteStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aSiteStoreRoot(siteStoreRootBuilder, true));
		SiteStoreRoot siteStoreRoot = build(siteStoreRootBuilder);
		assertThat(storeAgent.getStore(SITESTORE, TRUE), is(siteStoreRoot));
	}

	@Test
	public void testASiteStoreRootBoolean2() {
		SiteStoreRootBuilder siteStoreRootBuilder = siteStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aSiteStoreRoot(siteStoreRootBuilder, false));
		SiteStoreRoot siteStoreRoot = build(siteStoreRootBuilder);
		assertThat(storeAgent.getStore(SITESTORE, FALSE), is(siteStoreRoot));
		assertThat(storeAgent.getStore(SITESTORE), is(siteStoreRoot));
	}

	@Test
	public void testATemplateStoreRoot() {
		TemplateStoreRootBuilder templateStoreRootBuilder = templateStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aTemplateStoreRoot(templateStoreRootBuilder));
		TemplateStoreRoot templateStoreRoot = build(templateStoreRootBuilder);
		assertThat(storeAgent.getStore(TEMPLATESTORE), is(templateStoreRoot));
		assertThat(storeAgent.getStore(TEMPLATESTORE, false), is(templateStoreRoot));
	}

	@Test
	public void testATemplateStoreRootBoolean() {
		TemplateStoreRootBuilder templateStoreRootBuilder = templateStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aTemplateStoreRoot(templateStoreRootBuilder, true));
		TemplateStoreRoot templateStoreRoot = build(templateStoreRootBuilder);
		assertThat(storeAgent.getStore(TEMPLATESTORE, TRUE), is(templateStoreRoot));
	}

	@Test
	public void testATemplateStoreRootBoolean2() {
		TemplateStoreRootBuilder templateStoreRootBuilder = templateStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aTemplateStoreRoot(templateStoreRootBuilder, false));
		TemplateStoreRoot templateStoreRoot = build(templateStoreRootBuilder);
		assertThat(storeAgent.getStore(TEMPLATESTORE, FALSE), is(templateStoreRoot));
		assertThat(storeAgent.getStore(TEMPLATESTORE), is(templateStoreRoot));
	}

	@Test
	public void testAPageStoreRoot() {
		PageStoreRootBuilder pageStoreRootBuilder = pageStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aPageStoreRoot(pageStoreRootBuilder));
		PageStoreRoot pageStoreRoot = build(pageStoreRootBuilder);
		assertThat(storeAgent.getStore(PAGESTORE), is(pageStoreRoot));
		assertThat(storeAgent.getStore(PAGESTORE, false), is(pageStoreRoot));
	}

	@Test
	public void testAPageStoreRootBoolean() {
		PageStoreRootBuilder pageStoreRootBuilder = pageStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aPageStoreRoot(pageStoreRootBuilder, true));
		PageStoreRoot pageStoreRoot = build(pageStoreRootBuilder);
		assertThat(storeAgent.getStore(PAGESTORE, TRUE), is(pageStoreRoot));
	}

	@Test
	public void testAPageStoreRootBoolean2() {
		PageStoreRootBuilder pageStoreRootBuilder = pageStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
		StoreAgent storeAgent = build(storeAgentWith().aPageStoreRoot(pageStoreRootBuilder, false));
		PageStoreRoot pageStoreRoot = build(pageStoreRootBuilder);
		assertThat(storeAgent.getStore(PAGESTORE, FALSE), is(pageStoreRoot));
		assertThat(storeAgent.getStore(PAGESTORE), is(pageStoreRoot));
	}
}
