import org.junit.Test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class CheckTest {
    @Test
    public void isInt() throws MyException{
        assertTrue(Check.isInt(10, 9, 12));
    }

    @Test
    public void isInt1() throws MyException{
        assertTrue(Check.isInt(11, 9, 12, 10));
    }

    @Test(expected = MyException.class)
    public void smartInput() throws MyException{
        Check.smartInput(new Scanner("t"));
    }
}