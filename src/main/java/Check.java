import java.util.InputMismatchException;
import java.util.Scanner;

public class Check {

    public static boolean isInt(int integer, int limitLeft, int limitRight) throws MyException
    {
        if (integer >= limitLeft && integer <= limitRight){
            return true;
        }
        else {
            throw new MyException("\\nПроверьте правильность ввода.\\nМожете повторить попытку.", ErrorCode.ErrorLimit);
        }
    }

    public static boolean isInt(int integer, int limitLeft, int limitRight, int x1) throws MyException
    {
        if(x1 < integer){
            return Check.isInt(integer,limitLeft,limitRight);
        }
        else{
            throw new MyException("\\nВторой предел должен быть больше первого.\\nМожете повторить попытку.",ErrorCode.ErrorLimit);
        }
    }

    public static int smartInput(Scanner input) throws MyException{
        try {
            return input.nextInt();
        }catch (InputMismatchException e) {throw new MyException("\nБыл введен символ. Выход.\n", ErrorCode.ErrorLimit);}
    }
}
