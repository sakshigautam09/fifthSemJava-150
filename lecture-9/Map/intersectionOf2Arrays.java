import java.util.*;
public class intersectionOf2Arrays{
    public static void main(String[] args){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] ans = intersection(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] intersection(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(!mp.containsKey(nums1[i])){
                mp.put(nums1[i], 1);
            }else{
                mp.put(nums1[i], mp.get(nums1[i]) + 1);
            }
        }
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<nums2.length; i++){
            if(mp.containsKey(nums2[i]) && mp.get(nums2[i]) > 0){
                l.add(nums2[i]);
                mp.put(nums2[i], mp.get(nums2[i]) - 1);
            }
        }
        int[] ans = new int[l.size()];
        for(int i=0;i<l.size();i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}