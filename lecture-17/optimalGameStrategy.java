import java.util.*;
public class optimalGameStrategy{
    public static void main(String[] args){
        // it seems like greedy but it is a problem of dp
        int[] arr = {1,2,3,4};
        int[][] dp = new int[arr.length][arr.length];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }
        System.out.println(ogs(arr, 0, arr.length-1, dp));
    }
    public static int ogs(int[] arr, int i, int j, int[][] dp){
        if(i > j){
            return 0;
        }
        // when we only have two values, then it will return the maximum value for Piyush
        if(i+1 == j){
            return Math.max(arr[i], arr[j]);
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int a = arr[i] + Math.min(ogs(arr, i+2, j, dp), ogs(arr, i+1, j-1, dp));
        int b = arr[j] + Math.min(ogs(arr, i+1, j-1, dp), ogs(arr, i, j-2, dp));
        return dp[i][j] = Math.max(a, b);
    }
}