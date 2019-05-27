import org.junit.Test;

import static org.junit.Assert.*;

public class TrapeziumTest {

    @Test
    public void calculateSquare() {
        final Trapezium trapezium = new Trapezium(0.2,0.1,1.2);
        trapezium.run();
        assertEquals(0.13, trapezium.getResult(),0.001);
    }
}