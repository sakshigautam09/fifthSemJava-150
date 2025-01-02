public class heap{
    // it is a complete binary tree and has some priorities associated (rank and marks) with it
    // complete binary tree --> if the level of the tree is "L", then it must be filled till "L-1"
    // if the priority is of rank type --> min heap
    // if the priority is of marks type --> max heap
    private ArrayList<Integer> l = new ArrayList<Integer>();;
    public void ass(int item){
        l.add(item);
        upheapify(l.size()-1);
    }
    private void upheapify(int ci){
        int pi = (ci-1)/2;
        if(l.get(pi) > l.get(ci)){
            swap(pi, ci);
            upheapify(pi);
        }
    }
    private void swap(int i, int j){
        int ith = l.get(i);
        int jth = l.get(j);
        l.set(i, jth);
        l.set(j, ith);
    }
    public int remove(){
        swap(0, l.size()-1);
        int temp = l.remove(l.size()-1);
        downheapify(0);
        return temp;
    }
    private void downheapify(int pi){
        int lci = 2*pi+1;
        int rci = 2*pi+2;
        int min = pi;
        if(l.get(min) > l.get(lci)){
            min = lci;
        }
        if(l.get(min) > l.get(rci)){
            min = rci;
        }
        if(min!=pi){
            swap(pi, min);
            downheapify(min);
        }
    }
}