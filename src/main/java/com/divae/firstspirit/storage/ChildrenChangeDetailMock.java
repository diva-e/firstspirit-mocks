package com.divae.firstspirit.storage;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.access.store.BasicElementInfoMock.BasicElementInfoBuilder;
import com.divae.firstspirit.storage.RevisionChangeDetailMock.DefaultRevisionChangeDetailBuilder;
import com.divae.firstspirit.storage.RevisionChangeDetailMock.RevisionChangeDetailBuilder;
import de.espirit.common.util.Pair;
import de.espirit.firstspirit.access.store.BasicElementInfo;
import de.espirit.firstspirit.storage.ChildrenChangeDetail;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.mockito.Mockito.when;

public final class ChildrenChangeDetailMock {

	private ChildrenChangeDetailMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ChildrenChangeDetailBuilder childrenChangeDetailWith() {
		return new DefaultChildrenChangeDetailBuilder();
	}

	public interface ChildrenChangeDetailBuilder extends RevisionChangeDetailBuilder<ChildrenChangeDetail, ChildrenChangeDetailBuilder> {
		ChildrenChangeDetailBuilder addedElements(Supplier<List<BasicElementInfoBuilder>> supply);

		ChildrenChangeDetailBuilder removedElements(Supplier<List<BasicElementInfoBuilder>> supply);

		ChildrenChangeDetailBuilder reorderedElements(Supplier<Map<BasicElementInfoBuilder, Pair<Integer, Integer>>> supply);
	}

	public static final class DefaultChildrenChangeDetailBuilder extends DefaultRevisionChangeDetailBuilder<ChildrenChangeDetail, ChildrenChangeDetailBuilder, DefaultChildrenChangeDetailBuilder> implements ChildrenChangeDetailBuilder {

		private DefaultChildrenChangeDetailBuilder() {
		}

		@Override
		public final ChildrenChangeDetailBuilder addedElements(Supplier<List<BasicElementInfoBuilder>> supply) {
			List<BasicElementInfo> basicElementInfo = supply.get().stream().map(BuilderMock::build).collect(toList());
			when(getBuildable().getAddedElements()).thenReturn(basicElementInfo);
			return getBuilder();
		}

		@Override
		public final ChildrenChangeDetailBuilder removedElements(Supplier<List<BasicElementInfoBuilder>> supply) {
			List<BasicElementInfo> basicElementInfo = supply.get().stream().map(BuilderMock::build).collect(toList());
			when(getBuildable().getRemovedElements()).thenReturn(basicElementInfo);
			return getBuilder();
		}

		@Override
		public final ChildrenChangeDetailBuilder reorderedElements(Supplier<Map<BasicElementInfoBuilder, Pair<Integer, Integer>>> supply) {
			Map<BasicElementInfo, Pair<Integer, Integer>> reorderedElements = supply.get().entrySet().stream().collect(toMap(entry -> build(entry.getKey()), Entry::getValue));
			when(getBuildable().getReorderedElements()).thenReturn(reorderedElements);
			return getBuilder();
		}
	}

}
