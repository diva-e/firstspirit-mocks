package com.divae.firstspirit.access.editor;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.templatestore.TableTemplateMock.TableTemplateBuilder;
import de.espirit.firstspirit.access.editor.TableTemplateProvider;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.editor.OptionModelAndTableTemplateProviderMock.optionModelAndTableTemplateProviderWith;
import static com.divae.firstspirit.access.store.templatestore.TableTemplateMock.tableTemplateWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OptionModelAndTableTemplateProviderMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return OptionModelAndTableTemplateProviderMock.class;
    }

    @Test
    public void aTableTemplate() throws Exception {
        TableTemplateBuilder tableTemplate = tableTemplateWith("uid", 1, TEMPLATESTORE, null);
        TableTemplateProvider tableTemplateProvider = build(optionModelAndTableTemplateProviderWith().aTableTemplate(tableTemplate));
        assertThat(tableTemplateProvider.getTableTemplate(), is(build(tableTemplate)));
    }
}