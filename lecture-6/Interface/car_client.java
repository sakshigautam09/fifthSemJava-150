import java.util.*;
import compareTo.Comparator;
public class cars implements Comparator<cars>{

    public static void main(String[] args) {
        cars[] arr = new cars[5];   //at this point no car has been made
        arr[0] = new cars(200, 10, "white");
        arr[1] = new cars(1000, 20, "black");
        arr[2] = new cars(340, 3, "grey");
        arr[3] = new cars(34, 89, "red");
        arr[4] = new cars(8795, 6, "yellow");

        // overriding the methods of interface
        Arrays.sort(arr, new Comparator<cars>() {
            public int compare(cars o1, cars o2){
                return o1.price - o2.price;
            }
        });
        // sort(arr);
        display(arr);
        System.out.println("hhh");
    }

    // extends Comparable<T>  -->  means only those datatypes are allowed for which compareTo method is made
    public static <T extends Comparable<T>> void sort(T[] arr){
        for (int t = 1; t < arr.length; t++) {
            for (int i = 0; i < arr.length - t; i++) {
                if(arr[i].compareTo(arr[i+1]) > 0){
                    T temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }   
            }
        }
    }

    public static void display(cars[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+ "");
        }
        System.out.println();
    }
}
