package com.divae.firstspirit.access.store;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.Permission;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.PermissionMock.permissionWith;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PermissionMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return PermissionMock.class;
    }

    @Test
    public void testWithSeePermission() {
        Permission permission = build(permissionWith().aSeePermission(true));
        assertThat(permission.canSee(), is(TRUE));
    }

    @Test
    public void testWithReadPermission() {
        Permission permission = build(permissionWith().aReadPermission(true));
        assertThat(permission.canRead(), is(TRUE));
    }

    @Test
    public void testWithReleasePermission() {
        Permission permission = build(permissionWith().aReleasePermission(true));
        assertThat(permission.canRelease(), is(TRUE));
    }
}
