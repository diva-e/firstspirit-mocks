package com.divae.firstspirit.or;

import com.divae.firstspirit.MockTest;
import de.espirit.or.EntityList;
import de.espirit.or.schema.Entity;
import org.junit.Test;

import java.util.UUID;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.or.EntityListMock.entityListWith;
import static com.divae.firstspirit.or.schema.EntityMock.entityWith;
import static java.lang.Boolean.FALSE;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EntityListMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return EntityListMock.class;
    }

    @Test
    public void testValues() {
        Entity entity = build(entityWith(new UUID(0, 0)));
        EntityList entityList = build(entityListWith().values(singletonList(entity)));
        assertThat(entityList.size(), is(1));
        assertThat(entityList.isEmpty(), is(FALSE));
        assertThat(entityList.get(0), is(entity));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        EntityList entityList = build(entityListWith());
        entityList.get(6);
    }
}
