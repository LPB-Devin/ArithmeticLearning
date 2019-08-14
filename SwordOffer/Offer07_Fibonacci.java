package Offer;

/**
 * 斐波那契数列获取第n项式的值。
 * f0 = 0,f1 = 1;
 * f(n) = f(n-1) + f(n-2)
 *
 * 可以用循环或递归实现
 */
public class Offer07_Fibonacci {
    /**
     * 循环实现 斐波那契数列求第n项值
     * @param n
     * @return
     */
    public static int FibonacciByCycle(int n){
        if(n < 0){
            throw new RuntimeException("Invaild Input!");
        }
        else if(n==1 || n==2){
            return n-1;
        }
        else{
            int first = 0;
            int after = 1;
            int index=2;
            while(index<n){
                int temp = first + after;
                first = after;
                after = temp;
                index++;
            }
            return after;
        }
    }

    /**
     * 使用递归实现斐波那契
     * @param n
     * @return
     */
    public static int FibonacciByRecursion(int n){
        if(n<0){
            throw new RuntimeException("Invaild Input!");
        }
        else if(n==1||n==2){
            return n-1;
        }
        else{
            return FibonacciByRecursion(n-1)+FibonacciByRecursion(n-2);
        }
    }

    //数值：0 1 1 2 3 5 8 13
    //位置：1 2 3 4 5 6 7 8
    public static void main(String args[]){
        System.out.println(FibonacciByCycle(7));
        System.out.println(FibonacciByRecursion(7));
    }
}
