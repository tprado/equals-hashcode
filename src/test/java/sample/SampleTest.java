package sample;

import lang.EqualsAndHashCode;
import org.junit.experimental.theories.DataPoints;

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
