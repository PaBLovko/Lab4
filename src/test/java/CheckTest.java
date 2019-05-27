import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class CheckTest {
    private static Logger log = Logger.getLogger(CheckTest.class.getName());

    @Test
    public void isInt() {
        try {
            assertTrue(Check.isInt(10, 9, 12));
        }catch (MyException e) {log.log(Level.SEVERE, "Exception: ", e);}
    }

    @Test
    public void isInt1() {
        try {
            assertTrue(Check.isInt(11, 9, 12, 10));
        }catch (MyException e) {log.log(Level.SEVERE, "Exception: ", e);}
    }
}