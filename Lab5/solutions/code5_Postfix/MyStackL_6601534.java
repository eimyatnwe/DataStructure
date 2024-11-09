package solutions.code5_Postfix;

class Node {
    String value;
    Node next;
    public Node(){}
    public Node(String d){
        value = d;
        next = null;
   }

}
public class MyStackL_6601534 {
    public Node top;
    
    public MyStackL_6601534(){
        top = null;
    }

    public void push(String d){
        Node oldNode = top;
        top = new Node();
        top.value = d;
        top.next = oldNode;
    }

    public String pop(){
        String s = top.value;
        top = top.next;
        return s;
    }

    public boolean isFull(){
        return false;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public String peek(){
        return top.value;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Top->");
        Node temp = top;
        while (temp != null) {
            sb.append(temp.value).append("->");
            temp = temp.next;
        }

        sb.append("Bottom");
        return sb.toString();
    }
    
}
