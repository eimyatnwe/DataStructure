package solutions.code5_Postfix;

public class MyStackA_6601534 {

    private int MAX_SIZE = 100;
    private double [] stack = new double[MAX_SIZE];
    int top = 0;
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("top->");
        for(int i = top - 1; i >= 0; i--){
            sb.append("[");
            sb.append(stack[i]);
            sb.append("]->");
        }
        sb.append("bottom");
        return new String(sb);
    }
    public boolean isFull(){
        return (top == MAX_SIZE);
    }
    public boolean isEmpty(){
        return (top == 0);
    }
    public void push(double d){
        if(!isFull()){
            top++;
            stack[top] = d;
        }else{
            System.out.println("Stack is Full");
        }
    }

    public double pop(){
        if(!isEmpty()){
            double val = stack[top];
            top--;
            return val;
        }else{
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public double top(){
        if(!isEmpty()){
            return stack[top];
        }
        else{
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public static void task1(){
        MyStackA_6601534 stack = new MyStackA_6601534();
        stack.push(1.0);
        stack.push(2.2);
        stack.push(4.4);
        stack.push(3.3);
        System.out.println(stack);
    }

}




