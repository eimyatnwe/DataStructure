package solutions.pack3; 
public class MyLinkedList_661534{
    public class Node {
        int data;
        Node next;
        Node(){}
        Node(int d) {data = d;}
    }
    Node head = null;

    public String toString(){
        StringBuffer sb = new StringBuffer("head");
        Node p = head;
        while (p != null) {
            sb.append("-->[");
            sb.append(p.data);
            sb.append("]");
            p = p.next;
        }

        sb.append("->null");
        return sb.toString();
    }

    public int size(){
        Node p = head;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;

    }

    public void add(int[] d){
        for(int i = d.length - 1; i >= 0; i--){
            add(d[i]);
        }
    } 

    public void add(int d){
        Node p = new Node(d);
        p.next = head;
        head = p;
    }

    public void insert(int[] d){
        for(int i = d.length - 1; i >= 0; i--){
            insert(d[i]);
        }
    }
    public void insert(int d){
        Node p = new Node(d);
        if(head == null){
            head = p;
            return;
        }

        Node q = head;
        Node r = null;
        while (q != null && q.data < d) {
            r = q;
            q = q.next;
        }

        if(r == null){
            p.next = head;
            head = p;
        }

        else{
            r.next = p;
            p.next = q;
        }

    }

    public int find(int d){
        Node p = head;
        int index = 0;
        while (p != null) {
            if(p.data == d){
                return index;
                
            }
            index++;
            p = p.next;
        }
        return index;
    }

    public void delete(int d){
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while ((p.next != null) && (p.next.data != d)) {
            p = p.next;
        }
        if(p.next != null){
            p.next = p.next.next;
        }
        head = t.next;
    }


}