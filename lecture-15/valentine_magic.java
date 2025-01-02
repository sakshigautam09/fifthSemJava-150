public class valentine_magic{
    public static void main(String[] args){
        int[] boys = {2,11,3};
        int[] girls = {5,7,3,2};
        System.out.println(min_diff(boys, girls, 0, 0));
    }
    // appply dp
    public static int min_diff(int[] boys, int[] girls, int i, int j){
        if(i == boys.length){
            return 0;
        }
        if(j == girls.length){
            return 6666666;
        }
        int take = Math.abs(boys[i]-girls[j]) + min_diff(boys, girls, i+1, j+1);
        int skip = min_diff(boys, girls, i, j+1);
        return Math.min(take, skip);
    }
}