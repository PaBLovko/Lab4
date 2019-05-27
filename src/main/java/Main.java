import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws MyException{
        ArrayList<Integer> arrayListChoose = new ArrayList<Integer>();
        ArrayList<Integer> arrayListX1 = new ArrayList<Integer>();
        ArrayList<Integer> arrayListX2 = new ArrayList<Integer>();
        ExecutorService executor = Executors.newFixedThreadPool(8);

        int choose, x1, x2, endCycle;
        do {
            log.info("Choose:\n 1) f(x) = 1/ln(x)\n 2) f(x) = 7/(x^2+1)\n 3) f(x) = sin(x+1)\n Для выхода введите любой символ");

            Scanner in = new Scanner(System.in);

            try {
                do {
                    choose = in.nextInt();
                } while (!Check.isInt(choose, 1, 4));

                log.info("Input limits x1, x2 (-100000 .. 100000)");
                do {
                    x1 = in.nextInt();
                } while (!Check.isInt(x1, -100000, 100000));

                do {
                    x2 = in.nextInt();
                } while (!Check.isInt(x2, -100000, 100000, x1));
            } catch (InputMismatchException e) {
                throw new MyException("\nБыл введен символ. Выход.\n", ErrorCode.ErrorCheck);
            }

            arrayListChoose.add(choose);
            arrayListX1.add(x1);
            arrayListX2.add(x2);

            log.info("Продолжить добавление? Да - 1 Нет - 2");
            do {
                endCycle = in.nextInt();
            } while (!Check.isInt(endCycle, 1, 2));
        } while (endCycle != 2);

        for(int j=0; j < arrayListChoose.size(); j++) {
            executor.execute(new Integral(arrayListChoose.get(j), arrayListX1.get(j), arrayListX2.get(j), j));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(arrayListChoose.size(), TimeUnit.SECONDS);
        } catch (InterruptedException e) { throw new MyException("Время ожидание превышенно!", ErrorCode.ErrorCheck);}
    }
}
