package com.divae.firstspirit.access.store;

import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.store.LanguageInfoMock.LanguageInfoBuilder;
import com.divae.firstspirit.access.store.StoreElementMock.DefaultStoreElementBuilder;
import com.divae.firstspirit.access.store.StoreElementMock.StoreElementBuilder;
import com.divae.firstspirit.forms.FormDataMock.FormDataBuilder;
import com.divae.firstspirit.storage.HistoryProviderMock.HistoryProviderBuilder;
import com.divae.firstspirit.storage.HistoryProviderMock.TruncatedHistoryProviderBuilder;
import com.divae.firstspirit.storage.RevisionMock.RevisionBuilder;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.LanguageInfo;
import de.espirit.firstspirit.forms.FormData;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.storage.HistoryProviderMock.historyProviderWith;
import static java.lang.Boolean.TRUE;
import static org.mockito.Mockito.when;

public final class IDProviderMock {

    private IDProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends IDProvider, E extends IDProvider, EBUILDER extends IDProviderBuilder<E, EBUILDER>> TruncatedIDProviderBuilder<T> idProviderWith(String uid, long id, EBUILDER parent) {
        return new DefaultTruncatedIDProviderBuilder<>(uid, id, parent);
    }

    public static <T extends IDProvider, E extends IDProvider, EBUILDER extends IDProviderBuilder<E, EBUILDER>> TruncatedIDProviderBuilder<T> idProviderWith(String uid, long id, UidType uidType, EBUILDER parent) {
        return new DefaultTruncatedIDProviderBuilder<>(uid, id, uidType, parent);
    }

    public static <T extends IDProvider, E extends IDProvider, EBUILDER extends IDProviderBuilder<E, EBUILDER>> TruncatedIDProviderBuilder<T> idProviderWith(String uid, long id, UidType uidType, EBUILDER parent, ProjectBuilder project) {
        return new DefaultTruncatedIDProviderBuilder<>(uid, id, uidType, parent, project);
    }

    public static <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> TruncatedIDProviderBuilder<T> idProviderWith(TBUILDER idProvider) {
        return new DefaultTruncatedIDProviderBuilder<>(idProvider);
    }

    public interface IDProviderBuilder<T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> extends StoreElementBuilder<T, TBUILDER>, HistoryProviderBuilder<T, TBUILDER> {
        TBUILDER aReleaseStatus(int releaseStatus);

        TBUILDER languageInfo(Function<TBUILDER, LanguageInfoBuilder> function);

        <E extends FormData, EBUILDER extends FormDataBuilder<E, EBUILDER>> TBUILDER aMetaFormData(Supplier<EBUILDER> supplier);
    }

    public static class DefaultIDProviderBuilder<T extends IDProvider, EBUILDER extends IDProviderBuilder<T, EBUILDER>, TBUILDER extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER>> extends DefaultStoreElementBuilder<T, EBUILDER, TBUILDER> implements IDProviderBuilder<T, EBUILDER> {

        private final TruncatedHistoryProviderBuilder<T> historyProviderBuilder;

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultIDProviderBuilder(String name, long id, OTBUILDER parent) {
            super(name, parent);
            if (parent != null) {
                validateIds(id, getBuildable(parent).getId());
            }

            withUId(null);
            withId(id);
            historyProviderBuilder = historyProviderWith(getInterfaceBuilder());
        }

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultIDProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, parent);
            if (parent != null) {
                validateIds(id, getBuildable(parent).getId());
            }

            withUidType(uidType);
            withUId(uid);
            withId(id);
            historyProviderBuilder = historyProviderWith(getInterfaceBuilder());
        }

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultIDProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent, ProjectBuilder project) {
            super(uid, parent, project);
            if (parent != null) {
                validateIds(id, getBuildable(parent).getId());
            }
            validateIds(id, getBuildable(project).getId());

            withUidType(uidType);
            withUId(uid);
            withId(id);
            historyProviderBuilder = historyProviderWith(getInterfaceBuilder());
        }

        private void withUidType(UidType uidType) {
            when(getBuildable().getUidType()).thenReturn(uidType);
        }


        private void validateIds(long id, long parentId) {
            if (id <= parentId) {
                throw new IllegalArgumentException("Id [" + id + "] must be smaller then [" + parentId + "]. Please choose another value.");
            }
        }

        protected <OTBUILDER extends IDProviderBuilder<T, OTBUILDER>> DefaultIDProviderBuilder(OTBUILDER idProvider) {
            super(idProvider);
            historyProviderBuilder = historyProviderWith(getInterfaceBuilder());
        }

        private void withId(long id) {
            if (id < 0) {
                throw new IllegalArgumentException("Id [" + id + "] must be positive. Please choose another value.");
            }
            when(getBuildable().getId()).thenReturn(id);
        }

        private void withUId(String uid) {
            if (StringUtils.isBlank(uid)) {
                when(getBuildable().getUid()).thenThrow(new UnsupportedOperationException());
                return;
            }
            when(getBuildable().getUid()).thenReturn(uid);
            when(getBuildable().hasUid()).thenReturn(TRUE);
        }

        @Override
        public final EBUILDER aReleaseStatus(int releaseStatus) {
            when(getBuildable().getReleaseStatus()).thenReturn(releaseStatus);
            return getInterfaceBuilder();
        }


        @Override
        public final EBUILDER languageInfo(Function<EBUILDER, LanguageInfoBuilder> function) {
            EBUILDER builder = getInterfaceBuilder();
            LanguageInfo languageInfo = build(function.apply(builder));
            Language language = languageInfo.getLanguage();
            when(getBuildable().getLanguageInfo(language)).thenReturn(languageInfo);
            String displayName = languageInfo.getDisplayName();
            if (displayName != null) {
                when(getBuildable().getDisplayName(language)).thenReturn(displayName);
            }
            return builder;
        }

        @Override
        public final <OT extends FormData, OTBUILDER extends FormDataBuilder<OT, OTBUILDER>> EBUILDER aMetaFormData(Supplier<OTBUILDER> supplier) {
            FormData formData = build(supplier.get());
            when(getBuildable().getMetaFormData()).thenReturn(formData);
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER aHistory(Supplier<List<RevisionBuilder>> supplier) {
            historyProviderBuilder.aHistory(supplier);
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedIDProviderBuilder<T extends IDProvider> extends IDProviderBuilder<T, TruncatedIDProviderBuilder<T>> {
    }

    private static final class DefaultTruncatedIDProviderBuilder<T extends IDProvider> extends DefaultIDProviderBuilder<T, TruncatedIDProviderBuilder<T>, DefaultTruncatedIDProviderBuilder<T>> implements TruncatedIDProviderBuilder<T> {

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultTruncatedIDProviderBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultTruncatedIDProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);

        }

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultTruncatedIDProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent, ProjectBuilder project) {
            super(uid, id, uidType, parent, project);
        }

        private <OTBUILDER extends IDProviderBuilder<T, OTBUILDER>> DefaultTruncatedIDProviderBuilder(OTBUILDER idProvider) {
            super(idProvider);
        }

    }
}