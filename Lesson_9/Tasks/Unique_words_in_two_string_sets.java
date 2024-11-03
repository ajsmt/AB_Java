import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SetUtil
{   
   /**
      Determine the strings that are unique to words1 and words2
      @param words1 an array of strings
      @param words2 an array of strings      
      @param a list of two sets: the words that are in words1 but not word2,
      and the words that are in words2 but not word1. The sets should be sorted.
   */
   public static List<Set<String>> uniqueInEach(String[] words1, String[] words2)
   {
      Set<String> set1 = new TreeSet<>();
      set1.addAll(Arrays.asList(words1));
      set1.removeAll(Arrays.asList(words2));
      Set<String> set2 = new TreeSet<>();
      set2.addAll(Arrays.asList(words2));
      set2.removeAll(Arrays.asList(words1));
      List<Set<String>> result = new ArrayList<>();
      result.add(set1);
      result.add(set2);
      return result;
   }
}