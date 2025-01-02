// SLIDING WINDOW
// when an array or string is given in input and output is asking about substring or subarray, we use sliding window
// 1) fixed window size
// 2) variable window size

// because sixe of k is fixed that's why we are calling it fixed window
// firstly, prepare first window
// second, grow -> shrink -> ans

public class maxSumOfWindowSize_K{
    public static void main(String[] args){
        int[] arr = {2,3,4,1,5,6,8,2,6,8,9,2,1,3};
        int k=3;
        System.out.println(maxSum(arr, k));
    }

    public static int maxSum(int[] arr, int k){
        int ans = 0;
        int sum = 0;
        // preparaing first window
        for(int i=0;i<k;i++){
            sum = sum + arr[i];
        }
        ans = sum;
        for(int i=k;i<arr.length;i++){
            sum += arr[i];  //grow
            sum -= arr[i-k];  //shrink
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}