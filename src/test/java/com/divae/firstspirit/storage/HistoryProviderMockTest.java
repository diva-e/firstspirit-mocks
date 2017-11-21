package com.divae.firstspirit.storage;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.storage.HistoryProvider;
import de.espirit.firstspirit.storage.Revision;
import org.junit.Test;

import java.util.List;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.storage.HistoryProviderMock.historyProviderWith;
import static com.divae.firstspirit.storage.RevisionMock.revisionWith;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class HistoryProviderMockTest extends MockTest {

    @Test
    public void testHistoryProviderWithHistoryProvider() {
        assertThat(historyProviderWith(historyProviderWith()), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return HistoryProviderMock.class;
    }

    @Test
    public void testAHistory() {
        HistoryProvider historyProvider = build(historyProviderWith().aHistory(() -> singletonList(revisionWith(1L))));
        List<Revision> revisions = historyProvider.getHistory();
        assertThat(revisions.size(), is(1));
        assertThat(revisions.get(0).getId(), is(1L));
    }
}
