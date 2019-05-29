import org.junit.Test;

import static org.junit.Assert.*;

public class IntegralTest {

    @Test
    public void addTrapezium() {
        final Integral integral = new Integral(1,10,12, 0);
        integral.run();
        assertEquals(0.835, integral.getResult(),0.001);
    }
}