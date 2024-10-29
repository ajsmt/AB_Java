package AB.Sweets;
import java.text.ParseException;

public class ChocolateBar extends Candy{
    private chocolateType type;
    private boolean hasNuts;

    public ChocolateBar(String name, double sugarAmount, double price, double weight, chocolateType type, boolean hasNuts) {
        super(name, sugarAmount, price, weight);
        this.type = type;
        this.hasNuts = hasNuts;
    }
    public chocolateType getType() {
        return type;
    }


    public boolean isHasNuts() {
        return hasNuts;
    }

    @Override
    public String toString() {
        return "c; " + super.toString() + ", " + type + ", " + hasNuts;
    }

    public enum chocolateType {
        WHITE,
        BLACK,
        MILK
    }

    public static ChocolateBar parseCandy(String line) throws Exception {
        String[] tokens = line.split(",");
        if (tokens.length!=6) {
            throw new ParseException("Invalid line format", 0);
        }
        String name = tokens[0].trim();
        double sugar = Double.parseDouble(tokens[1].trim());
        double price = Double.parseDouble(tokens[2].trim());
        double weight = Double.parseDouble(tokens[3].trim());
        String typeString = tokens[4].trim();
        chocolateType type = chocolateType.valueOf(typeString);
        boolean hasNuts = Boolean.parseBoolean(tokens[5].trim());
        return new ChocolateBar(name, sugar, price, weight, type, hasNuts);
    }
}