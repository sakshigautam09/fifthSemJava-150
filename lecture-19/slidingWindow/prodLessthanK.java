public class prodLessthanK{
    public static void main(String[] args){
        int[] arr = {1,2,4,7,3,5,5,2,6};
        int k = 20;
        System.out.println(prod(arr, k));
    }
    public static int prod(int[] arr, int k){
        int ans = 0, p = 1, si = 0, ei = 0;
        while(ei < arr.length){
            p = p * arr[ei];
            while(p >= k && si <= ei){
                p /= arr[si];
                si++;
            }
            ans = ans + (ei - si + 1);
            ei++; 
        }
        return ans;
    }
}