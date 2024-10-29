package AB.Sweets;
import java.text.ParseException;

public class Lollipop extends Candy {
    private Color color;

    public Lollipop(String name, double sugarAmount, double price, double weight, Color color) {
        super(name, sugarAmount, price, weight);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "l; " + super.toString() + ", " + color;
    }

    public enum Color {
        RED, GREEN, BLUE, YELLOW, PURPLE, ORANGE
    }

    public static Lollipop parseCandy(String line) throws Exception {
        String[] tokens = line.split(",");
        if (tokens.length!=5) {
            throw new ParseException("Invalid line format", 0);
        }
        String name = tokens[0].trim();
        double sugar = Double.parseDouble(tokens[1].trim());
        double price = Double.parseDouble(tokens[2].trim());
        double weight = Double.parseDouble(tokens[3].trim());
        String colorString = tokens[4].trim();
        Color color = Color.valueOf(colorString);
        return new Lollipop(name, sugar, price, weight, color);
    }
}