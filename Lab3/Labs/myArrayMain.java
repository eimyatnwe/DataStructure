package Labs;
import solutions.pack3.*;
public class myArrayMain extends MyArrayBasic_661534 {
    public static void main(String[] args) {
        System.out.println("-demo1--------");
        arrayBasic_demo1();
        System.out.println("-demo2--------");
        arrayBasic_demo2();
        System.out.println("-demo3--------");
        // arrayBasic_demo3();
        System.out.println("-demo4--------");
        myArray_demo4();
        System.out.println("-task2--------");
        task2();
        task2();
        task2();

    }
    static private void arrayBasic_demo1() {
        MyArrayBasic_661534 demo = new MyArrayBasic_661534(7,6,8,1,2,3);
        System.out.println(demo);
    }
    static private void arrayBasic_demo2() {
        MyArrayBasic_661534 demo = new MyArrayBasic_661534();
        demo.insert(9, 0);
        demo.insert(7,0);
        demo.insert(5,0);
        System.out.println(demo);
        System.out.println("5 is at " + demo.find(5));
        System.out.println("5 is at " + demo.binarySearch(5));
        demo.delete(1);
        System.out.println(demo);
    }
    static private void arrayBasic_demo3() {
        MyArrayBasic_661534 demo = new MyArrayBasic_661534(null);
        try{
            demo.add(3);
            demo.add(7);
            demo.add(5);
            demo.add(4);
            demo.add(6);
        //index out of bound due to overflow
            demo.add(1); 
        }catch(Exception e){
            System.out.println("index out of bound due to overflow");
        }

    }
    static private void myArray_demo4() {
        myArray_661534 demo = new myArray_661534(5);
        demo.delete(0); // not crashed
        demo.add(3);
        demo.add(7);
        demo.add(5);
        demo.add(4);
        demo.add(6);
        demo.add(1);        // not crashed
        System.out.println(demo);
    }
    static private void task2() {
        int initial = 1_000_000;
        int step = initial;
        for (int N = initial; N <= 10 * initial; N += step) {
            long start = System.currentTimeMillis();
            myArray_661534 mArray = new myArray_661534(N);
            for (int n = 1; n <N; n++)
                mArray.add((int)(Math.random()*1000));
            long time = (System.currentTimeMillis() - start);
            System.out.println(N + "\t\t" + time);
        }
        System.out.println("with expansion");
        for (int N = initial; N <= 10 * initial; N += step) {
            long start = System.currentTimeMillis();
            myArray_661534 mArray = new myArray_661534();
            for (int n = 1; n <N; n++)
                mArray.add((int)(Math.random()*1000));
            long time = (System.currentTimeMillis() - start);
            System.out.println(N + "\t\t" + time);
        }
    }
}
