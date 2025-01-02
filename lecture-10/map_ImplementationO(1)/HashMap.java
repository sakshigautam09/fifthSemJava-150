// when do we use re-hashing 
// load factor = total element / bucket size
// threshold factor

// for generic class use angular brackets
import java.util.*;
public class HashMap<K, V> {
    class Node {
        K key;
        V value;
        Node next;
    }
    // for generic node, we cannot create array beacuse we can't make our array generic for this we need to make arraylist
    // Node[] arr = new Node[5];

    private ArrayList<Node> bucket;
    private ArrayList<Node> old_bucket;
    private int size;

    // constructor of hashMap
    public HashMap(){
        // calling parameterized constructor inside this constructor 
        this(4);
    }
    public HashMap(int n){
        bucket = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bucket.add(null);            
        }
    }
    public void put(K key, V value){
        int idx = hash_Function(key);
        Node temp = bucket.get(idx);
        while(temp != null){
            if(temp.key.equals(key)){
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        temp = bucket.get(idx);
        Node nn = new Node();
        nn.key = key;
        nn.value = value;
        nn.next = temp;
        bucket.set(idx, nn);
        size++;
        double lf = (1.0*size) / bucket.size();
        double thf = 2.0;
        if(lf > thf){
            rehashing();
        }
    }

    public void rehashing(){
        ArrayList<Node> new_bucket = new ArrayList<>();
        for(int i = 0; i < 2 * bucket.size(); i++){
            new_bucket.add(null);
        }
        ArrayList<Node> old_bucket = bucket;
        bucket = new_bucket;
        size = 0;
        for(Node n : old_bucket){
            while(n != null){
                put(n.key, n.value);
                n = n.next;
            }
        }
    }
    // @override
    public String toString(){
        String s = "{";
        for(Node n : old_bucket){
            while(n != null){
                s = s + n.key + "=" + n.value + ",";
                n = n.next;
            }
        }
        return s + "}";
    }
    public boolean containsKey(K key){
        int idx = hash_Function(key);
        Node temp = bucket.get(idx);
        while(temp != null){
            if(temp.key.equals(key)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public V get(K key){
        int idx = hash_Function(key);
        Node temp = bucket.get(idx);
        while(temp != null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;    
    }
    public V remove(K key){
        int idx = hash_Function(key);
        Node curr = bucket.get(idx);
        Node prev = null;
        while(curr != null){
            if(curr.key.equals(key)){
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if(curr == null){
            return null;
        }
        if(prev == null){
            bucket.set(idx, curr.next);
            size--;
        }
        else{
            prev.next = curr.next;
            size--;
        }
        return curr.value;
    }
    public int hash_Function(K key){
        // bn -> bucket number
        // hashCode -> a unique value associated with every value
        // negative number ko mod karne par do remainder aate hain
        // ex: -7 % 4 = -3 (first) and -3 + 4 = 1 (second)
        int bn = key.hashCode() % bucket.size();
        if(bn < 0){
            bn += bucket.size();
        }
        return bn;
    }
}

















