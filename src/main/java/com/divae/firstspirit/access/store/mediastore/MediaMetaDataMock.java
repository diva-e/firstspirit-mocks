package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.BuilderMock.Builder;
import de.espirit.firstspirit.access.store.mediastore.MediaMetaData;

public final class MediaMetaDataMock {

	private MediaMetaDataMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static MediaMetaDataBuilder mediaMetaDataWith() {
		return new DefaultMediaMetaDataBuilder();
	}

	public interface MediaMetaDataBuilder extends Builder<MediaMetaData, MediaMetaDataBuilder> {
		MediaMetaDataBuilder anExtension(String extension);

		MediaMetaDataBuilder aCrc(long crc);
	}

	public static final class DefaultMediaMetaDataBuilder implements MediaMetaDataBuilder {

		private MediaMetaData mediaMetaData;

		private DefaultMediaMetaDataBuilder() {
			mediaMetaData = new MediaMetaData(0, 0, 0, null, null, 0, null);
		}

		public final MediaMetaDataBuilder anExtension(String extension) {
			mediaMetaData = new MediaMetaData(mediaMetaData.getHeight(), mediaMetaData.getWidth(), mediaMetaData.getSize(), extension, mediaMetaData.getRevision(),
					mediaMetaData.getCrc(), mediaMetaData.getMimeType());
			return this;
		}

		public final MediaMetaDataBuilder aCrc(long crc) {
			mediaMetaData = new MediaMetaData(mediaMetaData.getHeight(), mediaMetaData.getWidth(), mediaMetaData.getSize(), mediaMetaData.getExtension(),
					mediaMetaData.getRevision(), crc, mediaMetaData.getMimeType());
			return this;
		}
	}

	public static MediaMetaData getBuildabel(Builder<MediaMetaData, MediaMetaDataBuilder> builder) {
		return builder instanceof DefaultMediaMetaDataBuilder ? ((DefaultMediaMetaDataBuilder) builder).mediaMetaData : null;
	}
}
