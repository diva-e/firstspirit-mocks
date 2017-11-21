package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.project.ResolutionMock.ResolutionBuilder;
import de.espirit.firstspirit.access.project.Resolution;
import de.espirit.firstspirit.access.store.mediastore.Picture;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.project.ResolutionMock.resolutionWith;
import static com.divae.firstspirit.access.store.mediastore.PictureMock.pictureWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class PictureMockTest extends MockTest {

    @Test
    public void testPictureWith() {
        assertThat(pictureWith("picture", null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return PictureMock.class;
    }

    @Test
    public void testAnInputStream() throws IOException {
        InputStream stream = mock(InputStream.class);
        ResolutionBuilder resolutionBuilder = resolutionWith("test");
        Picture picture = build(pictureWith("picture", null).anInputStream(stream, resolutionBuilder));
        Resolution resolution = build(resolutionBuilder);
        assertThat(picture.getInputStream(resolution), is(stream));
    }
}
