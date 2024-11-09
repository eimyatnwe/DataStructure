package labs;

import java.util.ArrayList;

import solutions.pack9_Heap.MyHeapSort;
import solutions.pack9_Heap.MyMinHeap_661534;
import solutions.pack9_Heap.MyPriorityQueue_661534;

public class Lab9_PQ {
    static ArrayList<Integer> least3;
    public static void main(String[] args) {
        System.out.println("-task1---");
        task1();
        System.out.println("-task2---");
        task2();
        System.out.println("-task3---");
        task3();
    }
    static void task1() {
        least3 = new ArrayList<>();
        MyMinHeap_661534 heap = new MyMinHeap_661534();
        heap.insert(11);
        heap.insert(15);
        heap.insert(16);
        heap.insert(13);
        heap.insert(17);
        heap.insert(18);
        System.out.println("heap structure is " + heap);
        least3.add(heap.remove()); 
        least3.add(heap.remove()); 
        least3.add(heap.remove()); 
        System.out.println("least 3 value is " + least3);
    }    
    static void task2() {
        least3 = new ArrayList<>();
        MyPriorityQueue_661534 pq = new MyPriorityQueue_661534();
        pq.enqueue(11);
        pq.enqueue(15);
        pq.enqueue(16);
        pq.enqueue(13);
        pq.enqueue(17);
        pq.enqueue(18);
        pq.enqueue(19); // isFull() is true ...discard
        System.out.println("Priority Queue structure is: " + pq);

        
        least3.add(pq.dequeue());
        least3.add(pq.dequeue());
        least3.add(pq.dequeue());

        
        System.out.println("Least 3 values are: " + least3);
    }
    static void task3() {
        MyHeapSort heap = new MyHeapSort();
        heap.insert(11);
        heap.insert(15);
        heap.insert(16);
        heap.insert(13);
        heap.insert(17);
        heap.insert(18);        
        System.out.println(heap.sort());
    }
}