package com.divae.firstspirit.or;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.or.EntityList;
import de.espirit.or.schema.Entity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public final class EntityListMock {

	private EntityListMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static EntityListBuilder entityListWith() {
		return new DefaultEntityListBuilder();
	}

	public interface EntityListBuilder extends Builder<EntityList, EntityListBuilder> {
		EntityListBuilder values(List<Entity> entities);
	}

	public static final class DefaultEntityListBuilder extends DefaultBuilder<EntityList, EntityListBuilder, DefaultEntityListBuilder> implements EntityListBuilder {

		private final List<Entity> entities = new ArrayList<>();

		private DefaultEntityListBuilder() {
			mockList();

			when(getBuildable().get(anyInt())).thenAnswer(invocation -> {
				int index = invocation.getArgument(0);
				if (getBuildable().isEmpty() || getBuildable().size() < index) {
					throw new IndexOutOfBoundsException();
				}
				return entities.get(index);
			});
		}

		@Override
		public final EntityListBuilder values(List<Entity> entities) {
			this.entities.addAll(entities);

			mockList();

			for (int i = 0; i < this.entities.size(); i++) {
				getBuildable().get(i);
			}

			return getBuilder();
		}

		private void mockList() {
			when(getBuildable().iterator()).thenReturn(entities.iterator());
			when(getBuildable().isEmpty()).thenReturn(entities.isEmpty());
			when(getBuildable().size()).thenReturn(entities.size());
		}
	}

}
