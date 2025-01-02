import java.util.*;
public class zero_one_knapsack{
    public static void main(String[] args){
        int cap = 4;
        int[] wt = {1,2,3,2,2};
        int[] val = {8,4,0,5,3};
        int[][] dp = new int[wt.length][cap+1];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }
        System.out.println(knapsack(wt, val, cap, 0, dp));
    }
    public static int knapsack(int[] wt, int[] val, int cap, int i, int[][] dp){
        if(i == wt.length || cap == 0){
            return 0;
        }
        if(dp[i][cap] != -1){
            return dp[i][cap];
        }
        int inc = 0;
        int exc = 0;
        if(cap>=wt[i]){
            inc = val[i] + knapsack(wt, val, cap-wt[i], i+1, dp);
        }
        exc = knapsack(wt, val, cap, i+1, dp);
        return dp[i][cap] = Math.max(inc, exc);
    }
}