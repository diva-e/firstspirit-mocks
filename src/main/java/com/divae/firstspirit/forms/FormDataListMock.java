package com.divae.firstspirit.forms;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.editor.FormDataProducerMock.FormDataProducerBuilder;
import com.divae.firstspirit.access.editor.fslist.IdProvidingFormDataMock.IdProvidingFormDataBuilder;
import de.espirit.firstspirit.access.editor.FormDataProducer;
import de.espirit.firstspirit.access.editor.fslist.IdProvidingFormData;
import de.espirit.firstspirit.forms.FormDataList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static java.util.stream.Collectors.toList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public final class FormDataListMock {

    private FormDataListMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static FormDataListBuilder formDataListWith() {
        return new DefaultFormDataListBuilder();
    }

    public interface FormDataListBuilder extends Builder<FormDataList, FormDataListBuilder> {
        FormDataListBuilder values(Supplier<List<IdProvidingFormDataBuilder>> supplier);

        <T extends FormDataProducer, TBUILDER extends FormDataProducerBuilder<T, TBUILDER>> FormDataListBuilder aProducer(Supplier<TBUILDER> supplier);
    }

    public static final class DefaultFormDataListBuilder extends DefaultBuilder<FormDataList, FormDataListBuilder, DefaultFormDataListBuilder> implements FormDataListBuilder {

        private final List<IdProvidingFormData> formData = new ArrayList<>();

        private DefaultFormDataListBuilder() {
            mockList();

            when(getBuildable().get(anyInt())).thenAnswer(invocation -> {
                int index = invocation.getArgument(0);
                if (getBuildable().isEmpty() || getBuildable().size() < index) {
                    throw new IndexOutOfBoundsException();
                }
                return formData.get(index);
            });

            when(getBuildable().add(any(IdProvidingFormData.class))).thenAnswer(invocation -> {
                IdProvidingFormData idProvidingFormData = invocation.getArgument(0);
                boolean added = formData.add(idProvidingFormData);
                mockList();
                return added;
            });

            doAnswer(invocation -> {
                formData.clear();
                mockList();
                return null;
            }).when(getBuildable()).clear();
        }

        @Override
        public final FormDataListBuilder values(Supplier<List<IdProvidingFormDataBuilder>> supplier) {
            List<IdProvidingFormData> formData = supplier.get().stream().map(BuilderMock::build).collect(toList());
            this.formData.addAll(formData);

            mockList();

            for (int i = 0; i < this.formData.size(); i++) {
                getBuildable().get(i);
            }

            return getBuilder();
        }

        private void mockList() {
            when(getBuildable().iterator()).thenReturn(formData.iterator());
            when(getBuildable().isEmpty()).thenReturn(formData.isEmpty());
            when(getBuildable().size()).thenReturn(formData.size());
        }

        @Override
        public final <T extends FormDataProducer, TBUILDER extends FormDataProducerBuilder<T, TBUILDER>> FormDataListBuilder aProducer(Supplier<TBUILDER> supplier) {
            T producer = build(supplier.get());
            when(getBuildable().getProducer()).thenReturn(producer);
            return getBuilder();
        }
    }
}
