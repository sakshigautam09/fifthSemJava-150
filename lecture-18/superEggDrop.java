import java.util.*;
public class superEggDrop{
    public static void main(String[] args){
        int n=9;
        int e=3;
        int[][] dp = new int[n+1][e+1];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }
        System.out.println(eggs(n, e, dp));
    }

    // giving TLE
    public static int eggs(int n, int e, int[][] dp){
        if(n == 0 || n == 1 || e == 1){
            return n;
        }
        if(dp[n][e] != -1){
            return dp[n][e];
        }
        int ans = Integer.MAX_VALUE;
        // har floor ka pehle worst case nikala, usse best case nikala
        for(int f = 1; f <= n; f++){
            int b = eggs(f-1, e-1, dp);
            int ub = eggs(n-f, e, dp);
            int t = Math.max(b, ub) + 1;
            ans = Math.min(ans, t);
        }
        return dp[n][e] = ans;
    }

    // Binary Search with dp Approach --> test mein ek question pakka aayega is topic se  --> ACCEPTED
    public static int eggs2(int n, int e, int[][] dp){
        if(n == 0 || n == 1 || e == 1){
            return n;
        }
        if(dp[n][e] != -1){
            return dp[n][e];
        }
        int ans = Integer.MAX_VALUE;
        int low = 1;
        int high = n;
        while(low <= high){
            int mid = (low + high) / 2;
            int left = eggs2(mid-1, e-1, dp);
            int right = eggs2(n-mid, e, dp);
            int t = Math.amx(left, right) + 1;
            ans = Math.min(ans, t);
            if(left < right){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return dp[n][e] = ans;
    }
}