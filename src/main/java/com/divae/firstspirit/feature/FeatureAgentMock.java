package com.divae.firstspirit.feature;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.ServerActionHandleMock.ServerActionHandleBuilder;
import com.divae.firstspirit.feature.FeatureDescriptorMock.FeatureDescriptorBuilder;
import com.divae.firstspirit.feature.FeatureFileMock.FeatureFileBuilder;
import com.divae.firstspirit.feature.FeatureModelMock.FeatureModelBuilder;
import de.espirit.firstspirit.access.ServerActionHandle;
import de.espirit.firstspirit.feature.FeatureAgent;
import de.espirit.firstspirit.feature.FeatureDescriptor;
import de.espirit.firstspirit.feature.FeatureModel;
import de.espirit.firstspirit.feature.FeatureProgress;
import de.espirit.firstspirit.storage.Revision;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class FeatureAgentMock {

	private FeatureAgentMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static FeatureAgentBuilder featureAgentWith() {
		return new DefaultFeatureAgentBuilder();
	}

	public interface FeatureAgentBuilder extends Builder<FeatureAgent, FeatureAgentBuilder> {
		FeatureAgentBuilder createsFeature(Supplier<FeatureDescriptorBuilder> supplier, String name, Revision revision, boolean release);

		FeatureAgentBuilder createsFeatureModel(Supplier<FeatureModelBuilder> supplier, FeatureDescriptorBuilder featureDescriptor);

		<T extends FeatureProgress> FeatureAgentBuilder createsFeatureTransportFile(Supplier<ServerActionHandleBuilder<? extends FeatureProgress, Boolean>> supplier, FeatureDescriptorBuilder featureDescriptor);

		FeatureAgentBuilder aDownloadFeatureFile(InputStream inputStream, FeatureFileBuilder featureFile) throws IOException;
	}

	public static final class DefaultFeatureAgentBuilder extends DefaultBuilder<FeatureAgent, FeatureAgentBuilder, DefaultFeatureAgentBuilder> implements FeatureAgentBuilder {

		private DefaultFeatureAgentBuilder() {
		}

		@Override
		public final FeatureAgentBuilder createsFeature(Supplier<FeatureDescriptorBuilder> supplier, String name, Revision revision, boolean release) {
			FeatureDescriptor featureDescriptor = build(supplier.get());
			when(getBuildable().createFeature(name, revision, release)).thenReturn(featureDescriptor);
			return getBuilder();
		}

		@Override
		public final FeatureAgentBuilder createsFeatureModel(Supplier<FeatureModelBuilder> supplier, FeatureDescriptorBuilder featureDescriptor) {
			FeatureModel featureModel = build(supplier.get());
			when(getBuildable().createFeatureModel(getBuildable(featureDescriptor))).thenReturn(featureModel);
			return getBuilder();
		}

		@Override
		public final <T extends FeatureProgress> FeatureAgentBuilder createsFeatureTransportFile(Supplier<ServerActionHandleBuilder<? extends FeatureProgress, Boolean>> supplier, FeatureDescriptorBuilder featureDescriptor) {
			ServerActionHandle<? extends FeatureProgress, Boolean> serverActionHandle = build(supplier.get());
			Mockito.<ServerActionHandle<? extends FeatureProgress, Boolean>>when(getBuildable().createFeatureTransportFile(getBuildable(featureDescriptor))).thenReturn(serverActionHandle);
			return getBuilder();
		}

		@Override
		public final FeatureAgentBuilder aDownloadFeatureFile(InputStream inputStream, FeatureFileBuilder featureFile) throws IOException {
			when(getBuildable().downloadFeatureFile(getBuildable(featureFile))).thenReturn(inputStream);
			return getBuilder();
		}

	}
}
