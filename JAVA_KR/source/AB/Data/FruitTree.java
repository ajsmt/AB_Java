package AB.Data;

public class FruitTree extends Tree {
    private double fruitsMass;
    private double averageTime;
    private static final double COEFFICIENT = 0.4;

    public FruitTree(String name, int age, TreeType type, double fruitsMass, double averageTime) {
        super(name, age, type);
        this.fruitsMass = fruitsMass;
        this.averageTime = averageTime;
    }

    public void setFruitsMass(double fruitsMass) {
        this.fruitsMass = fruitsMass;
    }

    public double getFruitsMass() {
        return fruitsMass;
    }

    public void setAverageTime(double averageTime) {
        this.averageTime = averageTime;
    }

    public double getAverageTime() {
        return averageTime;
    }

    @Override
    public double calculateEconomicEfficiency() {
        return getAge() * fruitsMass * COEFFICIENT / averageTime;
    }

    @Override
    public String toString() {
        return super.toString() + " " + fruitsMass + " " + averageTime;
    }

    @Override
    public int compareTo(Tree other) {
        FruitTree otherTree = (FruitTree) other;
        int baseComare = super.compareTo(other);
        if (baseComare == 0) {
            double fruitsMassCompare = fruitsMass - otherTree.getFruitsMass();
            if (Math.abs(fruitsMassCompare) <= 0.0001) {
                double averageTimeCompare = averageTime - otherTree.getFruitsMass();
                if (Math.abs(averageTimeCompare) <= 0.0001) {
                    return 0;
                } else if (averageTimeCompare < 0) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (fruitsMassCompare < 0) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return baseComare;
        }
    }

    @Override
    public int getComparison(Tree tempTree) {
        if (tempTree instanceof FruitTree) {
            FruitTree otherTree = (FruitTree) tempTree;
            int compareResult = compareTo(otherTree);
            return compareResult;
        } else {
            throw new IllegalArgumentException("Invalid comparison with FruitTree");
        }
    }

    public static FruitTree parseFruitTree(String line) {
        String[] values = line.split(" ");
        if (values.length != 5) {
            throw new IllegalArgumentException("Invalid format for FruitTree");
        }
        String name = values[0];
        int age = Integer.parseInt(values[1]);
        TreeType type = TreeType.valueOf(values[2]);
        double fruitsMass = Double.parseDouble(values[3]);
        double averageTime = Double.parseDouble(values[4]);
        return new FruitTree(name, age, type, fruitsMass, averageTime);
    }
}
