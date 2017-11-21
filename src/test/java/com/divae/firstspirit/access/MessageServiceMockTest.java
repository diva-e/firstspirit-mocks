package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;

public class MessageServiceMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return MessageServiceMock.class;
    }

}
