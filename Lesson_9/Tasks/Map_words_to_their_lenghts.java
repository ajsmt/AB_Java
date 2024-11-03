import java.util.Map;
import java.util.TreeMap;

public class MapUtil
{
   /**
      Make a sorted map whose keys are the given words and whose values are their lengths.
      @param words an array of strings
      @return a map mapping strings to their lengths
   */
   public Map<String, Integer> makeMap(String[] words)
   {
      Map<String, Integer> result = new TreeMap<>();
      for(int i = 0; i < words.length; i++){
         result.put(words[i], words[i].length());
      }
      return result;
   }
}