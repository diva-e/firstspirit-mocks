package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.ReferenceEntryMock.ReferenceEntryBuilder;
import com.divae.firstspirit.access.store.contentstore.Content2Mock.Content2Builder;
import com.divae.firstspirit.access.store.contentstore.ContentFolderMock.TruncatedContentFolderBuilder;
import com.divae.firstspirit.access.store.globalstore.GCABodyMock.GCABodyBuilder;
import com.divae.firstspirit.access.store.globalstore.GCAFolderMock.GCAFolderBuilder;
import com.divae.firstspirit.access.store.globalstore.GCAPageMock.GCAPageBuilder;
import com.divae.firstspirit.access.store.globalstore.GCASectionMock.GCASectionBuilder;
import com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.GlobalStoreRootBuilder;
import com.divae.firstspirit.access.store.globalstore.ProjectPropertiesMock.ProjectPropertiesBuilder;
import com.divae.firstspirit.access.store.globalstore.URLPropertiesMock.URLPropertiesBuilder;
import com.divae.firstspirit.access.store.globalstore.UserPropertiesMock.UserPropertiesBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaFolderMock.TruncatedMediaFolderBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaMock.MediaBuilder;
import com.divae.firstspirit.access.store.pagestore.BodyMock.TruncatedBodyBuilder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.TruncatedDataProviderBuilder;
import com.divae.firstspirit.access.store.pagestore.PageFolderMock.TruncatedPageFolderBuilder;
import com.divae.firstspirit.access.store.pagestore.PageMock.TruncatedPageBuilder;
import com.divae.firstspirit.access.store.pagestore.SectionMock.TruncatedSectionBuilder;
import com.divae.firstspirit.access.store.sitestore.DocumentGroupMock.DocumentGroupBuilder;
import com.divae.firstspirit.access.store.sitestore.StartNodeMock.TruncatedStartNodeBuilder;
import com.divae.firstspirit.access.store.templatestore.ChannelSourceProviderMock.TruncatedChannelSourceProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.FormatTemplateContainerMock.FormatTemplateContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.GomSourceProviderMock.TruncatedGomSourceProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.PreviewImageProviderMock.TruncatedPreviewImageProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.SchemaContainerMock.SchemaContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.ScriptContainerMock.ScriptContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateContainerMock.TruncatedTemplateContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateProviderMock.TruncatedTemplateProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreElementMock.TruncatedTemplateStoreElementBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.TemplateStoreRootBuilder;
import com.divae.firstspirit.access.store.templatestore.WorkflowContainerMock.WorkflowContainerBuilder;
import de.espirit.firstspirit.access.ReferenceEntry;
import de.espirit.firstspirit.access.store.Store.Type;
import de.espirit.firstspirit.access.store.contentstore.Content2;
import de.espirit.firstspirit.access.store.contentstore.ContentFolder;
import de.espirit.firstspirit.access.store.globalstore.GCABody;
import de.espirit.firstspirit.access.store.globalstore.GCAFolder;
import de.espirit.firstspirit.access.store.globalstore.GCAPage;
import de.espirit.firstspirit.access.store.globalstore.GCASection;
import de.espirit.firstspirit.access.store.globalstore.GlobalStoreRoot;
import de.espirit.firstspirit.access.store.globalstore.ProjectProperties;
import de.espirit.firstspirit.access.store.globalstore.URLProperties;
import de.espirit.firstspirit.access.store.globalstore.UserProperties;
import de.espirit.firstspirit.access.store.mediastore.Media;
import de.espirit.firstspirit.access.store.mediastore.MediaFolder;
import de.espirit.firstspirit.access.store.pagestore.Body;
import de.espirit.firstspirit.access.store.pagestore.DataProvider;
import de.espirit.firstspirit.access.store.pagestore.Page;
import de.espirit.firstspirit.access.store.pagestore.PageFolder;
import de.espirit.firstspirit.access.store.pagestore.Section;
import de.espirit.firstspirit.access.store.sitestore.DocumentGroup;
import de.espirit.firstspirit.access.store.sitestore.StartNode;
import de.espirit.firstspirit.access.store.templatestore.ChannelSourceProvider;
import de.espirit.firstspirit.access.store.templatestore.FormatTemplateContainer;
import de.espirit.firstspirit.access.store.templatestore.GomSourceProvider;
import de.espirit.firstspirit.access.store.templatestore.PreviewImageProvider;
import de.espirit.firstspirit.access.store.templatestore.SchemaContainer;
import de.espirit.firstspirit.access.store.templatestore.ScriptContainer;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;
import de.espirit.firstspirit.access.store.templatestore.Template;
import de.espirit.firstspirit.access.store.templatestore.TemplateContainer;
import de.espirit.firstspirit.access.store.templatestore.TemplateProvider;
import de.espirit.firstspirit.access.store.templatestore.TemplateStoreElement;
import de.espirit.firstspirit.access.store.templatestore.TemplateStoreRoot;
import de.espirit.firstspirit.access.store.templatestore.WorkflowContainer;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.ReferenceEntryMock.referenceEntryWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.contentstore.Content2Mock.content2With;
import static com.divae.firstspirit.access.store.contentstore.ContentFolderMock.contentFolderWith;
import static com.divae.firstspirit.access.store.contentstore.ContentStoreRootMock.contentStoreRootWith;
import static com.divae.firstspirit.access.store.contentstore.DatasetMock.datasetWith;
import static com.divae.firstspirit.access.store.globalstore.GCABodyMock.gcaBodyWith;
import static com.divae.firstspirit.access.store.globalstore.GCAFolderMock.gcaFolderWith;
import static com.divae.firstspirit.access.store.globalstore.GCAPageMock.gcaPageWith;
import static com.divae.firstspirit.access.store.globalstore.GCASectionMock.gcaSectionWith;
import static com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.globalStoreRootWith;
import static com.divae.firstspirit.access.store.globalstore.ProjectPropertiesMock.projectPropertiesWith;
import static com.divae.firstspirit.access.store.globalstore.URLPropertiesMock.urlPropertiesWith;
import static com.divae.firstspirit.access.store.globalstore.UserPropertiesMock.userPropertiesWith;
import static com.divae.firstspirit.access.store.mediastore.MediaFolderMock.mediaFolderWith;
import static com.divae.firstspirit.access.store.mediastore.MediaMock.mediaWith;
import static com.divae.firstspirit.access.store.mediastore.MediaStoreRootMock.mediaStoreRootWith;
import static com.divae.firstspirit.access.store.pagestore.BodyMock.bodyWith;
import static com.divae.firstspirit.access.store.pagestore.DataProviderMock.dataProviderWith;
import static com.divae.firstspirit.access.store.pagestore.PageFolderMock.pageFolderWith;
import static com.divae.firstspirit.access.store.pagestore.PageMock.pageWith;
import static com.divae.firstspirit.access.store.pagestore.PageStoreRootMock.pageStoreRootWith;
import static com.divae.firstspirit.access.store.pagestore.SectionMock.sectionWith;
import static com.divae.firstspirit.access.store.sitestore.DocumentGroupMock.documentGroupWith;
import static com.divae.firstspirit.access.store.sitestore.SiteStoreRootMock.siteStoreRootWith;
import static com.divae.firstspirit.access.store.sitestore.StartNodeMock.startNodeWith;
import static com.divae.firstspirit.access.store.templatestore.ChannelSourceProviderMock.channelSourceProviderWith;
import static com.divae.firstspirit.access.store.templatestore.FormatTemplateContainerMock.formatTemplateContainerWith;
import static com.divae.firstspirit.access.store.templatestore.GomSourceProviderMock.gomSourceProviderWith;
import static com.divae.firstspirit.access.store.templatestore.PreviewImageProviderMock.previewImageProviderWith;
import static com.divae.firstspirit.access.store.templatestore.SchemaContainerMock.schemaContainerWith;
import static com.divae.firstspirit.access.store.templatestore.ScriptContainerMock.scriptContainerWith;
import static com.divae.firstspirit.access.store.templatestore.TemplateContainerMock.templateContainerWith;
import static com.divae.firstspirit.access.store.templatestore.TemplateProviderMock.templateProviderWith;
import static com.divae.firstspirit.access.store.templatestore.TemplateStoreElementMock.templateStoreElementWith;
import static com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.templateStoreRootWith;
import static com.divae.firstspirit.access.store.templatestore.WorkflowContainerMock.workflowContainerWith;
import static de.espirit.firstspirit.access.ReferenceEntry.CONTENT_STORE_REFERENCE;
import static de.espirit.firstspirit.access.ReferenceEntry.GLOBAL_STORE_REFERENCE;
import static de.espirit.firstspirit.access.ReferenceEntry.MEDIA_STORE_REFERENCE;
import static de.espirit.firstspirit.access.ReferenceEntry.PAGE_STORE_REFERENCE;
import static de.espirit.firstspirit.access.ReferenceEntry.SITE_STORE_REFERENCE;
import static de.espirit.firstspirit.access.ReferenceEntry.TEMPLATE_STORE_REFERENCE;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.SITESTORE_LEAF;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static de.espirit.firstspirit.access.store.Store.Type.GLOBALSTORE;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReferenceEntryMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return ReferenceEntryMock.class;
    }

    @Test
    public void testDefault() {
        assertThat(build(referenceEntryWith(0L)).getUsages(), is(new ReferenceEntry[]{}));
    }

    @Test
    public void testUsages() {
        ReferenceEntry[] usages = build(referenceEntryWith(0L).usages(() -> new ReferenceEntryBuilder[]{referenceEntryWith(0L)})).getUsages();
        assertThat(usages.length, is(1));
        assertThat(usages[0].getId(), is(0L));
    }

    @Test
    public void testAReferencedElementDocumentGroup() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        DocumentGroup documentGroup = (DocumentGroup) build(siteStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            DocumentGroupBuilder documentGroupBuilder = documentGroupWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(documentGroupBuilder);
            return singletonList(documentGroupBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(documentGroup));
        assertThat(referenceEntry.getType(), is(SITE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.SITESTORE));
    }

    @Test
    public void testAReferencedElementStartNode() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        StartNode startNode = (StartNode) build(siteStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedStartNodeBuilder<StartNode> startNodeBuilder = startNodeWith("test", 2, SITESTORE_LEAF, parent);
            referenceEntryBuilder.aReferencedElement(startNodeBuilder);
            return singletonList(startNodeBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(startNode));
        assertThat(referenceEntry.getType(), is(SITE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.SITESTORE));
    }

    @Test
    public void testAReferencedElementContent2() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        Content2 content2 = (Content2) build(contentStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            Content2Builder content2Builder = content2With("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(content2Builder);
            return singletonList(content2Builder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(content2));
        assertThat(referenceEntry.getType(), is(CONTENT_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.CONTENTSTORE));
    }

    @Test
    public void testAReferencedElementContentFolder() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        ContentFolder contentFolder = (ContentFolder) build(contentStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedContentFolderBuilder<ContentFolder> contentFolderBuilder = contentFolderWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(contentFolderBuilder);
            return singletonList(contentFolderBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(contentFolder));
        assertThat(referenceEntry.getType(), is(CONTENT_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.CONTENTSTORE));
    }

    @Test
    public void testAReferencedElementDataset() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(4L);
        build(contentStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            Content2Builder content2Builder = content2With("content2", 2, parent).datasets(content2Parent -> singletonList(datasetWith("test", 3, content2Parent)));
            referenceEntryBuilder.aReferencedElement(content2Builder);
            return singletonList(content2Builder);
        }));
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement().getId(), is(2L));
        assertThat(referenceEntry.getType(), is(CONTENT_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.CONTENTSTORE));
    }

    @Test
    public void testAReferencedElementGCABody() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        GCAPage gcaPage = (GCAPage) build(globalStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> singletonList(gcaPageWith("gcaPage", 3, parent).children(gcaPageParent -> {
            GCABodyBuilder gcaBodyBuilder = gcaBodyWith("gcaBody", 4, gcaPageParent);
            referenceEntryBuilder.aReferencedElement(gcaBodyBuilder);
            return singletonList(gcaBodyBuilder);
        })))).getStore().getChildren().iterator().next();
        GCABody gcaBody = (GCABody) gcaPage.getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(gcaBody));
        assertThat(referenceEntry.getType(), is(GLOBAL_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.GLOBALSTORE));
    }

    @Test
    public void testAReferencedElementGCAFolder() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        GCAFolder gcaFolder = (GCAFolder) build(globalStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            GCAFolderBuilder gcaFolderBuilder = gcaFolderWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(gcaFolderBuilder);
            return singletonList(gcaFolderBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(gcaFolder));
        assertThat(referenceEntry.getType(), is(GLOBAL_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.GLOBALSTORE));
    }

    @Test
    public void testAReferencedElementGCAPage() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        GCAPage gcaPage = (GCAPage) build(globalStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            GCAPageBuilder gcaPageBuilder = gcaPageWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(gcaPageBuilder);
            return singletonList(gcaPageBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(gcaPage));
        assertThat(referenceEntry.getType(), is(GLOBAL_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.GLOBALSTORE));
    }

    @Test
    public void testAReferencedElementGCASection() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(5L);
        GCAPage cgaPage = (GCAPage) build(globalStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> singletonList(gcaPageWith("gcaPage", 2, parent).children(gcaPageParent -> singletonList(gcaBodyWith("gcaBody", 3, gcaPageParent).children(gcaBodyParent -> {
            GCASectionBuilder gcaSectionBuilder = gcaSectionWith("gcaSection", 4, gcaBodyParent);
            referenceEntryBuilder.aReferencedElement(gcaSectionBuilder);
            return singletonList(gcaSectionBuilder);
        })))))).getStore().getChildren().iterator().next();
        GCASection gcaSection = (GCASection) cgaPage.getChildren().iterator().next().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(gcaSection));
        assertThat(referenceEntry.getType(), is(GLOBAL_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.GLOBALSTORE));
    }

    @Test
    public void testAReferencedElementGlobalStoreRoot() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        GlobalStoreRootBuilder globalStoreRootBuilder = globalStoreRootWith(2, projectWith("project", 0, languageWith("DE")));
        referenceEntryBuilder.aReferencedElement(globalStoreRootBuilder);
        GlobalStoreRoot globalStoreRoot = build(globalStoreRootBuilder);
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(globalStoreRoot));
        assertThat(referenceEntry.getType(), is(GLOBAL_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.GLOBALSTORE));
    }

    @Test
    public void testAReferencedElementProjectProperties() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        ProjectProperties projectProperties = (ProjectProperties) build(globalStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            ProjectPropertiesBuilder projectPropertiesBuilder = projectPropertiesWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(projectPropertiesBuilder);
            return singletonList(projectPropertiesBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(projectProperties));
        assertThat(referenceEntry.getType(), is(GLOBAL_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.GLOBALSTORE));
    }

    @Test
    public void testAReferencedElementURLProperties() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        URLProperties urlProperties = (URLProperties) build(globalStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            URLPropertiesBuilder urlPropertiesBuilder = urlPropertiesWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(urlPropertiesBuilder);
            return singletonList(urlPropertiesBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(urlProperties));
        assertThat(referenceEntry.getType(), is(GLOBAL_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.GLOBALSTORE));
    }

    @Test
    public void testAReferencedElementMedia() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        Media media = (Media) build(mediaStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            MediaBuilder mediaBuilder = mediaWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(mediaBuilder);
            return singletonList(mediaBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(media));
        assertThat(referenceEntry.getType(), is(MEDIA_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.MEDIASTORE));
    }

    @Test
    public void testAReferencedElementMediaFolder() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        MediaFolder mediaFolder = (MediaFolder) build(mediaStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedMediaFolderBuilder<MediaFolder> mediaFolderBuilder = mediaFolderWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(mediaFolderBuilder);
            return singletonList(mediaFolderBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(mediaFolder));
        assertThat(referenceEntry.getType(), is(MEDIA_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.MEDIASTORE));
    }

    @Test
    public void testAReferencedElementBody() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        Page page = (Page) build(pageStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> singletonList(pageWith("test", 2, parent).children(pageParent -> {
            TruncatedBodyBuilder<Body> bodyBuilder = bodyWith("body", 3, pageParent);
            referenceEntryBuilder.aReferencedElement(bodyBuilder);
            return singletonList(bodyBuilder);
        })))).getStore().getChildren().iterator().next();
        Body body = (Body) page.getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(body));
        assertThat(referenceEntry.getType(), is(PAGE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.PAGESTORE));
    }

    @Test
    public void testAReferencedElementSection() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        Page page = (Page) build(pageStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> singletonList(pageWith("page", 2, parent).children(pageParent -> singletonList(bodyWith("body", 3, pageParent).children(bodyParent -> {
            TruncatedSectionBuilder<SectionTemplate, Section<SectionTemplate>> sectionBuilder = sectionWith("section", 4, bodyParent);
            referenceEntryBuilder.aReferencedElement(sectionBuilder);
            return singletonList(sectionBuilder);
        })))))).getStore().getChildren().iterator().next();
        @SuppressWarnings("unchecked") Section<SectionTemplate> section = (Section<SectionTemplate>) page.getChildren().iterator().next().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(section));
        assertThat(referenceEntry.getType(), is(PAGE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.PAGESTORE));
    }

    @Test
    public void testAReferencedElementPage() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        Page page = (Page) build(pageStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedPageBuilder<Page> pageBuilder = pageWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(pageBuilder);
            return singletonList(pageBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(page));
        assertThat(referenceEntry.getType(), is(PAGE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.PAGESTORE));
    }

    @Test
    public void testAReferencedElementPageFolder() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        PageFolder pageFolder = (PageFolder) build(pageStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedPageFolderBuilder<PageFolder> pageFolderBuilder = pageFolderWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(pageFolderBuilder);
            return singletonList(pageFolderBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(pageFolder));
        assertThat(referenceEntry.getType(), is(PAGE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.PAGESTORE));
    }

    @Test
    public void testAReferencedElementChannelSourceProvider() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        ChannelSourceProvider channelSourceProvider = (ChannelSourceProvider) build(templateStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedChannelSourceProviderBuilder<ChannelSourceProvider> sourceProviderBuilder = channelSourceProviderWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(sourceProviderBuilder);
            return singletonList(sourceProviderBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(channelSourceProvider));
        assertThat(referenceEntry.getType(), is(TEMPLATE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.TEMPLATESTORE));
    }

    @Test
    public void testAReferencedElementFormatTemplateContainer() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        FormatTemplateContainer formatTemplateContainer = (FormatTemplateContainer) build(templateStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            FormatTemplateContainerBuilder formatTemplateContainerBuilder = formatTemplateContainerWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(formatTemplateContainerBuilder);
            return singletonList(formatTemplateContainerBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(formatTemplateContainer));
        assertThat(referenceEntry.getType(), is(TEMPLATE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.TEMPLATESTORE));
    }

    @Test
    public void testAReferencedElementUserProperties() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        UserProperties userProperties = (UserProperties) build(globalStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            UserPropertiesBuilder userPropertiesBuilder = userPropertiesWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(userPropertiesBuilder);
            return singletonList(userPropertiesBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(userProperties));
        assertThat(referenceEntry.getType(), is(GLOBAL_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(GLOBALSTORE));
    }

    @Test
    public void testAReferencedElementPreviewImageProvider() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        PreviewImageProvider previewImageProvider = (PreviewImageProvider) build(templateStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedPreviewImageProviderBuilder<PreviewImageProvider> imageProviderBuilder = previewImageProviderWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(imageProviderBuilder);
            return singletonList(imageProviderBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(previewImageProvider));
        assertThat(referenceEntry.getType(), is(TEMPLATE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.TEMPLATESTORE));
    }

    @Test
    public void testAReferencedElementGomSourceProvider() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        GomSourceProvider gomSourceProvider = (GomSourceProvider) build(templateStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedGomSourceProviderBuilder<GomSourceProvider> sourceProviderBuilder = gomSourceProviderWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(sourceProviderBuilder);
            return singletonList(sourceProviderBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(gomSourceProvider));
        assertThat(referenceEntry.getType(), is(TEMPLATE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.TEMPLATESTORE));
    }

    @Test
    public void testAReferencedElementSchemaContainer() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        SchemaContainer schemaContainer = (SchemaContainer) build(templateStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            SchemaContainerBuilder schemaContainerBuilder = schemaContainerWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(schemaContainerBuilder);
            return singletonList(schemaContainerBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(schemaContainer));
        assertThat(referenceEntry.getType(), is(TEMPLATE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.TEMPLATESTORE));
    }

    @Test
    public void testAReferencedElementScriptContainer() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        ScriptContainer scriptContainer = (ScriptContainer) build(templateStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            ScriptContainerBuilder scriptContainerBuilder = scriptContainerWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(scriptContainerBuilder);
            return singletonList(scriptContainerBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(scriptContainer));
        assertThat(referenceEntry.getType(), is(TEMPLATE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.TEMPLATESTORE));
    }

    @Test
    public void testAReferencedElementTemplateContainer() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        @SuppressWarnings("unchecked") TemplateContainer<Template> templateContainer = (TemplateContainer<Template>) build(templateStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedTemplateContainerBuilder<Template, TemplateContainer<Template>> templateContainerBuilder = templateContainerWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(templateContainerBuilder);
            return singletonList(templateContainerBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(templateContainer));
        assertThat(referenceEntry.getType(), is(TEMPLATE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.TEMPLATESTORE));
    }

    @Test
    public void testAReferencedElementTemplateProvider() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        @SuppressWarnings("unchecked") TemplateProvider<Template> templateProvider = (TemplateProvider<Template>) build(templateStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedTemplateProviderBuilder<Template, TemplateProvider<Template>> templateProviderBuilder = templateProviderWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(templateProviderBuilder);
            return singletonList(templateProviderBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(templateProvider));
        assertThat(referenceEntry.getType(), is(TEMPLATE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.TEMPLATESTORE));
    }

    @Test
    public void testAReferencedElementTemplateStoreElement() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        TemplateStoreElement templateStoreElement = (TemplateStoreElement) build(templateStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedTemplateStoreElementBuilder<TemplateStoreElement> templateStoreElementBuilder = templateStoreElementWith("test", 2, TEMPLATESTORE, parent);
            referenceEntryBuilder.aReferencedElement(templateStoreElementBuilder);
            return singletonList(templateStoreElementBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(templateStoreElement));
        assertThat(referenceEntry.getType(), is(TEMPLATE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.TEMPLATESTORE));
    }

    @Test
    public void testAReferencedElementTemplateStoreRoot() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        TemplateStoreRootBuilder templateStoreRootBuilder = templateStoreRootWith(1, projectWith("project", 0, languageWith("DE")));
        referenceEntryBuilder.aReferencedElement(templateStoreRootBuilder);
        TemplateStoreRoot templateStoreRoot = build(templateStoreRootBuilder);
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(templateStoreRoot));
        assertThat(referenceEntry.getType(), is(TEMPLATE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.TEMPLATESTORE));
    }

    @Test
    public void testAReferencedElementWorkflowContainer() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        TemplateStoreRootBuilder templateStoreRootBuilder = templateStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            WorkflowContainerBuilder workflowContainerBuilder = workflowContainerWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(workflowContainerBuilder);
            return singletonList(workflowContainerBuilder);
        });
        WorkflowContainer workflowContainer = (WorkflowContainer) build(templateStoreRootBuilder).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(workflowContainer));
        assertThat(referenceEntry.getType(), is(TEMPLATE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.TEMPLATESTORE));
    }

    @Test
    public void testAReferencedElementDataProvider() {
        ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(3L);
        DataProvider dataProvider = (DataProvider) build(pageStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> {
            TruncatedDataProviderBuilder<DataProvider> providerBuilder = dataProviderWith("test", 2, parent);
            referenceEntryBuilder.aReferencedElement(providerBuilder);
            return singletonList(providerBuilder);
        })).getStore().getChildren().iterator().next();
        ReferenceEntry referenceEntry = build(referenceEntryBuilder);
        assertThat(referenceEntry.getReferencedElement(), is(dataProvider));
        assertThat(referenceEntry.getType(), is(PAGE_STORE_REFERENCE));
        assertThat(referenceEntry.getStoreType(), is(Type.PAGESTORE));
    }
}
