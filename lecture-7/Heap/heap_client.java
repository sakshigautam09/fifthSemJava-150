public class heap_client {
    public static void main(String[] args) {
        heap hp = new heap();
        priorityQueue<Integer> pq = new PriorityQueue<>();
        priorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        hp.add(10);
        hp.add(20);
        hp.add(30);
        hp.add(5);
        hp.add(7);
        hp.add(3);
        hp.add(-2);
        hp.display();
        
}