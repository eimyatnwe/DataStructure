package solutions.pack7_recursion;

public class EqualSubsets_661534 {

    public static boolean canPartition_Recurse(int[] arr){
        
        int sum = 0;
        //calculate total sum
        for(int ele : arr){
            sum += ele;
        }
        // System.out.println(sum);
        //if it is odd number, we cant partitined into two subset with equal sum
        if(sum % 2 != 0){
            return false;
        }

        //to goal is to find a subset of array that adds up to this target num
        int target = sum / 2;
        return helper(arr,0,target);

    }

    private static boolean helper(int[] arr,int index, int sum){
        if(index >= arr.length || sum < 0){
            return false;
        }
        if(sum == 0){
            return true;
        }

        //take that current number at the index
        //since we took it, it will not be in the another recursion
        boolean take = helper(arr, index + 1, sum - arr[index]);

        //skip the current element and moving to the next index without changing the sum
        boolean skip = helper(arr, index + 1, sum);
        return take || skip;
    }   


   
    public static boolean canPartition_Memoiz(int [] arr){
        int totalSum = 0;
        for(int ele : arr){
            totalSum += ele;
        }
        if(totalSum % 2 != 0){
            return false;
        }
        int targetSum = totalSum / 2;
        int len = arr.length;

        Boolean[][] cache = new Boolean[len][targetSum + 1];
        return memoHelper(arr,0,targetSum,cache);
    }
    private static boolean memoHelper(int[] arr, int index, int sum, Boolean[][] cache){
        if(index >= arr.length || sum < 0){
            return false;
        }
        if(sum == 0){
            return true;
        }
        if(cache[index][sum] != null){
            return cache[index][sum];
        }
        Boolean take = memoHelper(arr, index + 1, sum - arr[index], cache);
        Boolean skip = memoHelper(arr, index + 1, sum, cache);
        cache[index][sum] = take || skip;
        return cache[index][sum];
    }

    public static boolean canPartition_DP(int[] arr){
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        int n = arr.length;

       
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; 
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][targetSum];
    }
    

}

