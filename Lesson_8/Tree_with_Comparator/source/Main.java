import java.util.Comparator;

class Main {
	public static void main(String[] args) {
		try {
			Comparator<String> comp1 = Comparator.reverseOrder();
			Comparator<String> comp2 = Comparator.naturalOrder();
			Comparator<String> comp3 = (String s1, String s2) -> {return s1.length() - s2.length();};
			Comparator<String> comp4 = (String s1, String s2) -> s1.length() - s2.length();
			Comparator<String> comp5 = Comparator.comparingInt(String::length);
			Tree<String> tree = new Tree<String>(comp5);
			tree.add("Apple");
			tree.add("Orange");
			tree.add("Banana");
			tree.add("Grape");
			tree.printLVRln();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

