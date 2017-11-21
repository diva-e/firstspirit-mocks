package com.divae.firstspirit.access.editor;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.templatestore.TableTemplateMock.TableTemplateBuilder;
import de.espirit.firstspirit.access.editor.TableTemplateProvider;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.editor.TableTemplateProviderMock.tableTemplateProviderWith;
import static com.divae.firstspirit.access.store.templatestore.TableTemplateMock.tableTemplateWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class TableTemplateProviderMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return TableTemplateProviderMock.class;
    }

    @Test
    public void aTableTemplate() throws Exception {
        TableTemplateBuilder tableTemplate = tableTemplateWith("uid", 1, TEMPLATESTORE, null);
        TableTemplateProvider tableTemplateProvider = build(tableTemplateProviderWith().aTableTemplate(tableTemplate));
        assertThat(tableTemplateProvider.getTableTemplate(), is(build(tableTemplate)));
    }
}