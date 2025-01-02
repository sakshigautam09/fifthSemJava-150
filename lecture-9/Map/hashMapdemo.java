// map is an interface
// set is also an interface
// HashMap implementation --> blinkit, zomato, swiggy, uber

// they all are under collection framework
// 1) HashMap --> has key:value pair, no duplicate keys, no indexing
// hashmap does not preserve the order, datastructure used --> "singly linked list"
// 2) TreeMap --> order of data is sorted, datastructure used --> "Red Black Tree"
// 3) LinkedHashMap --> insertion order preserve, datastructure used --> "doubly linked list"
import java.util.*;
public class hashMapdemo{
    public static void main(String[] args){
        // HASHMAP  --> order of data is not preserved in hashmap
        HashMap<String, Integer> mp = new HashMap<>();
        // adding elements
        mp.put("Raj", 78);
        mp.put("Kunal", 85);
        mp.put("Ankit", 77);
        mp.put("Kamlesh", 58);
        mp.put("Ankita", 68);
        mp.put("Amisha", 63);
        // mp.put("null", 24);   //we can also put "null" as a key
 
        // System.out.println(mp);
        // get
        // System.out.println(mp.get("Ankit"));
        // System.out.println(mp.get("Rajesh"));

        // remove
        // System.out.println(mp.remove("Ankit"));
        // System.out.println(mp.remove("Rajesh"));
        // System.out.println(mp);

        // containsKey
        // System.out.println(mp.containsKey("Raj"));
        // System.out.println(mp.containsKey("Rajesh"));
        

        // TREEMAP  -->  data is key wise sorted in TreeMap (Complexity --> O(logn))
        // it cannot have null key bacause it uses comparable, we cannot compare null using comparable it will give null pointer error
        TreeMap<String, Integer> tmp = new TreeMap<>();
        // adding elements
        tmp.put("Raj", 78);
        tmp.put("Kunal", 85);
        tmp.put("Ankit", 77);
        tmp.put("Kamlesh", 58);
        tmp.put("Ankita", 68);
        tmp.put("Amisha", 63);
        System.out.println(tmp);

        
        // LinkedHashMap --> insertion order preserve
        LinkedHashMap<String, Integer> lhp = new LinkedHashMap<>();
        // adding elements
        lhp.put("Raj", 78);
        lhp.put("Kunal", 85);
        lhp.put("Ankit", 77);
        lhp.put("Kamlesh", 58);
        lhp.put("Ankita", 68);
        lhp.put("Amisha", 63);
        System.out.println(lhp);
        // Set<String> s = mp.keySet();
        // for(String key : s){
        //     System.out.println(key + " " + mp.get(key));
        // }
        for(String key : mp.keySet()){
            System.out.println(key + " " + mp.get(key));
        }
    }
}