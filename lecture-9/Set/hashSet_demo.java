import java.util.*;
// 1) HashSet --> order not preserved (O(1))
// 2) TreeSet --> 
// 3) LinkedTreeMap --> 
public class hashSet_demo{
    public static void main(String[] args){
        HashSet<Integer> hs = new HashSet<>();
        hs.add(2);
        hs.add(12);
        hs.add(21);
        hs.add(3);
        hs.add(-45);
        hs.add(12);
        System.out.println(hs);

        // contains
        // System.out.println(hs.contains(5));
        // System.out.println(hs.contains(3));

        // it does not have any get method (have only contains method)

        // remove
        // System.out.println(hs.remove(5));
        // System.out.println(hs.remove(3));

        System.out.println(hs);

        // because it does not have any indexing, we can traverse set only using "for-each" loop
        // for(int e : hs){
        //     System.out.print(e + " ");
        // }
        // System.out.println();


        // TREESET --> sorted order 
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(2);
        ts.add(12);
        ts.add(21);
        ts.add(3);
        ts.add(-45);
        ts.add(12);
        System.out.println(ts);


        // LINKEDHASHSET --> insertion order preserve
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(2);
        lhs.add(12);
        lhs.add(21);
        lhs.add(3);
        lhs.add(-45);
        lhs.add(12);
        System.out.println(lhs);
    }
}