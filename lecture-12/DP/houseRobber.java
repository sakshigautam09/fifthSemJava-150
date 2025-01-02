import java.util.*;
public class houseRobber{
    public static void main(String args[]){
        int[] arr = {2,7,9,3,1};
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.print(HouseRobberTD(arr,0,dp));
    }
    public static int HouseRobberTD(int[] arr,int i,int[] dp){
        if(i>=arr.length){
            return 0;
        }
        int rob = arr[i]+HouseRobberTD(arr,i+2,dp);
        int dont_rob = HouseRobberTD(arr,i+1,dp);
        return dp[i] = Math.max(rob,dont_rob);
    }
    // tabulation
    public static int HouseRobberBU(int arr[]){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = arr[1];
        for(int i=2;i<dp.length;i++){
            int rob = arr[i] + dp[i-2];
            int dont_rob = dp[i-1];
            dp[i] = Math.max(rob,dont_rob);
        }
        return dp[dp.length-1];
    }
}