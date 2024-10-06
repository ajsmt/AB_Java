import java.io.BufferedWriter;
import java.io.FileWriter;

abstract class Series{
    protected double firstElement;
    protected double difference;

    public Series(double firstElement, double difference) {
        this.firstElement = firstElement;
        this.difference = difference;
    }
    abstract double getJthElement(int j);
    public double getSum(int n) {
        double sum = 0;
        for(int i = 1; i <= n; i++){
            sum += getJthElement(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        return toString(10);
    }
    public String toString(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) 
            sb.append(String.format("%.3f", getJthElement(i))).append(" ");
        return sb.toString();
    }

    public void writeToFile(String file){
        writeToFile(file, 10);
    }
    public void writeToFile(String file, int n){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(this.toString(n));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}