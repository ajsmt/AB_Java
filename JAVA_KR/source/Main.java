import AB.Data.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Tree> ForestTrees = TreeIO.readForestFromFile("input1.txt");
            System.out.println("Forest trees :");
            System.out.println(TreeIO.writeToString(ForestTrees));
            System.out.println("Print sorted input1.txt:");
            System.out.println(TreeIO.writeToString(TreeUtil.takeSorted(ForestTrees)));
            System.out.println("Print sorted input1.txt by efficiency divided by age:");
            System.out.println(TreeIO.writeToString(TreeUtil.takeSortedByEfficiencyDividedByAge(ForestTrees)));
            System.out.println("Binary search of:");
            ForestTree forestTree = ForestTree.parseForestTree("SForestTree_1 3 leaf 33");
            System.out.println(forestTree);
            System.out.println("Binary search result: " + TreeUtil.binarySearch(ForestTrees, forestTree));
            System.out.println("Print tree names starting with S:");
            System.out.println(TreeUtil.getTreeNamesStartingWithS(ForestTrees));
            System.out.println("Print quantity of leaf trees:");
            System.out.println(TreeUtil.getTreeTypeQuantity(ForestTrees, Tree.TreeType.leaf));

            System.out.println("--------------------------------");

            List<Tree> FruitTreeList = TreeIO.readFruitFromFile("input2.txt");
            System.out.println("Fruit trees :");
            System.out.println(TreeIO.writeToString(FruitTreeList));
            System.out.println("Print sorted input2.txt:");
            System.out.println(TreeIO.writeToString(TreeUtil.takeSorted(FruitTreeList)));
            System.out.println("Print sorted input2.txt by efficiency divided by age:");
            System.out.println(TreeIO.writeToString(TreeUtil.takeSortedByEfficiencyDividedByAge(FruitTreeList)));
            System.out.println("Binary search of:");
            FruitTree fruitTree = FruitTree.parseFruitTree("ForestTree_5 10 hvoinoe 2 15");
            System.out.println(fruitTree);
            System.out.println("Binary search result: " + TreeUtil.binarySearch(FruitTreeList, fruitTree));
            System.out.println("Print tree names starting with S:");
            System.out.println(TreeUtil.getTreeNamesStartingWithS(FruitTreeList));
            System.out.println("Print quantity of hvoinoe trees:");
            System.out.println(TreeUtil.getTreeTypeQuantity(FruitTreeList, Tree.TreeType.hvoinoe));

        }
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}