package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.templatestore.ChannelSourceProviderMock.ChannelSourceProviderBuilder;
import org.junit.Test;

import static com.divae.firstspirit.access.store.templatestore.ChannelSourceProviderMock.channelSourceProviderWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ChannelSourceProviderMockTest extends MockTest {

    @Test
    public void testChannelSourceProviderWith() {
        ChannelSourceProviderBuilder channelSourceProviderBuilder = channelSourceProviderWith("test", 2, null);
        assertThat(channelSourceProviderBuilder, is(notNullValue()));
    }

    @Test
    public void testChannelSourceProviderWithUidType() {
        ChannelSourceProviderBuilder channelSourceProviderBuilder = channelSourceProviderWith("test", 2, TEMPLATESTORE, null);
        assertThat(channelSourceProviderBuilder, is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return ChannelSourceProviderMock.class;
    }

}
