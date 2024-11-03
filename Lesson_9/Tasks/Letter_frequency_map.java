import java.util.Map;
import java.util.TreeMap;

public class LetterMap
{
   public Map<String, Integer> makeLetterMap(String str)
   {
      Map<String, Integer> result = new TreeMap<>();
      for (int i = 0; i < str.length(); i++) { 
         String ch = String.valueOf(str.charAt(i));
         result.put(ch, result.getOrDefault(ch, 0) + 1);
      }
      return result;
   }
}