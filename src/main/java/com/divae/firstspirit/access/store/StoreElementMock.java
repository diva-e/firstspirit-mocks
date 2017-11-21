package com.divae.firstspirit.access.store;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.PrincipalMock.PrincipalBuilder;
import com.divae.firstspirit.access.ReferenceEntryMock.ReferenceEntryBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.common.util.TypedFilterMock.TypedFilterBuilder;
import com.divae.firstspirit.listable.ListableMock;
import de.espirit.common.util.Filter.TypedFilter;
import de.espirit.common.util.Listable;
import de.espirit.firstspirit.access.Principal;
import de.espirit.firstspirit.access.ReferenceEntry;
import de.espirit.firstspirit.access.project.Project;
import de.espirit.firstspirit.access.store.Store;
import de.espirit.firstspirit.access.store.StoreElement;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.listable.ListableMock.listableWith;
import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public final class StoreElementMock {

    private StoreElementMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends StoreElement, OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> TruncatedStoreElementBuilder<T> storeElementWith(String name, OTBUILDER parent) {
        return new DefaultTruncatedStoreElementBuilder<>(name, parent);
    }

    public static <T extends StoreElement, OTBUILDER extends StoreElementBuilder<T, OTBUILDER>> TruncatedStoreElementBuilder<T> storeElementWith(OTBUILDER storeElement) {
        return new DefaultTruncatedStoreElementBuilder<>(storeElement);
    }

    public interface StoreElementBuilder<T extends StoreElement, TBUILDER extends StoreElementBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
        TBUILDER wasDeleted(boolean deleted);

        TBUILDER outgoingReferences(Supplier<ReferenceEntryBuilder[]> supplier);

        TBUILDER incomingReferences(Supplier<ReferenceEntryBuilder[]> supplier);

        TBUILDER wasLastChanged(long lastChanged);

        TBUILDER isFolder(boolean isFolder);

        TBUILDER isDeleted(boolean deleted);

        TBUILDER aReferenceName(String referenceName);

        <OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> TBUILDER children(Function<TBUILDER, List<OTBUILDER>> function);

        <OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> TBUILDER children(Function<TBUILDER, List<OTBUILDER>> function, Class<OT> clazz);

        <OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> TBUILDER children(Function<TBUILDER, List<OTBUILDER>> function, Class<OT> clazz, boolean recursive);

        <OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> TBUILDER children(Function<TBUILDER, List<OTBUILDER>> function, Supplier<TypedFilterBuilder<OT>> typedFilterSupplier, boolean recursive);

        <OT extends Principal, OTBUILDER extends PrincipalBuilder<OT, OTBUILDER>> TBUILDER definedPrincipalPermissions(Supplier<List<OTBUILDER>> supplier);

        <OT extends Principal, OTBUILDER extends PrincipalBuilder<OT, OTBUILDER>> TBUILDER inheritedPrincipalPermissions(Supplier<List<OTBUILDER>> supplier);
    }

    public static class DefaultStoreElementBuilder<T extends StoreElement, EBUILDER extends StoreElementBuilder<T, EBUILDER>, TBUILDER extends DefaultStoreElementBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements StoreElementBuilder<T, EBUILDER> {

        protected <OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> DefaultStoreElementBuilder(String name, OTBUILDER parent) {
            super(name);
            aName(name);
            if (parent != null) {
                OT storeElement = getBuildable(parent);
                aParent(storeElement);
                aProject(storeElement.getProject());
            }
            children((Function<EBUILDER, List<EBUILDER>>) t -> emptyList());
            addGenericEmptyChildrenLists(getBuildable().getClass().getInterfaces());
            incomingReferences(() -> new ReferenceEntryBuilder[0]);
            outgoingReferences(() -> new ReferenceEntryBuilder[0]);
        }

        protected <OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> DefaultStoreElementBuilder(String name, OTBUILDER parent, ProjectBuilder project) {
            super(name);
            aName(name);
            if (parent != null) {
                aParent(getBuildable(parent));
            }
            aProject(getBuildable(project));
            children((Function<EBUILDER, List<EBUILDER>>) t -> emptyList());
            addGenericEmptyChildrenLists(getBuildable().getClass().getInterfaces());
            incomingReferences(() -> new ReferenceEntryBuilder[0]);
            outgoingReferences(() -> new ReferenceEntryBuilder[0]);
        }

        protected <OTBUILDER extends StoreElementBuilder<T, OTBUILDER>> DefaultStoreElementBuilder(OTBUILDER storeElement) {
            super(storeElement);
        }


        @Override
        public final EBUILDER wasDeleted(boolean deleted) {
            when(getBuildable().isDeleted()).thenReturn(deleted);
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER outgoingReferences(Supplier<ReferenceEntryBuilder[]> supplier) {
            Stream<ReferenceEntry> referenceEntriesStream = of(supplier.get()).map(BuilderMock::build);
            ReferenceEntry[] outgoingReferences = getBuildable().getOutgoingReferences();
            ReferenceEntry[] referenceEntries = outgoingReferences != null ? concat(stream(outgoingReferences), referenceEntriesStream).toArray(ReferenceEntry[]::new) : referenceEntriesStream.toArray(ReferenceEntry[]::new);

            when(getBuildable().getOutgoingReferences()).thenReturn(referenceEntries);
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER incomingReferences(Supplier<ReferenceEntryBuilder[]> supplier) {
            Stream<ReferenceEntry> referenceEntriesStream = of(supplier.get()).map(BuilderMock::build);
            ReferenceEntry[] incomingReferences = getBuildable().getIncomingReferences();
            ReferenceEntry[] referenceEntries = incomingReferences != null ? concat(stream(incomingReferences), referenceEntriesStream).toArray(ReferenceEntry[]::new) : referenceEntriesStream.toArray(ReferenceEntry[]::new);

            when(getBuildable().getIncomingReferences()).thenReturn(referenceEntries);
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER wasLastChanged(long lastChanged) {
            when(getBuildable().getLastChanged()).thenReturn(lastChanged);
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER isFolder(boolean isFolder) {
            when(getBuildable().isFolder()).thenReturn(isFolder);
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER isDeleted(boolean deleted) {
            when(getBuildable().isDeleted()).thenReturn(deleted);
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER aReferenceName(String referenceName) {
            when(getBuildable().getReferenceName()).thenReturn(referenceName);
            return getInterfaceBuilder();
        }


        @Override
        public final <OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> EBUILDER children(Function<EBUILDER, List<OTBUILDER>> function) {
            EBUILDER builder = getInterfaceBuilder();
            List<StoreElement> storeElements = function.apply(builder).stream().<StoreElement>map(BuilderMock::build).collect(toList());
            children(storeElements);
            return builder;
        }

        protected void children(List<StoreElement> storeElements) {
            mockChildren(storeElements);
            mockChildren(storeElements, StoreElement.class);
            mockChildren(storeElements, StoreElement.class, false);
            mockChildren(storeElements, StoreElement.class, true);
            mockChildren(storeElements, ArgumentMatchers.<TypedFilter<StoreElement>>any(), false);
            mockChildren(storeElements, ArgumentMatchers.<TypedFilter<StoreElement>>any(), true);
            mockChildren(storeElements, ArgumentMatchers.<TypedFilter<StoreElement>>any(), true);
        }

        private void mockChildren(List<StoreElement> children) {
            List<StoreElement> combinedChildren = new ArrayList<>();
            combinedChildren.addAll(children);
            Listable<StoreElement> currentChildren = getBuildable().getChildren();
            if (currentChildren != null) {
                combinedChildren.addAll(currentChildren.toList());
            }
            Listable<StoreElement> listable = build(listableWith().elements(combinedChildren));
            when(getBuildable().getChildren()).thenReturn(listable);
        }

        @SuppressWarnings("unchecked")
        @Override
        public <OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> EBUILDER children(Function<EBUILDER, List<OTBUILDER>> function, Class<OT> clazz) {
            EBUILDER builder = getInterfaceBuilder();
            List<OT> storeElements = function.apply(builder).stream().map(BuilderMock::build).collect(toList());
            mockChildren(storeElements, clazz);
            mockChildren(storeElements, clazz, false);
            mockChildren(storeElements, clazz, true);
            mockChildren(storeElements, ArgumentMatchers.<TypedFilter<OT>>any(), false);
            mockChildren(storeElements, ArgumentMatchers.<TypedFilter<OT>>any(), true);
            mockChildren((List<StoreElement>) storeElements);
            return builder;

        }

        @SuppressWarnings("unchecked")
        @Override
        public <OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> EBUILDER children(Function<EBUILDER, List<OTBUILDER>> function, Class<OT> clazz, boolean recursive) {
            EBUILDER builder = getInterfaceBuilder();
            List<OT> storeElements = function.apply(builder).stream().map(BuilderMock::build).collect(toList());
            mockChildren(storeElements, clazz, recursive);
            mockChildren(storeElements, ArgumentMatchers.<TypedFilter<OT>>any(), recursive);
            if (!recursive) {
                mockChildren(storeElements, clazz);
                mockChildren((List<StoreElement>) storeElements);
            }
            return builder;
        }

        @SuppressWarnings("unchecked")
        @Override
        public final <OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> EBUILDER children(Function<EBUILDER, List<OTBUILDER>> function, Supplier<TypedFilterBuilder<OT>> typedFilterSupplier, boolean recursive) {
            EBUILDER builder = getInterfaceBuilder();
            List<OT> storeElements = function.apply(builder).stream().map(BuilderMock::build).collect(toList());
            TypedFilter<OT> typedFilter = build(typedFilterSupplier.get());
            mockChildren(storeElements, typedFilter, recursive);
            mockChildren(storeElements, ArgumentMatchers.<Class<OT>>any(), eq(recursive));
            if (!recursive) {
                mockChildren((List<StoreElement>) storeElements);
                mockChildren(storeElements, ArgumentMatchers.any());
            }
            return builder;
        }

        private <OT extends StoreElement> void mockChildren(List<OT> children, Class<OT> clazz) {
            List<OT> combinedChildren = new ArrayList<>();
            combinedChildren.addAll(children);
            Listable<OT> currentChildren = getBuildable().getChildren(clazz);
            if (currentChildren != null) {
                combinedChildren.addAll(currentChildren.toList());
            }
            Listable<OT> listable = build(ListableMock.<OT>listableWith().elements(combinedChildren));
            when(getBuildable().getChildren(clazz)).thenReturn(listable);
        }

        private <OT extends StoreElement> void mockChildren(List<OT> children, Class<OT> clazz, boolean recursive) {
            List<OT> combinedChildren = new ArrayList<>();
            combinedChildren.addAll(children);
            Listable<OT> currentChildren = getBuildable().getChildren(clazz, recursive);
            if (currentChildren != null) {
                combinedChildren.addAll(currentChildren.toList());
            }

            Listable<OT> listable = build(ListableMock.<OT>listableWith().elements(combinedChildren));
            when(getBuildable().getChildren(clazz, recursive)).thenReturn(listable);
        }

        private <OT extends StoreElement> void mockChildren(List<OT> children, TypedFilter<OT> typedFilter, boolean recursive) {
            List<OT> combinedChildren = new ArrayList<>();
            combinedChildren.addAll(children);
            Listable<OT> currentChildren = (typedFilter == null) ? getBuildable().getChildren(ArgumentMatchers.<TypedFilter<OT>>any(), recursive) : getBuildable().getChildren(typedFilter, recursive);
            if (currentChildren != null) {
                combinedChildren.addAll(currentChildren.toList());
            }
            Listable<OT> listable = build(ListableMock.<OT>listableWith().elements(combinedChildren));
            if (typedFilter == null) {
                when(getBuildable().getChildren(ArgumentMatchers.<TypedFilter<OT>>any(), eq(recursive))).thenReturn(listable);
            } else {
                when(getBuildable().getChildren(typedFilter, recursive)).thenReturn(listable);
            }
        }

        protected <OT extends StoreElement> Builder<T, EBUILDER> aParent(OT parent) {
            validateOwnWithOtherStoreElement(parent);

            when(getBuildable().getParent()).thenReturn(parent);
            aStore(parent.getStore());
            return getBuilder();
        }

        protected void validateOwnWithOtherProject(Project project) {
            Project ownProject = getBuildable().getStore().getProject();
            if (!ownProject.equals(project)) {
                throw new IllegalArgumentException("Project has not this project. Please correct this.");
            }
        }

        protected void validateOwnWithOtherStoreElement(StoreElement storeElement) {
            if (getBuildable().getName().equals(storeElement.getName())) {
                throw new IllegalArgumentException("Parent has same name [" + storeElement.getName() + "] then child. Please choose another value.");
            }
        }

        @Override
        public final <OT extends Principal, OTBUILDER extends PrincipalBuilder<OT, OTBUILDER>> EBUILDER definedPrincipalPermissions(Supplier<List<OTBUILDER>> supplier) {
            List<Principal> principals = supplier.get().stream().map(BuilderMock::build).collect(toList());
            when(getBuildable().getDefinedPrincipalPermissions()).thenReturn(principals);
            return getInterfaceBuilder();
        }

        @Override
        public final <OT extends Principal, OTBUILDER extends PrincipalBuilder<OT, OTBUILDER>> EBUILDER inheritedPrincipalPermissions(Supplier<List<OTBUILDER>> supplier) {
            List<Principal> principals = supplier.get().stream().map(BuilderMock::build).collect(toList());
            when(getBuildable().getInheritedPrincipalPermissions()).thenReturn(principals);
            return getInterfaceBuilder();
        }

        protected void aStore(Store store) {
            when(getBuildable().getStore()).thenReturn(store);
        }

        private void aProject(Project project) {
            when(getBuildable().getProject()).thenReturn(project);
        }

        private void aName(String name) {
            when(getBuildable().getName()).thenReturn(name);
        }

        @SuppressWarnings({"unchecked"})
        private void addGenericEmptyChildrenLists(Class<?>[] interfaces) {
            for (Class<?> clazz : interfaces) {
                if (StoreElement.class.isAssignableFrom(clazz)) {
                    children((Function<EBUILDER, List<EBUILDER>>) t -> emptyList(), (Class<T>) clazz);
                    children((Function<EBUILDER, List<EBUILDER>>) t -> emptyList(), (Class<T>) clazz, true);
                    addGenericEmptyChildrenLists(clazz.getInterfaces());
                }
            }
        }

    }

    public interface TruncatedStoreElementBuilder<T extends StoreElement> extends StoreElementBuilder<T, TruncatedStoreElementBuilder<T>> {
    }

    private static final class DefaultTruncatedStoreElementBuilder<T extends StoreElement> extends DefaultStoreElementBuilder<T, TruncatedStoreElementBuilder<T>, DefaultTruncatedStoreElementBuilder<T>> implements TruncatedStoreElementBuilder<T> {

        private <OT extends StoreElement, OTBUILDER extends StoreElementBuilder<OT, OTBUILDER>> DefaultTruncatedStoreElementBuilder(String name, OTBUILDER parent) {
            super(name, parent);
        }

        private <OTBUILDER extends StoreElementBuilder<T, OTBUILDER>> DefaultTruncatedStoreElementBuilder(OTBUILDER storeElement) {
            super(storeElement);
        }
    }
}