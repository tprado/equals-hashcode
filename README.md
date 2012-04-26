equals-hashcode
===============

Using JUnit Theories to test Equals and hashCode contract.

The idea is to minimize the effort to test equals/hashCode by providing samples. One set of objects should be
considered equal among themselves and another set that should be considered not equal.

Example
-------

    public class SampleTest extends EqualsAndHashCode {

        @DataPoints
        public static SameObjectBuilder[] sameObjects = new SameObjectBuilder[] {
            new SameObjectBuilder() {
                @Override
                public Object newInstance() {
                    return new Integer(5);
                }
            }
        };

        @DataPoints
        public static Object[] differentObjects = new Object[] {
            new Integer(5),
            new Integer(7)
        };
    }
