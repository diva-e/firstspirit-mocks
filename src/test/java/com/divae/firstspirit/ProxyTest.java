package com.divae.firstspirit;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.divae.firstspirit.Proxy.with;
import static java.lang.reflect.Modifier.PRIVATE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProxyTest {

    @Test(expected = InvocationTargetException.class)
    public void testDefaultConstructor() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor<?> declaredConstructor = Proxy.class.getDeclaredConstructor();
        assertThat(declaredConstructor.getModifiers(), is(PRIVATE));
        declaredConstructor.setAccessible(true);
        declaredConstructor.newInstance();
    }

    @Test
    public void aTargetClass() throws Exception {
        TestInterface test = () -> "test";
        assertThat(Proxy.<TestInterface, Test2Interface>proxy(with(test, TestInterface.class).aTarget(Test2Interface.class)).getTest(), is("test"));
    }

    @Test
    public void aTargetTClass() throws Exception {
        TestInterface test = () -> "test";

        Test2Interface target = () -> "targetTest";

        assertThat(Proxy.<TestInterface, Test2Interface>proxy(with(test, TestInterface.class).aTarget(target, Test2Interface.class)).getTest(), is("test"));
        assertThat(Proxy.<Test2Interface, TestInterface>proxy(with(target, Test2Interface.class).aTarget(TestInterface.class)).getTest(), is("targetTest"));
    }

    interface TestInterface {
        String getTest();
    }

    interface Test2Interface {
        String getTest();
    }
}