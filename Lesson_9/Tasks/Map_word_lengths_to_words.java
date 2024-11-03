import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapUtil
{
   /**
      Make a sorted map whose keys are the word lengths words and whose values are
      the sets of the words with the given lengths. The map and sets should be sorted.
      @param words an array of strings
      @return a map mapping strings to their lengths
   */
   public Map<Integer, TreeSet<String>> makeMap(String[] words)
   {
      Map<Integer, TreeSet<String>> result = new TreeMap<>();
      for(int i = 0; i<words.length; i++){
         int length = words[i].length();
         TreeSet<String> set = result.getOrDefault(length, new TreeSet<String>());
         set.add(words[i]);
         result.put(length, set);
      }
      return result;
   }
}