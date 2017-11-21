package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.ContentProducerMock.ContentProducerBuilder;
import com.divae.firstspirit.access.store.ContentProducerMock.DefaultContentProducerBuilder;
import com.divae.firstspirit.access.store.sitestore.SiteStoreFolderMock.SiteStoreFolderBuilder;
import de.espirit.firstspirit.access.store.sitestore.DocumentGroup;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreFolder;

import static de.espirit.firstspirit.access.store.ReferenceType.DOCUMENTGROUP;
import static de.espirit.firstspirit.access.store.sitestore.DocumentGroup.UID_TYPE;

public final class DocumentGroupMock {

    private DocumentGroupMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends SiteStoreFolder, TBUILDER extends SiteStoreFolderBuilder<T, TBUILDER>> DocumentGroupBuilder documentGroupWith(String uid, long id, TBUILDER parent) {
        return new DefaultDocumentGroupBuilder(uid, id, parent);
    }

    public static <T extends SiteStoreFolder, TBUILDER extends SiteStoreFolderBuilder<T, TBUILDER>> DocumentGroupBuilder documentGroupWith(String uid, long id, String extension, TemplateSetBuilder templateSet, TBUILDER parent) {
        return new DefaultDocumentGroupBuilder(uid, id, extension, templateSet, parent);
    }

    public interface DocumentGroupBuilder extends ContentProducerBuilder<DocumentGroup, DocumentGroupBuilder> {
    }

    private static final class DefaultDocumentGroupBuilder extends DefaultContentProducerBuilder<DocumentGroup, DocumentGroupBuilder, DefaultDocumentGroupBuilder> implements DocumentGroupBuilder {

        private <T extends SiteStoreFolder, TBUILDER extends SiteStoreFolderBuilder<T, TBUILDER>> DefaultDocumentGroupBuilder(String uid, long id, TBUILDER parent) {
            super(uid, id, UID_TYPE, parent);
            aReferenceName(DOCUMENTGROUP.prefix() + uid);
        }

        private <T extends SiteStoreFolder, TBUILDER extends SiteStoreFolderBuilder<T, TBUILDER>> DefaultDocumentGroupBuilder(String uid, long id, String extension, TemplateSetBuilder templateSet, TBUILDER parent) {
            super(uid, id, UID_TYPE, extension, templateSet, parent);
            aReferenceName(DOCUMENTGROUP.prefix() + uid);
        }
    }
}
