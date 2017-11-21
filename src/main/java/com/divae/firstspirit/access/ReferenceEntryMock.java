package com.divae.firstspirit.access;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.contentstore.Content2Mock.Content2Builder;
import com.divae.firstspirit.access.store.contentstore.ContentFolderMock.ContentFolderBuilder;
import com.divae.firstspirit.access.store.contentstore.ContentStoreRootMock.ContentStoreRootBuilder;
import com.divae.firstspirit.access.store.contentstore.DatasetMock.DatasetBuilder;
import com.divae.firstspirit.access.store.globalstore.GCABodyMock.GCABodyBuilder;
import com.divae.firstspirit.access.store.globalstore.GCAFolderMock.GCAFolderBuilder;
import com.divae.firstspirit.access.store.globalstore.GCAPageMock.GCAPageBuilder;
import com.divae.firstspirit.access.store.globalstore.GCASectionMock.GCASectionBuilder;
import com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.GlobalStoreRootBuilder;
import com.divae.firstspirit.access.store.globalstore.ProjectPropertiesMock.ProjectPropertiesBuilder;
import com.divae.firstspirit.access.store.globalstore.URLPropertiesMock.URLPropertiesBuilder;
import com.divae.firstspirit.access.store.globalstore.UserPropertiesMock.UserPropertiesBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaFolderMock.MediaFolderBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaMock.MediaBuilder;
import com.divae.firstspirit.access.store.pagestore.BodyMock.BodyBuilder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.DataProviderBuilder;
import com.divae.firstspirit.access.store.pagestore.PageFolderMock.PageFolderBuilder;
import com.divae.firstspirit.access.store.pagestore.PageMock.PageBuilder;
import com.divae.firstspirit.access.store.pagestore.SectionMock.SectionBuilder;
import com.divae.firstspirit.access.store.sitestore.DocumentGroupMock.DocumentGroupBuilder;
import com.divae.firstspirit.access.store.sitestore.StartNodeMock.StartNodeBuilder;
import com.divae.firstspirit.access.store.templatestore.ChannelSourceProviderMock.ChannelSourceProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.FormatTemplateContainerMock.FormatTemplateContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.GomSourceProviderMock.GomSourceProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.PreviewImageProviderMock.PreviewImageProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.SchemaContainerMock.SchemaContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.ScriptContainerMock.ScriptContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateContainerMock.TemplateContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateProviderMock.TemplateProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreElementMock.TemplateStoreElementBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.TemplateStoreRootBuilder;
import com.divae.firstspirit.access.store.templatestore.WorkflowContainerMock.WorkflowContainerBuilder;
import de.espirit.firstspirit.access.ReferenceEntry;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.Store.Type;
import de.espirit.firstspirit.access.store.contentstore.ContentFolder;
import de.espirit.firstspirit.access.store.mediastore.MediaFolder;
import de.espirit.firstspirit.access.store.pagestore.Body;
import de.espirit.firstspirit.access.store.pagestore.DataProvider;
import de.espirit.firstspirit.access.store.pagestore.Page;
import de.espirit.firstspirit.access.store.pagestore.PageFolder;
import de.espirit.firstspirit.access.store.pagestore.Section;
import de.espirit.firstspirit.access.store.sitestore.StartNode;
import de.espirit.firstspirit.access.store.templatestore.ChannelSourceProvider;
import de.espirit.firstspirit.access.store.templatestore.GomSourceProvider;
import de.espirit.firstspirit.access.store.templatestore.PreviewImageProvider;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;
import de.espirit.firstspirit.access.store.templatestore.Template;
import de.espirit.firstspirit.access.store.templatestore.TemplateContainer;
import de.espirit.firstspirit.access.store.templatestore.TemplateProvider;
import de.espirit.firstspirit.access.store.templatestore.TemplateStoreElement;

import java.util.function.Supplier;

import static de.espirit.firstspirit.access.ReferenceEntry.CONTENT_REFERENCE;
import static de.espirit.firstspirit.access.ReferenceEntry.CONTENT_STORE_REFERENCE;
import static de.espirit.firstspirit.access.ReferenceEntry.GLOBAL_STORE_REFERENCE;
import static de.espirit.firstspirit.access.ReferenceEntry.MEDIA_STORE_REFERENCE;
import static de.espirit.firstspirit.access.ReferenceEntry.PAGE_STORE_REFERENCE;
import static de.espirit.firstspirit.access.ReferenceEntry.SITE_STORE_REFERENCE;
import static de.espirit.firstspirit.access.ReferenceEntry.TEMPLATE_STORE_REFERENCE;
import static java.util.stream.Stream.of;
import static org.mockito.Mockito.when;

public final class ReferenceEntryMock {

    private ReferenceEntryMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static ReferenceEntryBuilder referenceEntryWith(long id) {
        return new DefaultReferenceEntryBuilder(id);
    }

