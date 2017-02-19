package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.mediastore.File;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.mediastore.FileMock.fileWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class FileMockTest extends MockTest {

	@Test
	public void testFileWith() {
		assertThat(fileWith("file", null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return FileMock.class;
	}

	@Test
	public void testAnInputStream() throws IOException {
		InputStream stream = mock(InputStream.class);
		File file = build(fileWith("file", null).anInputStream(stream));
		assertThat(file.getInputStream(), is(stream));
	}

	@Test
	public void testACrc() throws IOException {
		long crc = 0;
		File file = build(fileWith("file", null).aCrc(crc));
		assertThat(file.getCrc(), is(crc));
	}

	@Test
	public void testAnExtension() {
		String extension = "css";
		File file = build(fileWith("file", null).anExtension(extension));
		assertThat(file.getExtension(), is(extension));
	}
}
