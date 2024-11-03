import java.util.Map;
import java.util.HashSet;

/**
   This HashSetUtil class tests various usages of the HashSetUtil class. 
   params 1 and 2 are a first name and a last name. You will construct TWO Person
   objects, p1 and p2, each with param1 and param2 for their fn and ln respectively. 
   You will then construct a HashSet and enter ONLY your p1 into it. Then you will  
   search the HashSet using Person p2. This search wil FAIL. You will remedy this
   by adding to the Person class an override for the equals and hashcode methods so that 
   the search is successful and the return value is true.
*/
public class HashSetUtil
{

 public static boolean check(String s1, String s2)
 {
     Person p1 = new Person(s1,s2);
     Person p2 = new Person(s1,s2);

     HashSet<Person> people = new HashSet<Person>();
     people.add(p1);

     return processSet(people, p2);
 }


 public static boolean processSet(HashSet<Person> people, Person person)
 {
   return people.contains(person);
 }


/* Inner class Person simply has two name fields fn, first name and ln, last name, 
   a constructor and the toString  method override
*/
static class Person 
{
   private String fn;
   private String ln;

   public Person(String fn, String ln) {
      this.fn = fn;
      this.ln = ln; 
   }

   public String toString()
   {
     return ln + ", " + fn;
   }

   @Override
   public int hashCode()
   {
      return fn.hashCode() + ln.hashCode();
   }

   @Override
   public boolean equals(Object object)
   {
      if (object == null || getClass() != object.getClass())
         return false;
      Person person = (Person) object;
      return fn.equals(person.fn) && ln.equals(person.ln);
   }
}

}