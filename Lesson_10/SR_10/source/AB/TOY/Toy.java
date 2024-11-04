package AB.TOY;

public class Toy {
    private int minAge;
    private int maxAge;
    private String name;

    public Toy(String name, int minAge, int maxAge) {
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + minAge + " " + maxAge; 
    }

    public static Toy parseToy(String line) {
        String[] parts = line.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Wrong format: " + line);
        }
        String name = parts[0].trim();
        int minAge = Integer.parseInt(parts[1].trim());
        int maxAge = Integer.parseInt(parts[2].trim());
        return new Toy(name, minAge, maxAge);
    }
}