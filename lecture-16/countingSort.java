import java.util.*;
public class countingSort{
    public static void main(String[] args){
        // create array of key+1 size
        int[] arr = {2,1,1,0,1,1,2,5,4,0,2,0,7,9,2,6,1,9};
        System.out.println(Arrays.toString(sort(arr)));
    }
    // in the exams, where the number of candidates are more and marks are quite less than the number of students, counting sort is used to create ranks like jee, ssc exams
    // we will not be doing any comparison in this sorting algo
    // it will return us a new array
    public static int[] sort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int[] freq = new int[max+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        for(int i=1;i<freq.length;i++){
            freq[i] = freq[i-1]+freq[i];
        }
        int[] ans = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int c = freq[arr[i]];
            ans[c-1] = arr[i];
            ans[arr[i]]--;
        }
        return ans;
    }
}