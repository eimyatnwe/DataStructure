package solutions.pack5_Postfix;

import java.util.Iterator;
import java.util.LinkedList;

public class MyQueueListWrap_6601534<T> implements Iterable<T> {
    private LinkedList<T> items = new LinkedList<>(); 

    
    public void enqueue(T d) {
        items.add(d);
    }

    
    public T dequeue() {
        return items.poll();
    }

    
    public T top() {
        return items.peek();
    }

   
    public T getLast() {
        return items.peekLast();
    }

   
    public String dumpToString() {
        StringBuilder sb = new StringBuilder();
        for (T item : items) {
            sb.append(item).append(" ");
        }
        return sb.toString().trim();
    }

    
    @Override
    public Iterator<T> iterator() {
        return new MyQueueIterator();
    }

   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<T> iter = items.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

   
    private class MyQueueIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < items.size();
        }

        @Override
        public T next() {
            return items.get(currentIndex++);
        }
    }
}