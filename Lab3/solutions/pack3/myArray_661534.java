package solutions.pack3;

public class myArray_661534 extends MyArrayBasic_661534{
    public myArray_661534(){
        MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
    }
    
    public myArray_661534(int max){
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    public void add(int d){
        if(!isFull()){
            data[size++] = d;
        }else{
            expandByK(2);
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int[] expandByK(int k) {
        
            MAX_SIZE = MAX_SIZE * k;
            int[] newData = new int[MAX_SIZE];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
           
            return data;
        
    }
    public int[] expand(){
        return expandByK(2);
    }
    

    
}
