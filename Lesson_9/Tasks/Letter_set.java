import java.util.Set;
import java.util.TreeSet;

public class LetterSet
{
   public Set<String> makeLetterSet(String str)
   {
      Set<String> result = new TreeSet<>();
      for (int i = 0; i < str.length(); i++) { 
         result.add(String.valueOf(str.charAt(i)));
      } 
      return result;
   }
}