package com.divae.firstspirit.or.query;

import com.divae.firstspirit.MockTest;
import de.espirit.or.query.Select;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.or.query.SelectMock.selectWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SelectMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return SelectMock.class;
	}

	@Test
	public void testAConstraint() {
		Select select = build(selectWith().aConstraint(ConstraintMock::constraintWith));
		assertThat(select.getConstraint(), is(notNullValue()));
	}

	@Test
	public void testCloneSelect() {
		Select select = build(selectWith().aConstraint(ConstraintMock::constraintWith));
		assertThat(select.clone().getConstraint(), is(notNullValue()));
	}
}
