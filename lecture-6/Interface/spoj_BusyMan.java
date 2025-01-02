import java.util.*;
public class spoj_BusyMan{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t =sc.nextInt();
        while(t-- > 0) {
            pair[] arr = new pair[n];

            for (int i = 0; i < arr.length; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                arr[i] = new pair(start, end);
            }
            Arrays.sort(arr, new Comparator<pair>() {
                @Override
                public int compare(pair o1, pair o2) {
                    return o1.end - o2.end;
                }
            });
            int activities = 1;
            int end = arr[0].end;
            for(int i=0; i<arr.length; i++){
                if(end <= arr[i].start){
                    activities++;
                    end = arr[i].end;
                }
            }
            System.out.println(activities);
        }
    }

    static class pair{
        int start;
        int end;

        public pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}