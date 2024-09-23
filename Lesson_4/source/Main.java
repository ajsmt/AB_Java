class Main {
	public static void main(String[] args) {
		TestWithInteger();
		System.out.println();
		TestWithCustomClass();
	}

	private static void TestWithInteger() {
		System.out.println("++++ Tree<Integer> ++++\n");
		System.out.println("The tree drawing can be seen in the integerTree.png file");
		Tree<Integer> tree = new Tree<Integer>();
		tree.add(12);
		tree.add(6);
		tree.add(4);
		tree.add(7);
		tree.add(9);
		tree.add(15);
		System.out.print("Left - Vertex - Right : ");
		tree.printLVRln();
		System.out.print("Left - Right - Vertex : ");
		tree.printLRVln();
		System.out.print("Vertex - Left - Right : ");
		tree.printVLRln();
		System.out.println("9 : " + ((tree.find(9)) ? "Found!" : "Not found"));
		System.out.println("1 : " + ((tree.find(1)) ? "Found!" : "Not found"));
		System.out.println("4 : " + ((tree.find(4)) ? "Found!" : "Not found"));
		System.out.println("5 : " + ((tree.find(5)) ? "Found!" : "Not found"));
		System.out.println("12 : " + ((tree.find(12)) ? "Found!" : "Not found"));
		tree.remove(7);
		System.out.print("After 7 was removed : ");
		tree.printLVRln();
		System.out.println("\n---- Tree<Integer> ----\n");
	}

	private static void TestWithCustomClass() {
		System.out.println("++++ Tree<Person> ++++\n");
		Tree<Person> tree = new Tree<Person>();	
		tree.add(new Person("Guerrero", "Sue", 28));
		tree.add(new Person("Armstrong", "Bradley", 25));
		tree.add(new Person("Armstrong", "Christina", 21));
		tree.add(new Person("Price", "Gussie", 21));
		tree.add(new Person("McGuire", "Adrian", 19));
		tree.printLVRln();
		Person person = new Person("Guerrero", "Sue", 28);
		System.out.println(person + " : " + ((tree.find(person)) ? "Found!" : "Not found"));
		Person anotherpPerson = new Person("Ortega", "Dorothy", 23);
		System.out.println(anotherpPerson + " : " + ((tree.find(anotherpPerson)) ? "Found!" : "Not found"));
		tree.remove(person);
		System.out.print("After removing " + person + " :\n");
		tree.printLVRln();
		System.out.println("\n---- Tree<Person> ----\n");
	}

}