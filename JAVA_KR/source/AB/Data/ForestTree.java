package AB.Data;

public class ForestTree extends Tree {
    private double woodQuantity;
    private static final double COEFFICIENT = 0.9;

    public ForestTree(String name, int age, TreeType type, double woodQuantity) {
        super(name, age, type);
        this.woodQuantity = woodQuantity;
    }

    public double getWoodQuantity() {
        return woodQuantity;
    }

    public void setWoodQuantity(double woodQuantity) {
        this.woodQuantity = woodQuantity;
    }

    @Override
    public double calculateEconomicEfficiency() {
        return woodQuantity * COEFFICIENT;
    }

    @Override
    public String toString() {
        return super.toString() + " " + woodQuantity;
    }

    @Override
    public int compareTo(Tree other) {
        ForestTree otherTree = (ForestTree) other;
        int baseComare = super.compareTo(other);
        if (baseComare == 0) {
            double woodQuantityCompare = woodQuantity - otherTree.woodQuantity;
            if (Math.abs(woodQuantityCompare) <= 0.0001) {
                return 0;
            } else if (woodQuantityCompare < 0) {
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
        if (tempTree instanceof ForestTree) {
            ForestTree otherTree = (ForestTree) tempTree;
            int compareResult = compareTo(otherTree);
            return compareResult;
        } else {
            throw new IllegalArgumentException("Invalid comparison with ForestTree");
        }
    }

    public static ForestTree parseForestTree(String line){
        String[] fields = line.split(" ");
        if (fields.length!=4) {
            throw new IllegalArgumentException("Invalid format for ForestTree");
        }
        String name = fields[0].trim();
        int age = Integer.parseInt(fields[1].trim());
        TreeType type = TreeType.valueOf(fields[2].trim());
        double woodQuantity = Double.parseDouble(fields[3].trim());
        return new ForestTree(name, age, type, woodQuantity);
    }
}
