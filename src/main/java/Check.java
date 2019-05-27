import java.util.logging.Level;
import java.util.logging.Logger;

public class Check {
    private static java.util.logging.Logger log = Logger.getLogger(Main.class.getName());

    public static boolean isInt(int integer, int limitLeft, int limitRight) throws MyException
    {
        try {
            if (integer >= limitLeft && integer <= limitRight)
                return true;
            else
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new MyException("\\nПроверьте правильность ввода.\\nМожете повторить попытку.",ErrorCode.ErrorCheck);
        }
    }

    public static boolean isInt(int integer, int limitLeft, int limitRight, int x1) throws MyException
    {
        try {
            if(x1 < integer)
                return Check.isInt(integer,limitLeft,limitRight);
            else
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new MyException("\\nВторой предел должен быть больше первого.\\nМожете повторить попытку.",ErrorCode.ErrorCheck);
        }
    }
}
