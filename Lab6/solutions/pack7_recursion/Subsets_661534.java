package solutions.pack7_recursion;
import java.util.ArrayList;
import java.util.List;

public class Subsets_661534 {
  
    public static void printAllSubsets_Recurse(List<Integer> set){
        List<Integer> subSet = new ArrayList<>();
        printAllSubsetsHelper(set,subSet,0);
    }

    private static void printAllSubsetsHelper(List<Integer> set, List<Integer> subSet, int index){
        if(index == set.size()){
            System.out.print(subSet +",");
            return;
        }

        //exclude curr ele and move to next
        printAllSubsetsHelper(set, subSet, index + 1);
        //include curr ele & move to next
        subSet.add(set.get(index));
        printAllSubsetsHelper(set, subSet, index + 1);

        
        subSet.remove(subSet.size() - 1);
    }

    public static void printAllSubsets_DP(List<Integer> set){
        int n = set.size();
        int numSubsets = 1 << n; 

        for (int i = 0; i < numSubsets; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(set.get(j) + " ");
                }
            }
            System.out.print("]");
        }
        System.out.println();

    } 
}
