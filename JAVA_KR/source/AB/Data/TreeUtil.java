package AB.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class TreeUtil {
    public static List<Tree> takeSorted(List<Tree> trees) {
        return trees.stream()
                .sorted(Comparator.comparing(Tree::getAge, Comparator.reverseOrder()).thenComparing(Tree::getName))
                .toList();
    }

    public static long getTreeTypeQuantity(List<Tree> trees, Tree.TreeType type) {
        return trees.stream().filter(tree -> tree.getType() == type).count();
    }

    public static int binarySearch(List<Tree> trees, Tree x) {
        int index = Collections.binarySearch(trees, x);
        return index;
    }

    public static List<Tree> takeSortedByEfficiencyDividedByAge(List<Tree> trees) {
        return trees.stream().sorted(Comparator.comparingDouble(tree -> tree.calculateEconomicEfficiency() / tree.getAge())).toList();
    }

    public static List<String> getTreeNamesStartingWithS(List<Tree> trees) {
        Set<String> names = new HashSet<String>();
        for(Tree tree : trees) {
            if(tree.getName().startsWith("S")){
                names.add(tree.getName());
            }
        }
        List<String> result = new ArrayList<>();
        for(String name : names){
            result.add(name);
        }
        return result.stream().sorted(Comparator.reverseOrder()).toList();
    }
}
