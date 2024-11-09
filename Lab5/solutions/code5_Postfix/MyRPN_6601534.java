package solutions.code5_Postfix;

import java.util.regex.Pattern;
// import solutions.code5_Postfix.MyStackA;

public class MyRPN_6601534 {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static boolean isNumeric(String strNum){
        if(strNum == null){
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn){
        String arr[] = rpn.split(" ");
        MyStackA_6601534 stack = new MyStackA_6601534();
        for(String str : arr){
           if(isNumeric(str)){
                stack.push(Double.parseDouble(str));
           }else{
            double a = stack.pop();
            double b = stack.pop();
            double res = applyOperator(a, b,str);
            stack.push(res);
           }
        }
        return stack.pop();
    }

    private static double applyOperator(double a, double b,String operator){
        switch (operator) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                if(a == 0){
                    throw new ArithmeticException("Division by zero");
                }
                return b / a;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
                
        }
    }

    
}
