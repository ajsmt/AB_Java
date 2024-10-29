package AB.Sweets;
abstract public class Candy {
    private String name;
    private double sugarAmount;
    private double price;
    private double weight;

    public Candy(String name, double sugarAmount, double price, double weight) {
        this.name = name;
        this.sugarAmount = sugarAmount;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getSugarAmount() {
        return sugarAmount;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + ", " + sugarAmount + ", " + price + ", " + weight;
    }
}
