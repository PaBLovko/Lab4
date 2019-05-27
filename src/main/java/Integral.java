import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Math.*;

public class Integral implements Runnable{
    private static Logger log = Logger.getLogger(Integral.class.getName());

    private int formula;
    private int x1,x2;
    private int index;
    private double result = 0;

    public Integral(int formula, int x1, int x2, int index) {
        this.formula = formula;
        this.x1 = x1;
        this.x2 = x2;
        this.index = index;
    }

    public void run(){
        switch(formula){
            case 1: {
                for(int i = x1; i < x2 ; i++) {
                    double y1, y2;
                    y1 = 1/(log(i));
                    y2 = 1/(log(i+1));
                    result+=addTrapezium(1, y1,y2);
                }
                log.info("result: " + this.index+ " :" + this.getResult());
                break;
            }
            case 2: {
                for(int i = x1; i < x2; i++) {
                    double y1, y2;
                    y1 = 7/(pow(i,2)+1);
                    y2 = 7/(pow(i+1,2)+1);
                    result += addTrapezium(1, y1, y2);
                }
                log.info("result: "+ this.index+ " :" + this.getResult());
                break;
            }
            case 3: {
                for(int i = x1; i < x2; i++) {
                    double y1, y2;
                    y1 = sin(i+1);
                    y2 = sin(i+2);
                    result += addTrapezium(1, y1, y2);
                }
               log.info("result "+ this.index+ " :" + this.getResult());
                break;
            }
            default: { break; }
        }
    }

    public double getResult(){
        return result;
    }

    public double addTrapezium(double width, double leftHeight, double rightHeight){
        Trapezium trapezium = new Trapezium(width, leftHeight, rightHeight);
        try{
            trapezium.join();
        } catch (InterruptedException e) {log.log(Level.SEVERE, "Ошибка в потоках трапеции", e);}
        return trapezium.getResult();
    }
}
