import java.util.*;
public class minFallingSum{
    public static void main(String[] args){
        int[][] grid = {{2,1,3}, {6,5,4}, {7,8,9}};
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int[] a:dp){
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        for (int i = 0; i < grid[0].length; i++) {
            ans = Math.min(ans, fallingPathSum(grid, 0, i, dp));
        }
        System.out.println(ans);
    }
    public static int fallingPathSum(int[][] grid, int cr, int cc, int[][] dp){
        if(cc >= grid[0].length || cc<0){
            return Integer.MAX_VALUE;
        }
        if(cr == grid.length-1){
            return grid[cr][cc];
        }
        if(dp[cr][cc] != Integer.MAX_VALUE){
            return dp[cr][cc];
        }
        int ld = fallingPathSum(grid, cr+1, cc-1, dp);
        int d = fallingPathSum(grid, cr+1, cc, dp);
        int rd = fallingPathSum(grid, cr+1, cc+1, dp);
        return dp[cr][cc] = Math.min(d, Math.min(ld, rd)) + grid[cr][cc];

    }
}