package com.divae.firstspirit.generate;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaStoreRootMock.MediaStoreRootBuilder;
import com.divae.firstspirit.generate.PathLookupMock.DefaultPathLookupBuilder;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.store.mediastore.Media;
import de.espirit.firstspirit.access.store.mediastore.MediaStoreRoot;
import de.espirit.firstspirit.access.store.pagestore.Page;
import de.espirit.firstspirit.access.store.sitestore.PageRefFolder;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreRoot;
import de.espirit.firstspirit.generate.PathLookup;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.project.TemplateSetMock.templateSetWith;
import static com.divae.firstspirit.access.store.mediastore.MediaMock.mediaWith;
import static com.divae.firstspirit.access.store.mediastore.MediaStoreRootMock.mediaStoreRootWith;
import static com.divae.firstspirit.access.store.pagestore.PageMock.pageWith;
import static com.divae.firstspirit.access.store.sitestore.PageRefFolderMock.pageRefFolderWith;
import static com.divae.firstspirit.access.store.sitestore.SiteStoreRootMock.siteStoreRootWith;
import static com.divae.firstspirit.generate.PathLookupMock.pathLookupWith;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class PathLookupMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return PathLookupMock.class;
	}

	@Test
	public void testAnIdProvider() {
		LanguageBuilder languageBuilder = languageWith("DE");
		ProjectBuilder projectBuilder = projectWith("test", 0, languageBuilder);
		MediaStoreRootBuilder mediaStoreRootBuilder = mediaStoreRootWith(1, projectBuilder).children(parent -> singletonList(mediaWith("test", 2, parent)));
		String storedUrl = "url";
		TemplateSetBuilder templateSetBuilder = templateSetWith("test");
		PathLookup pathLookup = build(pathLookupWith().anIdProvider(languageBuilder, templateSetBuilder, storedUrl, mediaStoreRootBuilder));
		Media media = (Media) build(mediaStoreRootBuilder).getChildren().iterator().next();
		assertThat(pathLookup.lookupPath(media, media.getProject().getMasterLanguage(), build(templateSetBuilder)), is(nullValue()));
	}

	@Test
	public void testAStore() {
		LanguageBuilder languageBuilder = languageWith("DE");
		MediaStoreRootBuilder mediaStoreRootBuilder = mediaStoreRootWith(1, projectWith("test", 0, languageBuilder));
		TemplateSetBuilder templateSetBuilder = templateSetWith("test");
		PathLookup pathLookup = build(pathLookupWith().aStore(languageBuilder, templateSetBuilder, mediaStoreRootBuilder));
		MediaStoreRoot mediaStoreRoot = build(mediaStoreRootBuilder);
		Language masterLanguage = build(languageBuilder);
		assertThat(pathLookup.lookupPath(mediaStoreRoot, masterLanguage, build(templateSetBuilder)), is(""));
	}

	@Test
	public void testExtractPathWithMediaHttpsUrl() {
		String uid = "test";
		Media media = build(mediaWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(media, "https://" + uid);
		assertThat(extractedPath, is(nullValue()));
	}

	@Test
	public void testExtractPathWithMediaHttpUrl() {
		String uid = "test";
		Media media = build(mediaWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(media, "http://" + uid);
		assertThat(extractedPath, is(nullValue()));
	}

	@Test
	public void testExtractPathWithMediaNullUrl() {
		String uid = "test";
		Media media = build(mediaWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(media, null);
		assertThat(extractedPath, is(nullValue()));
	}

	@Test
	public void testExtractPathWithMediaEmptyUrl() {
		String uid = "test";
		Media media = build(mediaWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(media, "");
		assertThat(extractedPath, is(nullValue()));
	}

	@Test
	public void testExtractPathWithMediaSlashStartedUrl() {
		String uid = "test";
		Media media = build(mediaWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(media, "/" + uid);
		assertThat(extractedPath, is(nullValue()));
	}

	@Test
	public void testExtractPathWithContentProducerSlashStartedUrl() {
		String uid = "test";
		Page page = build(pageWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(page, "/" + uid);
		assertThat(extractedPath, is(""));
	}

	@Test
	public void testExtractPathWithContentProducerSlashEndedUrl() {
		String uid = "test";
		Page page = build(pageWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(page, uid + "/");
		assertThat(extractedPath, is(uid));
	}

	@Test
	public void testExtractPathWithContentProducerEmptyUrl() {
		Page page = build(pageWith("test", 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(page, "");
		assertThat(extractedPath, is(""));
	}

	@Test
	public void testExtractPathWithSiteStoreFolderSlashStartedUrl() {
		String uid = "test";
		PageRefFolder pageRefFolder = build(pageRefFolderWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(pageRefFolder, "/" + uid);
		assertThat(extractedPath, is("/" + uid));
	}

	@Test
	public void testExtractPathWithSiteStoreFolderSlashEndedUrl() {
		String uid = "test";
		PageRefFolder pageRefFolder = build(pageRefFolderWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(pageRefFolder, uid + "/");
		assertThat(extractedPath, is("/" + uid));
	}

	@Test
	public void testExtractPathWithSiteStoreFolderHttpsUrl() {
		String uid = "test";
		PageRefFolder pageRefFolder = build(pageRefFolderWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(pageRefFolder, "https://" + uid);
		assertThat(extractedPath, is("https://" + uid));
	}

	@Test
	public void testExtractPathWithSiteStoreHttpUrl() {
		String uid = "test";
		PageRefFolder pageRefFolder = build(pageRefFolderWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(pageRefFolder, "http://" + uid);
		assertThat(extractedPath, is("http://" + uid));
	}

	@Test
	public void testExtractPathWithSiteStoreEmptyUrl() {
		String uid = "test";
		PageRefFolder pageRefFolder = build(pageRefFolderWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(pageRefFolder, "");
		assertThat(extractedPath, is("/"));
	}

	@Test
	public void testExtractPathWithSiteStoreSlashStartedUrl() {
		String uid = "test";
		PageRefFolder pageRefFolder = build(pageRefFolderWith(uid, 2, null));
		String extractedPath = DefaultPathLookupBuilder.extractPath(pageRefFolder, "/" + uid);
		assertThat(extractedPath, is("/" + uid));
	}

	@Test
	public void testExtractPathWithSiteStoreRootHttpsUrl() {
		String uid = "test";
		SiteStoreRoot siteStoreRoot = build(siteStoreRootWith(1, projectWith("test", 0, languageWith("DE"))));
		String extractedPath = DefaultPathLookupBuilder.extractPath(siteStoreRoot, "https://" + uid);
		assertThat(extractedPath, is(""));
	}

	@Test
	public void testExtractPathWitSiteStoreRootHttpUrl() {
		SiteStoreRoot siteStoreRoot = build(siteStoreRootWith(1, projectWith("test", 0, languageWith("DE"))));
		String extractedPath = DefaultPathLookupBuilder.extractPath(siteStoreRoot, "http://test");
		assertThat(extractedPath, is(""));
	}

	@Test
	public void testExtractPathWithSiteStoreRootEmptyUrl() {
		SiteStoreRoot siteStoreRoot = build(siteStoreRootWith(1, projectWith("test", 0, languageWith("DE"))));
		String extractedPath = DefaultPathLookupBuilder.extractPath(siteStoreRoot, "");
		assertThat(extractedPath, is(""));
	}

	@Test
	public void testExtractPathWithSiteStoreRootSlashStartedUrl() {
		SiteStoreRoot siteStoreRoot = build(siteStoreRootWith(1, projectWith("test", 0, languageWith("DE"))));
		String extractedPath = DefaultPathLookupBuilder.extractPath(siteStoreRoot, "/test");
		assertThat(extractedPath, is(""));
	}
}
