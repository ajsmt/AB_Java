package AB.Data;

public abstract class Tree implements Comparable<Tree> {
    private String name;
    private int age;
    private TreeType type;

    public Tree(String name, int age, TreeType type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setType(TreeType type) {
        this.type = type;
    }

    public TreeType getType() {
        return type;
    }

    public enum TreeType {
        leaf,
        hvoinoe
    }

    public abstract double calculateEconomicEfficiency();

    @Override
    public String toString() {
        return name + " " + age + " " + type;
    }

    @Override
    public int compareTo(Tree otherTree) {
        int nameCompare = name.compareTo(otherTree.getName());
        if (nameCompare == 0) {
            int ageCompare = Integer.compare(this.age, otherTree.getAge());
            if (ageCompare == 0) {
                return type.compareTo(otherTree.getType());
            } else {
                return ageCompare;
            }
        } else {
            return nameCompare;
        }
    }

    public abstract int getComparison(Tree tempTree);
}
