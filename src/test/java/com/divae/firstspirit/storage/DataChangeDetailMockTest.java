package com.divae.firstspirit.storage;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.storage.DataChangeDetail;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.storage.DataChangeDetailMock.dataChangeDetailWith;
import static de.espirit.firstspirit.storage.DataChangeDetail.ChangeFlag.ADDED;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DataChangeDetailMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return DataChangeDetailMock.class;
    }

    @Test
    public void testAChangeFlag() {
        DataChangeDetail dataChangeDetail = build(dataChangeDetailWith().aChangeFlag(ADDED));
        assertThat(dataChangeDetail.getChangeFlag(), is(ADDED));
    }


}
