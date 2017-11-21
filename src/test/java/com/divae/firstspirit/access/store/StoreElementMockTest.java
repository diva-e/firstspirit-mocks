package com.divae.firstspirit.access.store;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.ReferenceEntryMock.ReferenceEntryBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.TruncatedIDProviderBuilder;
import com.divae.firstspirit.access.store.StoreElementMock.StoreElementBuilder;
import com.divae.firstspirit.common.util.TypedFilterMock.TypedFilterBuilder;
import de.espirit.firstspirit.access.ReferenceEntry;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.StoreElement;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.PrincipalMock.principalWith;
import static com.divae.firstspirit.access.ReferenceEntryMock.referenceEntryWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.IDProviderMock.idProviderWith;
import static com.divae.firstspirit.access.store.StoreElementMock.storeElementWith;
import static com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.globalStoreRootWith;
import static com.divae.firstspirit.common.util.TypedFilterMock.typedFilterWith;
import static de.espirit.firstspirit.access.ReferenceEntry.GLOBAL_STORE_REFERENCE;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.GLOBALSTORE;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.Long.valueOf;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class StoreElementMockTest extends MockTest {

    @Test
    public void testStoreElementWithStore() {
        assertThat(storeElementWith(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")))), is(notNullValue()));
    }

    @Test
    public void testStoreElementWithStoreElement() {
        assertThat(storeElementWith(storeElementWith(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE"))))), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return StoreElementMock.class;
    }

    @Test
    public void testWasLastChanged() {
        long lastChanged = 1L;
        StoreElement storeElement = build(storeElementWith(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")))).wasLastChanged(lastChanged));
        assertThat(storeElement.getLastChanged(), is(valueOf(lastChanged)));
    }

    @Test
    public void testStoreElementDefaults() {
        StoreElement storeElement = build(storeElementWith(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")))));
        assertThat(storeElement.getStore(), is(notNullValue()));
    }

    @Test
    public void testAReferenceName() {
        String referenceName = "test";
        StoreElement storeElement = build(storeElementWith(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")))).aReferenceName(referenceName));
        assertThat(storeElement.getReferenceName(), is(referenceName));
    }

    @Test
    public void testIsFolder() {
        StoreElement storeElement = build(storeElementWith(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")))).isFolder(true));
        assertThat(storeElement.isFolder(), is(TRUE));
    }

    @Test
    public void testChildrenList() {
        StoreElement storeElement = build(storeElementWith("test", null).children(parent -> singletonList(storeElementWith("child", parent))));
        Iterator<StoreElement> iterator = storeElement.getChildren().iterator();
        assertThat(iterator.hasNext(), is(TRUE));
        assertThat(iterator.next().getName(), is("child"));
        assertThat(iterator.hasNext(), is(FALSE));
    }

    @Test
    public void testChildrenListWithTypeFilter() {
        TypedFilterBuilder<StoreElement> typedFilterBuilder = typedFilterWith();
        StoreElement storeElement = build(storeElementWith("storeElement", null).children(parent -> singletonList(storeElementWith("child", parent)), () -> typedFilterBuilder, true));
        Iterator<StoreElement> iterator = storeElement.getChildren(build(typedFilterBuilder), true).iterator();
        assertThat(iterator.hasNext(), is(TRUE));
        assertThat(iterator.next().getName(), is("child"));
        assertThat(iterator.hasNext(), is(FALSE));
    }

    @Test
    public void testChildrenListWithTypeFilter2() {
        TypedFilterBuilder<StoreElement> typedFilterBuilder = typedFilterWith();
        StoreElement storeElement = build(storeElementWith("storeElement", null).children(parent -> singletonList(storeElementWith("child", parent)), () -> typedFilterBuilder, false));
        Iterator<StoreElement> iterator = storeElement.getChildren(build(typedFilterBuilder), false).iterator();
        assertThat(iterator.hasNext(), is(TRUE));
        assertThat(iterator.next().getName(), is("child"));
        assertThat(iterator.hasNext(), is(FALSE));
    }

    @Test
    public void testChildrenClassBooleanList() {
        StoreElement storeElement = build(storeElementWith("storeElement", null).children(parent -> singletonList(storeElementWith("child", parent)), StoreElement.class, true));
        Iterator<StoreElement> iterator = storeElement.getChildren(StoreElement.class, true).iterator();
        assertThat(iterator.hasNext(), is(TRUE));
        assertThat(iterator.next().getName(), is("child"));
        assertThat(iterator.hasNext(), is(FALSE));
    }

    @Test
    public void testChildrenClassBooleanList2() {
        StoreElement storeElement = build(storeElementWith("storeElement", null).children(parent -> singletonList(storeElementWith("child", parent)), StoreElement.class, false));
        Iterator<StoreElement> iterator = storeElement.getChildren(StoreElement.class, false).iterator();
        assertThat(iterator.hasNext(), is(TRUE));
        assertThat(iterator.next().getName(), is("child"));
        assertThat(iterator.hasNext(), is(FALSE));
    }

    @Test
    public void testChildrenClassList() {
        StoreElement storeElement = build(storeElementWith("storeElement", null).children(parent -> singletonList(storeElementWith("child", parent)), StoreElement.class));
        Iterator<StoreElement> iterator = storeElement.getChildren(StoreElement.class).iterator();
        assertThat(iterator.hasNext(), is(TRUE));
        assertThat(iterator.next().getName(), is("child"));
        assertThat(iterator.hasNext(), is(FALSE));
    }

    @Test
    public void testWasDeleted() {
        StoreElement storeElement = build(storeElementWith(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")))).wasDeleted(true));
        assertThat(storeElement.isDeleted(), is(Boolean.TRUE));
    }

    @Test
    public void testOutgoingReferences() {
        String uid = "test";

        @SuppressWarnings("unchecked") Iterator<StoreElement> iterator = build(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE"))).children(parent -> {
            TruncatedIDProviderBuilder<IDProvider> idProviderBuilder = idProviderWith(uid, 2, GLOBALSTORE, parent);
            return Arrays.<StoreElementBuilder>asList(idProviderBuilder, storeElementWith("test", parent).outgoingReferences(() -> new ReferenceEntryBuilder[]{referenceEntryWith(1L).aReferencedElement(idProviderBuilder, GLOBAL_STORE_REFERENCE)}));
        })).getStore().getChildren().iterator();
        iterator.next();
        StoreElement storeElement = iterator.next();
        ReferenceEntry[] outgoingReferences = storeElement.getOutgoingReferences();
        assertThat(outgoingReferences.length, is(1));
        assertThat(outgoingReferences[0].getReferencedElement().getId(), is(2L));
    }

    @Test
    public void testIncomingReferences() {
        String uid = "test";

        @SuppressWarnings("unchecked") Iterator<StoreElement> iterator = build(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE"))).children(parent -> {
            TruncatedIDProviderBuilder<IDProvider> idProviderBuilder = idProviderWith(uid + "1", 3, GLOBALSTORE, parent);
            return Arrays.<StoreElementBuilder>asList(idProviderBuilder, storeElementWith("test", parent).incomingReferences(() -> new ReferenceEntryBuilder[]{referenceEntryWith(0L).aReferencedElement(idProviderBuilder, GLOBAL_STORE_REFERENCE)}));
        })).getStore().getChildren().iterator();
        iterator.next();
        StoreElement storeElement = iterator.next();
        ReferenceEntry[] incomingReferences = storeElement.getIncomingReferences();
        assertThat(incomingReferences.length, is(1));
        assertThat(incomingReferences[0].getReferencedElement().getId(), is(3L));
    }

    @Test
    public void testIsDeleted() {
        StoreElement storeElement = build(storeElementWith(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")))).isDeleted(true));
        assertThat(storeElement.isDeleted(), is(TRUE));
    }

    @Test
    public void testParentStoreElement() {
        StoreElement storeElement = build(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE"))).children(parent -> singletonList(storeElementWith("parent", parent).children(storeElementParent -> singletonList(storeElementWith("child", storeElementParent)))))).getStore().getChildren().iterator().next();
        StoreElement child = storeElement.getChildren().iterator().next();
        assertThat(child.getParent(), is(storeElement));
    }

    @Test
    public void testInheritedPrincipalPermissions() throws Exception {
        StoreElement storeElement = build(storeElementWith(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")))).inheritedPrincipalPermissions(() -> singletonList(principalWith(0L))));
        assertThat(storeElement.getInheritedPrincipalPermissions().size(), is(1));
        assertThat(storeElement.getInheritedPrincipalPermissions().get(0).getId(), is(0L));
    }

    @Test
    public void testDefinedPrincipalPermissions() throws Exception {
        StoreElement storeElement = build(storeElementWith(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE")))).definedPrincipalPermissions(() -> singletonList(principalWith(0L))));
        assertThat(storeElement.getDefinedPrincipalPermissions().size(), is(1));
        assertThat(storeElement.getDefinedPrincipalPermissions().get(0).getId(), is(0L));
    }
}
