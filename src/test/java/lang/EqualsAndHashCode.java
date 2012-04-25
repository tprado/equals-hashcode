package lang; 

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public abstract class EqualsAndHashCode {

    public static interface SameObjectBuilder {
        Object newInstance();
    }

    @Theory
    public void sameObjectBuilderShouldNotReturnSameInstance(SameObjectBuilder sameObject) {
        assertThat(sameObject.newInstance() == sameObject.newInstance(), is(false));
    }

    @Theory
    public void anyObjectShouldBeEqualToNull(SameObjectBuilder sameObject) {
        anyObjectShouldBeEqualToNull(sameObject.newInstance());
    }

    @Theory
    public void anyObjectShouldBeEqualToNull(Object o) {
        assertThat(o.equals(null), is(false));
    }

    @Theory
    public void equalsShouldBeReflexive(SameObjectBuilder sameObject) {
        equalsShouldBeReflexive(sameObject.newInstance());
    }

    @Theory
    public void equalsShouldBeReflexive(Object o) {
        assertThat(o.equals(o), is(true));
    }

    @Theory
    public void equalsShouldBeSymmetric(SameObjectBuilder sameObject) {
        Object o1 = sameObject.newInstance();
        Object o2 = sameObject.newInstance();

        assertThat(o1.equals(o2), is(true));
        assertThat(o2.equals(o1), is(true));
    }

    @Theory
    public void equalsShouldBeSymmetric(Object o1, Object o2) {
        assumeThat(o1 == o2 , is(false));

        assertThat(o1.equals(o2), is(false));
        assertThat(o2.equals(o1), is(false));
    }

    @Theory
    public void equalsShouldBeTransitive(SameObjectBuilder sameObject) {
        Object o1 = sameObject.newInstance();
        Object o2 = sameObject.newInstance();
        Object o3 = sameObject.newInstance();

        assertThat(o1.equals(o2), is(true));
        assertThat(o2.equals(o3), is(true));
        assertThat(o1.equals(o3), is(true));
    }

    @Theory
    public void equalsShouldBeTransitive(Object o1, Object o2, Object o3) {
        assumeThat(o1 == o2, is(false));
        assumeThat(o2 == o3, is(false));
        assumeThat(o1 == o3, is(false));

        assertThat(o1.equals(o2), is(false));
        assertThat(o2.equals(o3), is(false));
        assertThat(o1.equals(o3), is(false));
    }

    @Theory
    public void equalsShouldBeConsistent(SameObjectBuilder sameObject) {
        Object o1 = sameObject.newInstance();
        Object o2 = sameObject.newInstance();

        assertThat(o1.equals(o2), is(true));
        assertThat(o1.equals(o2), is(true));
    }

    @Theory
    public void equalsShouldBeConsistent(Object o1, Object o2) {
        assumeThat(o1 == o2, is(false));

        assertThat(o1.equals(o2), is(false));
        assertThat(o1.equals(o2), is(false));
    }

    @Theory
    public void sameObjectsShouldHaveSameHashCodes(SameObjectBuilder sameObject) {
        Object o1 = sameObject.newInstance();
        Object o2 = sameObject.newInstance();

        int h1 = o1.hashCode();
        int h2 = o2.hashCode();

        assertThat(h1, is(equalTo(h2)));
    }

    @Theory
    public void hashCodeShouldBeConsistent(SameObjectBuilder sameObject) {
        Object o = sameObject.newInstance();

        hashCodeShouldBeConsistent(o);
    }

    @Theory
    public void hashCodeShouldBeConsistent(Object o) {
        int h1 = o.hashCode();
        int h2 = o.hashCode();

        assertThat(h1, is(equalTo(h2)));
    }
}
