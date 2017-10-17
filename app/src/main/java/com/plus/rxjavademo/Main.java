package com.plus.rxjavademo;

/**
 * Created by Administrator on 2017/5/25.
 */

public class Main {

    private static int sum = 3;//台阶数
    private static int deep = 3;//一次跳的阶数
    private static int total = 0;//总跳法
    private int mTest = 0x0001;

    public static void main(String[] args){
        doComputeDeep(sum, "");
        System.out.print("\n"+sum+"个台阶，一次跳1~"+deep+"阶，共 = " + total + "种跳法");
        System.out.print("\n fib = " + fib(5));
        System.out.print("\n fib2 = " + fib(0,1,5));

    }

    private static void doComputeDeep(int n, String sb){
        if(n < 0) return;
        if(n == 0){
            total++;
            System.out.print("\n跳法：  " + sb);
            return;
        }else {
            for (int i = 1; i <= (n < deep ? n : deep); i++){
                doComputeDeep(n-i, sb+i);
            }
        }
//        else if(n == 1){
//            doComputeDeep(n-1, sb+"1");
//        }else{
//            doComputeDeep(n-1, sb+"1");
//            doComputeDeep(n-2, sb+"2");
//        }
    }

    //斐波那契
    private static int fib(int n){
        if(n == 0 || n == 1)
            return 1;
        else
            return fib(n - 2) + fib(n - 1);
    }

    private static int fib(int a, int b, int n){
        if(n == 0)
            return b;
        else
            return fib(b, a+b, n-1);
    }
}
