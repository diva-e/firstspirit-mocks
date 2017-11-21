package com.divae.firstspirit.storage;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.BasicElementInfoMock.BasicElementInfoBuilder;
import de.espirit.firstspirit.access.store.BasicElementInfo;
import de.espirit.firstspirit.storage.DeleteOperation;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.BasicElementInfoMock.basicElementInfoWith;
import static com.divae.firstspirit.storage.DeleteOperationMock.deleteOperationWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DeleteOperationMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return DeleteOperationMock.class;
    }

    @Test
    public void testDeletesRootElement() {
        BasicElementInfoBuilder basicElementInfoBuilder = basicElementInfoWith("test");
        DeleteOperation deleteOperation = build(deleteOperationWith().deletesRootElement(() -> basicElementInfoBuilder));
        BasicElementInfo basicElementInfo = build(basicElementInfoBuilder);
        assertThat(deleteOperation.getDeleteRootElement(), is(basicElementInfo));
    }
}
