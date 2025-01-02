// FORMAT
    // while(ei < s.length){
        // grow
    // }
    // shrink
    // ans update
import java.util.*;
public class kartikBhaiyaAndString{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		String s=sc.next();
		int flip_a=maxLen(s,k,'a');
		int flip_b=maxLen(s,k,'b');
		System.out.println(Math.max(flip_a, flip_b));
	}
	public static int maxLen(String s, int k, char ch){
        int si = 0;
        int ei = 0;
		int ans = 0;
        int flip = 0;
        while(ei < s.length()){
            if(s.charAt(ei) == ch){
                flip++;
            }
            while(flip > k){
                if(s.charAt(si) == ch){
                    flip--;
                }
                si++;
            }
            ans = Math.max(ans, ei - si + 1);
            ei++;
        }
        return ans;
    }
}

// DEQUE -> is an interface in java
