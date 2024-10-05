public class Main {
    public static void main(String[] args){
        Linear linear = new Linear(1, 3);
        System.out.println("Linear : " + linear.toString());
        System.out.println("Sum of 15 : " + linear.getSum(15));
        linear.writeToFile("linear.txt");
        System.out.println("-------------");
        Exponential exponential = new Exponential(15, 0.3);
        System.out.println("Exponential : " + exponential.toString());
        System.out.println("Sum of 15 : " + exponential.getSum(15));
        exponential.writeToFile("exponential.txt");
    }
}
