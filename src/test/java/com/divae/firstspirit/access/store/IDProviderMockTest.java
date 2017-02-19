package com.divae.firstspirit.access.store;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.forms.FormDataMock;
import de.espirit.firstspirit.access.project.Project;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.globalstore.GlobalStoreRoot;
import de.espirit.firstspirit.storage.Revision;
import org.junit.Test;

import java.util.List;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.IDProviderMock.idProviderWith;
import static com.divae.firstspirit.access.store.LanguageInfoMock.languageInfoWith;
import static com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.globalStoreRootWith;
import static com.divae.firstspirit.storage.RevisionMock.revisionWith;
import static de.espirit.firstspirit.access.store.IDProvider.CHANGED;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.GLOBALSTORE;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class IDProviderMockTest extends MockTest {

	@Test
	public void testIdProviderStringLongListLanguageInfo() {
		IDProviderBuilder idProviderBuilder = idProviderWith("test", 2, GLOBALSTORE, null);
		assertThat(idProviderBuilder, is(notNullValue()));
	}

	@Test
	public void testIdProviderT() {
		assertThat(idProviderWith(idProviderWith("test", 2, GLOBALSTORE, null)), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return IDProviderMock.class;
	}

	@Test
	public void testIdProviderStringLong() {
		String uid = "test";
		long id = 2;
		IDProvider idProvider = build(idProviderWith(uid, id, GLOBALSTORE, null));
		assertThat(idProvider.getId(), is(id));
		assertThat(idProvider.getUid(), is(uid));
	}

	@Test
	public void testIdProviderStringLongProject() {
		String uid = "test";
		long id = 1;
		ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
		IDProvider idProvider = build(idProviderWith(uid, id, GLOBALSTORE, null, projectBuilder));
		Project project = build(projectBuilder);
		assertThat(idProvider.getId(), is(id));
		assertThat(idProvider.getUid(), is(uid));
		assertThat(idProvider.getProject(), is(project));
	}

	@Test
	public void testAReleaseStatus() {
		String uid = "test";
		int releaseStatus = CHANGED;
		IDProvider idProvider = build(idProviderWith(uid, 2, GLOBALSTORE, null).aReleaseStatus(releaseStatus));
		assertThat(idProvider.getReleaseStatus(), is(releaseStatus));
	}


	@Test
	public void testLanguageInfo() {
		String uid = "test";
		LanguageBuilder language = languageWith("DE");
		ProjectBuilder projectBuilder = projectWith("test", 0, language);
		IDProvider idProvider = (IDProvider) build(globalStoreRootWith(1, projectBuilder).children(parent -> singletonList(idProviderWith(uid, 2, GLOBALSTORE, parent).languageInfo(idProviderParent -> languageInfoWith(language, idProviderParent))))).getStore().getChildren().iterator().next();
		Project project = build(projectBuilder);
		assertThat(idProvider.getLanguageInfo(project.getMasterLanguage()), is(notNullValue()));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testDefaultsWithBlankUid() {
		ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
		IDProvider idProvider = build(idProviderWith(null, 1, GLOBALSTORE, null, projectBuilder));
		Project project = build(projectBuilder);
		assertThat(idProvider.getProject(), is(project));
		assertThat(idProvider.hasUid(), is(FALSE));
		idProvider.getUid();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDefaultsWithNegativeId() {
		build(idProviderWith("idProvider", -1, GLOBALSTORE, null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDefaultsWithIdNotGreaterThenProjectId() {
		build(idProviderWith(null, 0, GLOBALSTORE, null, projectWith("test", 0, languageWith("DE"))));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDefaultsWithIdNotGreaterThenParentId() {
		ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
		build(idProviderWith("test2", 2, GLOBALSTORE, idProviderWith("test", 3, GLOBALSTORE, globalStoreRootWith(1, projectBuilder), projectBuilder), projectBuilder));
	}

	@Test
	public void testDefaultsWithProject() {
		String uid = "test";
		ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
		IDProvider idProvider = build(idProviderWith(uid, 1, GLOBALSTORE, null, projectBuilder));
		Project project = build(projectBuilder);
		assertThat(idProvider.getUid(), is(uid));
		assertThat(idProvider.getProject(), is(project));
		assertThat(idProvider.hasUid(), is(TRUE));

	}

	@Test
	public void testDefaults() {
		String uid = "test";
		LanguageBuilder languageBuilder = languageWith("DE");
		ProjectBuilder projectBuilder = projectWith("test", 0, languageBuilder);
		GlobalStoreRoot globalStoreRoot = build(globalStoreRootWith(1, projectBuilder).children(parent -> singletonList(idProviderWith(uid, 2, GLOBALSTORE, parent).languageInfo(idProviderParent -> languageInfoWith(languageBuilder, idProviderParent)))));
		Project project = build(projectBuilder);
		IDProvider idProvider = (IDProvider) globalStoreRoot.getChildren().iterator().next();
		assertThat(idProvider.getUid(), is(uid));
		assertThat(idProvider.getProject(), is(project));
		assertThat(idProvider.hasUid(), is(TRUE));
	}

	@Test
	public void testAMetaFormData() {
		IDProvider idProvider = build(idProviderWith("test", 1, GLOBALSTORE, null, projectWith("test", 0, languageWith("DE"))).aMetaFormData(FormDataMock::formDataWith));
		assertThat(idProvider.getMetaFormData(), is(notNullValue()));
	}

	@Test
	public void testWithDisplayNameLanguageString() {
		String displayName = "test";
		LanguageBuilder languageBuilder = languageWith("DE");
		ProjectBuilder projectBuilder = projectWith("test", 0, languageBuilder);
		IDProvider idProvider = (IDProvider) build(globalStoreRootWith(1, projectBuilder).children(parent -> singletonList(idProviderWith("test", 2, GLOBALSTORE, parent).languageInfo(idProviderParent -> languageInfoWith(languageBuilder, idProviderParent).aDisplayName(displayName))))).getStore().getChildren().iterator().next();
		Project project = build(projectBuilder);
		assertThat(idProvider.getDisplayName(project.getMasterLanguage()), is(displayName));
	}

	@Test
	public void testAHistory() {
		String uid = "test";
		IDProvider idProvider = build(idProviderWith(uid, 1, GLOBALSTORE, null, projectWith("test", 0, languageWith("DE"))).aHistory(() -> singletonList(revisionWith(1L))));
		List<Revision> revisions = idProvider.getHistory();
		assertThat(revisions.size(), is(1));
		assertThat(revisions.get(0).getId(), is(1L));
	}
}
