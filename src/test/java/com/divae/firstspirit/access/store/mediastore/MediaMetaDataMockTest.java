package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.mediastore.MediaMetaData;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.mediastore.MediaMetaDataMock.mediaMetaDataWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MediaMetaDataMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return MediaMetaDataMock.class;
	}

	@Test
	public void testAnExtension() {
		String extension = "test";
		MediaMetaData mediaMetaData = build(mediaMetaDataWith().anExtension(extension));
		assertThat(mediaMetaData.getExtension(), is(extension));
	}

	@Test
	public void testACrc() {
		long crc = 0;
		MediaMetaData mediaMetaData = build(mediaMetaDataWith().aCrc(crc));
		assertThat(mediaMetaData.getCrc(), is(crc));
	}
}
