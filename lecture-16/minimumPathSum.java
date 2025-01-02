import java.util.*;
public class minimumPathSum{
    public static void main(String[] args){
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }
        System.out.println(pathSum(grid, 0, 0, dp));
    }
    public static int pathSum(int[][] grid, int cr, int cc, int[][] dp){
        if(cr == grid.length-1 && cc == grid[0].length-1){
            return grid[cr][cc];
        }
        if(cr >= grid.length || cc >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[cr][cc] != -1){
            return dp[cr][cc];
        }
        int right = pathSum(grid, cr, cc+1, dp);
        int down = pathSum(grid, cr+1, cc, dp);
        return dp[cr][cc] = Math.min(right, down) + grid[cr][cc];
    }
}