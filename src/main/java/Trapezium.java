public class Trapezium extends Thread {
    private double width;
    private double leftHeight;
    private double rightHeight;
    private double result;

    public Trapezium(double width, double leftHeight, double rightHeight){
        this.width = width;
        this.leftHeight = leftHeight;
        this.rightHeight = rightHeight;
        start();
    }

    @Override
    public void run() {
        result = calculateSquare();
    }

    public double calculateSquare(){
        return (leftHeight+rightHeight)/2*width;
    }

    public double getResult() { return result; }
}