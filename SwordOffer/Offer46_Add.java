package Offer;

/**
 * 求两个整数之和，要求函数体内不得使用+、-、*、/四则运算。
 */
public class Offer46_Add {
    public static int add(int a,int b){
        int sum;
        int carry;
        do{
            sum =a ^b;
            carry = (a & b) <<1;

            a = sum;
            b = carry;
        }while(b != 0);

        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(5,3));
    }
}
