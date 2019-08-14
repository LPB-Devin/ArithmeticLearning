package Offer;

/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制中1的个数
 * 15
 * 1111
 */
public class Offer08_NumberOfOne {
    /**
     * 整数 n 有32位，对二进制中的每一位与 1 进行与运算，
     * @param n
     * @return
     */
    public static int NumberOfOne(int n){
        int result = 0;
        for(int i=0;i<32;i++){
            result += (n & 1);
            n = n>>1;
        }
        return result;
    }

    /**
     * (n-1)&n运算可以消掉n的二进制表示中最右/低的一位 1
     * @param n
     * @return
     */
    public static int NumberOfOne2(int n){
        int result = 0;
        while(n!=0){
            result ++;
            n = (n-1)&n;
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(NumberOfOne(15));
        System.out.println(NumberOfOne2(24));
    }
}
