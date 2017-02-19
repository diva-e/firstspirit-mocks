package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import de.espirit.firstspirit.access.project.TemplateSet;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreFolder;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.project.TemplateSetMock.templateSetWith;
import static com.divae.firstspirit.access.store.sitestore.PageRefMock.pageRefWith;
import static com.divae.firstspirit.access.store.sitestore.SiteStoreFolderMock.siteStoreFolderWith;
import static com.divae.firstspirit.access.store.sitestore.SiteStoreRootMock.siteStoreRootWith;
import static com.divae.firstspirit.access.store.sitestore.StartNodeMock.startNodeWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.SITESTORE_LEAF;
import static java.lang.Boolean.TRUE;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SiteStoreFolderMockTest extends MockTest {

	@Test
	public void testSiteStoreFolderWithStringLongSiteStoreRootBuilder() {
		assertThat(siteStoreFolderWith("test", 2, null), is(notNullValue()));
	}

	@Test
	public void testSiteStoreFolderWithSiteStoreFolder() {
		assertThat(siteStoreFolderWith(siteStoreFolderWith("test", 2, null)), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return SiteStoreFolderMock.class;
	}

	@Test
	public void testDefaults() {
		SiteStoreFolder siteStoreFolder = build(siteStoreFolderWith("test", 2, null));
		assertThat(siteStoreFolder.getStore(), is(nullValue()));
	}

	@Test
	public void testAStartNodePageRefBuilder() {
		SiteStoreFolder siteStoreFolder = (SiteStoreFolder) build(siteStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> singletonList(siteStoreFolderWith("siteStoreFolder", 2, parent).aStartNode(siteStoreFolderParent -> pageRefWith("startNode", 3, siteStoreFolderParent))))).getChildren().iterator().next();
		assertThat(siteStoreFolder.getStartNode().getUid(), is("startNode"));
	}

	@Test
	public void testAStartNodeSiteStoreFolderRefBuilder() {
		SiteStoreFolder siteStoreFolder = (SiteStoreFolder) build(siteStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> singletonList(siteStoreFolderWith("siteStoreFolder", 2, parent).aStartNode(siteStoreFolderParent -> siteStoreFolderWith("startNode", 3, siteStoreFolderParent))))).getChildren().iterator().next();
		assertThat(siteStoreFolder.getStartNode().getUid(), is("startNode"));
	}

	@Test
	public void testAStartNodeStartNodeBuilder() {
		SiteStoreFolder siteStoreFolder = (SiteStoreFolder) build(siteStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> singletonList(siteStoreFolderWith("siteStoreFolder", 2, parent).aStartNode(siteStoreFolderParent -> startNodeWith("startNode", 3, SITESTORE_LEAF, siteStoreFolderParent))))).getChildren().iterator().next();
		assertThat(siteStoreFolder.getStartNode().getUid(), is("startNode"));
	}

	@Test
	public void testIsStartNode() {
		SiteStoreFolder siteStoreFolder = build(siteStoreFolderWith("test", 2, null).isStartNode(true));
		assertThat(siteStoreFolder.isStartNode(), is(TRUE));
	}

	@Test
	public void testAStoredUrl() {
		LanguageBuilder languageBuilder = languageWith("DE");
		TemplateSetBuilder templateSetBuilder = templateSetWith("test");
		SiteStoreFolder siteStoreFolder = build(siteStoreFolderWith("test", 2, null).aStoredUrl("test", languageBuilder, templateSetBuilder));
		TemplateSet templateSet = build(templateSetBuilder);
		assertThat(siteStoreFolder.getStoredUrl(build(languageBuilder), templateSet), is("test"));
	}
}
