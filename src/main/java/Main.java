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
        ArrayList<Integer> arrayListChoose = new ArrayList<>();
        ArrayList<Integer> arrayListX1 = new ArrayList<>();
        ArrayList<Integer> arrayListX2 = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(8);

        int choose, x1, x2, endCycle;
        Scanner in = new Scanner(System.in);
        do {
            log.info("Choose:\n 1) f(x) = 1/ln(x)\n 2) f(x) = 7/(x^2+1)\n 3) f(x) = sin(x+1)\n Для выхода введите любой символ");

            do {
                choose = Check.smartInput(in);
            } while (!Check.isInt(choose, 1, 4));

            log.info("Input limits x1, x2 (-100000 .. 100000)");
            do {
                x1 = Check.smartInput(in);
            } while (!Check.isInt(x1, -100000, 100000));

            do {
                x2 = Check.smartInput(in);
            } while (!Check.isInt(x2, -100000, 100000, x1));


            arrayListChoose.add(choose);
            arrayListX1.add(x1);
            arrayListX2.add(x2);

            log.info("Продолжить добавление? Да - 1 Нет - 2");
            do {
                endCycle = Check.smartInput(in);
            } while (!Check.isInt(endCycle, 1, 2));
        } while (endCycle != 2);

        for(int j=0; j < arrayListChoose.size(); j++) {
            executor.execute(new Integral(arrayListChoose.get(j), arrayListX1.get(j), arrayListX2.get(j), j));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(arrayListChoose.size(), TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) { throw new MyException("Время ожидание превышенно!", ErrorCode.ErrorLimit);}
    }
}
