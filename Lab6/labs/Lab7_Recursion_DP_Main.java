package labs;
import java.util.ArrayList;
import java.util.List;

import solutions.pack7_recursion.EqualSubsets_661534;
import solutions.pack7_recursion.GridPaths_661534;
import solutions.pack7_recursion.Subsets_661534;

public class Lab7_Recursion_DP_Main {
    public static void main(String[] args) {
        testEqualSubsets();
        System.out.println("----");
        testSubsets();
        testGridPaths();
    }
    static void testEqualSubsets() {
        int [] a = {1,5,11,5};
        int [] b = {1,5,3};
        System.out.println(EqualSubsets_661534.canPartition_Recurse(a));
        System.out.println(EqualSubsets_661534.canPartition_Recurse(b));
        System.out.println(EqualSubsets_661534.canPartition_Memoiz(a));
        System.out.println(EqualSubsets_661534.canPartition_Memoiz(b));
        System.out.println(EqualSubsets_661534.canPartition_DP(a));
        System.out.println(EqualSubsets_661534.canPartition_DP(b));     
    }

    static void testSubsets() {
        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println("--- subsets ---");
        System.out.println("using recursive method: ");
        Subsets_661534.printAllSubsets_Recurse(set);
        System.out.println("\nusing dynamic programming method:");
        Subsets_661534.printAllSubsets_DP(set);
    }

    static void testGridPaths() {
        int [][] grid = { {0, 0, 0, 0},
                        {0, 1, 0, 0},
                        {0, 0, 0, 1},
                        {1, 0, 0, 0} 
                        };
        System.out.println("number of paths: " + GridPaths_661534.numberOfPaths(grid));
    }
}
