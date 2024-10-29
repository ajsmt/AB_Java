public class Person implements Comparable<Person> {
    public String name;
    public String surname;
    public int age;

    public Person(String surname, String name, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        int surnameCompare = this.surname.compareTo(person.surname);
        if(surnameCompare != 0){
            return surnameCompare;
        }
        int nameCompare = this.name.compareTo(person.name);
        if(nameCompare != 0){
            return nameCompare;
        }
        return Integer.compare(this.age, person.age);
    }

    @Override
    public String toString() {
        return surname + " " + name + " - " + age + ";";
    }
}
