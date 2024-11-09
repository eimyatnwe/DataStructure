package labs;

import solutions.code5_Postfix.MyRPN_6601534;

public class Lab5_RPN_Main {
    public static void main(String[] args) {
        String postfixString = "8 5 - 4 2 + 3 / *";
        task2(postfixString);
    }
    static void task2(String postfixString){
        System.out.println(postfixString);
        System.out.println("= " + MyRPN_6601534.computeRPN(postfixString));
    }
}
