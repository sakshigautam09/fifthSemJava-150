
// // by default static hai, access modifier public hai
//     // static variable --> class or interface se associated hota hai
//     // final --> aisa variable jisko kabhi change na kiya ja sake (constant value) --> cannot be reinitialized
//     // final keyword agar "METHOD" ke sath lga hua hai to use kabhi "OVERRIDE" nahi kar sakte
//     // final keyword agar "CLASS" ke sath lga hua hai to use kabhi "INHERIT" nahi kar sakte
//     // class ko immutable banane ke liye, we will use final keyword
// public interface Stack1 {

//         public void push(int item);

//         public int pop();

//         public int peek();

//         public static final int v = 90;

//         // java-8  ---> interface ka nobject bana sakte hai
//         // java-9  ---> private method bana sakte hai
//         public static void fun(){

//         }
//         default void fun2(){

//         }
//         private void fun3(){

//         }
// }