package com.divae.firstspirit.access.store.contentstore;

import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.store.StoreMock.DefaultStoreBuilder;
import com.divae.firstspirit.access.store.StoreMock.StoreBuilder;
import com.divae.firstspirit.access.store.contentstore.Content2Mock.Content2Builder;
import com.divae.firstspirit.access.store.contentstore.ContentFolderMock.ContentFolderBuilder;
import de.espirit.firstspirit.access.store.Store.Type;
import de.espirit.firstspirit.access.store.contentstore.Content2;
import de.espirit.firstspirit.access.store.contentstore.ContentStoreRoot;

import java.util.function.Function;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.contentstore.ContentFolderMock.contentFolderWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.CONTENTSTORE;
import static org.mockito.Mockito.when;

public final class ContentStoreRootMock {

    private ContentStoreRootMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static ContentStoreRootBuilder contentStoreRootWith(long id, ProjectBuilder project) {
        return new DefaultContentStoreRootBuilder(id, project);
    }

    public interface ContentStoreRootBuilder extends StoreBuilder<ContentStoreRoot, ContentStoreRootBuilder>, ContentFolderBuilder<ContentStoreRoot, ContentStoreRootBuilder> {
        ContentStoreRootBuilder aContent2(Function<ContentStoreRootBuilder, Content2Builder> function, String content2ByName);
    }

    public static final class DefaultContentStoreRootBuilder extends DefaultStoreBuilder<ContentStoreRoot, ContentStoreRootBuilder, DefaultContentStoreRootBuilder> implements ContentStoreRootBuilder {

        private DefaultContentStoreRootBuilder(long id, ProjectBuilder project) {
            super(id, CONTENTSTORE, Type.CONTENTSTORE, project);
            contentFolderWith(getBuilder());
        }

        @Override
        public final ContentStoreRootBuilder aContent2(Function<ContentStoreRootBuilder, Content2Builder> function, String content2ByName) {
            Content2 content2 = build(function.apply(getBuilder()));
            when(getBuildable().getContent2ByName(content2ByName)).thenReturn(content2);
            return getBuilder();
        }
    }

}
