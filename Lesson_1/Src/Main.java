public class Main {
    public static void main(String[] args) {
        double x = 0.5;
        double eps = 1e-5;
        if (args.length == 0) {
            System.err.println("There must be at least one argument");
            System.exit(1);
        }
    
        try {
            x = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Error: First argument must be a double.");
            System.exit(1);
        }
    
        if (args.length == 2) {
            try {
                eps = Double.parseDouble(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Error: Second argument must be a double.");
                System.exit(1);
            }
        }
        
        System.out.println(CalculateSum(x, eps));
    }

    public static double CalculateSum(double x, double Eps) {
        double X0 = x * x * x;
        int Power = 3;
        int k = 1;
        double Sum = X0;
        while (Math.abs(X0) >= Eps) {
            k++;
            int NewPower = 3 * k * k;
            double X1 = X0;
            for (int i = 0; i < NewPower - Power; i++) {
                X1 *= x;
            }
            Sum += X1;
            X0 = X1;
            Power = NewPower;
        }
        return Sum;
    }
}