package solutions.pack9_Heap;
import solutions.pack9_Heap.MyQueueInterface;
public class MyPriorityQueue_661534 implements MyQueueInterface{
    private MyMinHeap_661534 heap;
    public MyPriorityQueue_661534(){
        heap = new MyMinHeap_661534();
    }
    @Override
    public void enqueue(int d){
        if(!heap.isFull()){
            heap.insert(d);
        }
    }

    public int dequeue(){
        if(!heap.isEmpty()){
            return heap.remove();
        }
        return -1;
        
    }

    public int front(){
        return heap.peek();
    }

    public boolean isFull(){
        return heap.isFull();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public String toString(){
        return heap.toString();
    }
} 
