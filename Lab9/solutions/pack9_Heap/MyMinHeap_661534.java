package solutions.pack9_Heap;

import java.util.Arrays;

public class MyMinHeap_661534 {
    int MAX_SIZE = 6;
    public int heap[] = new int[MAX_SIZE];
    int size = 0;
    public void insert(int d){

        int p = size++;
        heap[p] = d;
        int parent = (int) Math.floor((p - 1)/ 2);
        while ((p > 0) && (heap[p] < heap[parent])) {
            swap(p, parent);
            parent = (int) Math.floor((p - 1)/2);
        }
    }

    public void add(int d){
        int p = size++;
        heap[p] = d;
        trickleUp(p);
    }

    public void trickleUp(int pos){
        if( pos == 0) return;
        int parent = (int) Math.floor((pos - 1)/2);
        if(heap[pos] < heap[parent]){
            swap(pos, parent);
            trickleUp(parent);
        }
    }

    public int remove(){
        int d = heap[0];
        heap[0] = heap[--size];
        trickleDown(0);
        return d;
    }

    public void trickleDown(int p){
        int left = 2 * p + 1;
        int right = 2 * p + 2;

        //check if no left child
        if(left >= size){
            return;
        }

        //only have left child
        if(right == size){
            swap(p, left);
            return;
        }

        //has both left and right child
        int index = heap[left] < heap[right] ? left : right;

        if(heap[p] > heap[index]){
            swap(p, index);
            trickleDown(index);
        }
    }

    public int removes(){
        int d = heap[0];
        heap[0] = heap[--size];
        heap[size] = d;

        int parent = 0;
        while (true) {
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;
            if(left >= size){
                break;
            }
            if(right == size){
                if(heap[parent] > heap[left]){
                    swap(parent, left);
                }
                break;
            }else{
                int index = heap[left] < heap[right] ? left : right;
                if(heap[index] < heap[parent]){
                    swap(parent, index);
                }else{
                    break;
                }

                parent = index;
            }

        }
        return d;
    }

    public void swap(int a, int b){
        heap[a] = heap[a] + heap[b];
        heap[b] = heap[a] - heap[b];
        heap[a] = heap[a] - heap[b];
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Heap is Empty");
            return 1;
        }
        return heap[0];
    }



    @Override
    public String toString() {
        return "MyMinHeap [MAX_SIZE=" + MAX_SIZE + ", heap=" + Arrays.toString(heap) + ", size=" + size + "]";
    }
}
