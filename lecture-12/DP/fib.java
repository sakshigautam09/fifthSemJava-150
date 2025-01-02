import java.util.*;
public class fib{
    public static void main(String[] args){
        int n = 7;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        // System.out.println(fib_Mem(n, dp));
        System.out.println(fib_Tab(n));

    }

    public static int fib_Mem(int n, int[] dp){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int f1 = fib_Mem(n-1, dp);
        int f2 = fib_Mem(n-2, dp);
        return dp[n] = f1+f2;
    }

    public static int fib_Tab(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[dp.length-1];
    }
}