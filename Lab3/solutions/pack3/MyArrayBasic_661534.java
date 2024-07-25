package solutions.pack3;

import java.util.Arrays;

public class MyArrayBasic_661534 {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;
    
    public MyArrayBasic_661534(){}

    public MyArrayBasic_661534(int ... a){
        if (a == null){
            return;       
        }
        if(a.length < MAX_SIZE)
        {
            for (int i=0; i < a.length; i++) 
                data[i] = a[i];   
        }
        else{
            for (int i=0; i < MAX_SIZE; i++) {
                data[i] = a[i];
            }
        }
    }
    
    @Override
    public String toString() {
        return "MyArrayBasic [data=" + Arrays.toString(data) + "]";
    }

    public void add(int d){
        data[size++] = d;
    }
    public void insert(int d, int index){
        for(int i = size; i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = d;
        size++;
    }
    public int find(int d){
        for(int i = 0; i < size; i++){
            if(data[i] == d){
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int d){
        int a = 0;
        int b = size - 1;
        while(a <= b){
            int m = (a+b)/2;
            if(data[m] == d){
                return m;
            }
            if(d < data[m]){
                b = m-1;
            }
            else{
                a = m+1;
            }
        }
        return -1;
    }

    public void delete(int index){
        // System.out.println(index);
        // System.out.println(size);
        // System.out.println(data.length);
        if(size == 0){
            return;
        }
        for(int i = index; i < size - 1; i++){
            System.out.println(i);
            data[i] = data[i + 1];
        }
        size--;
    }
}