    public interface ReferenceEntryBuilder extends Builder<ReferenceEntry, ReferenceEntryBuilder> {
        <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER idProvider, int type);

        ReferenceEntryBuilder usages(Supplier<ReferenceEntryBuilder[]> supplier);

        ReferenceEntryBuilder aReferencedElement(DocumentGroupBuilder documentGroup);

        <T extends StartNode, TBUILDER extends StartNodeBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER startNode);

        ReferenceEntryBuilder aReferencedElement(Content2Builder content2);

        <T extends ContentFolder, TBUILDER extends ContentFolderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER contentFolder);

        ReferenceEntryBuilder aReferencedElement(ContentStoreRootBuilder contentFolder);

        ReferenceEntryBuilder aReferencedElement(DatasetBuilder dataset);

        ReferenceEntryBuilder aReferencedElement(GlobalStoreRootBuilder globalStoreRoot);

        ReferenceEntryBuilder aReferencedElement(UserPropertiesBuilder userProperties);

        ReferenceEntryBuilder aReferencedElement(ProjectPropertiesBuilder projectProperties);

        ReferenceEntryBuilder aReferencedElement(URLPropertiesBuilder urlProperties);

        ReferenceEntryBuilder aReferencedElement(MediaBuilder media);

        <T extends MediaFolder, TBUILDER extends MediaFolderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER mediaFolder);

        <T extends Body, TBUILDER extends BodyBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER body);

        <T extends DataProvider, TBUILDER extends DataProviderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER dataProvider);

        ReferenceEntryBuilder aReferencedElement(GCABodyBuilder gcaBody);

        ReferenceEntryBuilder aReferencedElement(GCAFolderBuilder gcaFolder);

        ReferenceEntryBuilder aReferencedElement(GCAPageBuilder gcaPage);

        <T extends Page, TBUILDER extends PageBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER page);

        <ST extends SectionTemplate, T extends Section<ST>, TBUILDER extends SectionBuilder<ST, T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER section);

        ReferenceEntryBuilder aReferencedElement(GCASectionBuilder gcaSection);

        <T extends PageFolder, TBUILDER extends PageFolderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER pageFolder);

        <T extends ChannelSourceProvider, TBUILDER extends ChannelSourceProviderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER channelSourceProvider);

        ReferenceEntryBuilder aReferencedElement(FormatTemplateContainerBuilder formatTemplateContainer);

        <T extends GomSourceProvider, TBUILDER extends GomSourceProviderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER gomSourceProvider);

        <T extends PreviewImageProvider, TBUILDER extends PreviewImageProviderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER previewImageProvider);

        ReferenceEntryBuilder aReferencedElement(SchemaContainerBuilder schemaContainer);

        ReferenceEntryBuilder aReferencedElement(ScriptContainerBuilder scriptContainer);

        <T extends Template, TC extends TemplateContainer<T>, TBUILDER extends TemplateContainerBuilder<T, TC, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER templateContainer);

        <T extends Template, TP extends TemplateProvider<T>, TBUILDER extends TemplateProviderBuilder<T, TP, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER templateProvider);

        <T extends TemplateStoreElement, TBUILDER extends TemplateStoreElementBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER templateStoreElement);

        ReferenceEntryBuilder aReferencedElement(TemplateStoreRootBuilder templateStoreRoot);

        ReferenceEntryBuilder aReferencedElement(WorkflowContainerBuilder workflowContainer);
    }

    public static final class DefaultReferenceEntryBuilder extends DefaultBuilder<ReferenceEntry, ReferenceEntryBuilder, DefaultReferenceEntryBuilder> implements ReferenceEntryBuilder {

        private DefaultReferenceEntryBuilder(long id) {
            super(id);
            anId(id);
            usages(() -> new ReferenceEntryBuilder[]{});
        }

        private void anId(long id) {
            when(getBuildable().getId()).thenReturn(id);
        }

        @Override
        public final <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER idProvider, int type) {
            T buildable = getBuildable(idProvider);
            when(getBuildable().getReferencedElement()).thenReturn(buildable);
            withStoreType(buildable.getStore().getType());
            withType(type);
            return getBuilder();
        }

        @Override
        public final ReferenceEntryBuilder usages(Supplier<ReferenceEntryBuilder[]> supplier) {
            ReferenceEntry[] referenceEntries = of(supplier.get()).map(BuilderMock::build).toArray(ReferenceEntry[]::new);
            when(getBuildable().getUsages()).thenReturn(referenceEntries);
            return getBuilder();
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(DocumentGroupBuilder documentGroup) {
            return aReferencedElement(documentGroup, SITE_STORE_REFERENCE);
        }

        @Override
        public final <T extends StartNode, TBUILDER extends StartNodeBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER startNode) {
            return aReferencedElement(startNode, SITE_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(Content2Builder content2) {
            return aReferencedElement(content2, CONTENT_STORE_REFERENCE);
        }

        @Override
        public final <T extends ContentFolder, TBUILDER extends ContentFolderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER contentFolder) {
            return aReferencedElement(contentFolder, CONTENT_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(ContentStoreRootBuilder contentFolder) {
            return aReferencedElement(contentFolder, CONTENT_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(DatasetBuilder dataset) {
            return aReferencedElement(dataset, CONTENT_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(GlobalStoreRootBuilder globalStoreRoot) {
            return aReferencedElement(globalStoreRoot, GLOBAL_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(UserPropertiesBuilder userProperties) {
            return aReferencedElement(userProperties, GLOBAL_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(ProjectPropertiesBuilder projectProperties) {
            return aReferencedElement(projectProperties, GLOBAL_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(URLPropertiesBuilder urlProperties) {
            return aReferencedElement(urlProperties, GLOBAL_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(MediaBuilder media) {
            return aReferencedElement(media, MEDIA_STORE_REFERENCE);
        }

        @Override
        public final <T extends MediaFolder, TBUILDER extends MediaFolderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER mediaFolder) {
            return aReferencedElement(mediaFolder, MEDIA_STORE_REFERENCE);
        }

        @Override
        public final <T extends Body, TBUILDER extends BodyBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER body) {
            return aReferencedElement(body, PAGE_STORE_REFERENCE);
        }

        @Override
        public final <T extends DataProvider, TBUILDER extends DataProviderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER dataProvider) {
            return aReferencedElement(dataProvider, PAGE_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(GCABodyBuilder gcaBody) {
            return aReferencedElement(gcaBody, GLOBAL_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(GCAFolderBuilder gcaFolder) {
            return aReferencedElement(gcaFolder, GLOBAL_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(GCAPageBuilder gcaPage) {
            return aReferencedElement(gcaPage, GLOBAL_STORE_REFERENCE);
        }

        @Override
        public final <T extends Page, TBUILDER extends PageBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER page) {
            return aReferencedElement(page, PAGE_STORE_REFERENCE);
        }

        @Override
        public final <ST extends SectionTemplate, T extends Section<ST>, TBUILDER extends SectionBuilder<ST, T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER section) {
            return aReferencedElement(section, PAGE_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(GCASectionBuilder gcaSection) {
            return aReferencedElement(gcaSection, GLOBAL_STORE_REFERENCE);
        }

        @Override
        public final <T extends PageFolder, TBUILDER extends PageFolderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER pageFolder) {
            return aReferencedElement(pageFolder, PAGE_STORE_REFERENCE);
        }

        @Override
        public final <T extends ChannelSourceProvider, TBUILDER extends ChannelSourceProviderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER channelSourceProvider) {
            return aReferencedElement(channelSourceProvider, TEMPLATE_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(FormatTemplateContainerBuilder formatTemplateContainer) {
            return aReferencedElement(formatTemplateContainer, TEMPLATE_STORE_REFERENCE);
        }

        @Override
        public final <T extends GomSourceProvider, TBUILDER extends GomSourceProviderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER gomSourceProvider) {
            return aReferencedElement(gomSourceProvider, TEMPLATE_STORE_REFERENCE);
        }

        @Override
        public final <T extends PreviewImageProvider, TBUILDER extends PreviewImageProviderBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER previewImageProvider) {
            return aReferencedElement(previewImageProvider, TEMPLATE_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(SchemaContainerBuilder schemaContainer) {
            return aReferencedElement(schemaContainer, TEMPLATE_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(ScriptContainerBuilder scriptContainer) {
            return aReferencedElement(scriptContainer, TEMPLATE_STORE_REFERENCE);
        }

        @Override
        public final <T extends Template, TC extends TemplateContainer<T>, TBUILDER extends TemplateContainerBuilder<T, TC, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER templateContainer) {
            return aReferencedElement(templateContainer, TEMPLATE_STORE_REFERENCE);
        }

        @Override
        public final <T extends Template, TP extends TemplateProvider<T>, TBUILDER extends TemplateProviderBuilder<T, TP, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER templateProvider) {
            return aReferencedElement(templateProvider, TEMPLATE_STORE_REFERENCE);
        }

        @Override
        public final <T extends TemplateStoreElement, TBUILDER extends TemplateStoreElementBuilder<T, TBUILDER>> ReferenceEntryBuilder aReferencedElement(TBUILDER templateStoreElement) {
            return aReferencedElement(templateStoreElement, TEMPLATE_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(TemplateStoreRootBuilder templateStoreRoot) {
            return aReferencedElement(templateStoreRoot, TEMPLATE_STORE_REFERENCE);
        }

        @Override
        public final ReferenceEntryBuilder aReferencedElement(WorkflowContainerBuilder workflowContainer) {
            return aReferencedElement(workflowContainer, TEMPLATE_STORE_REFERENCE);
        }

        private void withStoreType(Type type) {
            when(getBuildable().getStoreType()).thenReturn(type);
        }

        private void withType(int type) {
            when(getBuildable().getType()).thenReturn(type);
        }
    }
}
