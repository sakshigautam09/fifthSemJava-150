public class mergeKSortedLists{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static void main(String[] args){
        mergeKLists
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>();
        for(ListNode ln : lists){
            if(ln != null){
                pq.add(ln);
            }
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = curr.next;

            if(temp.next != null){
                pq.add(temp.next);
            }
        }
        return dummy.next;
    }
}