package Offer;

/**
 * 丑数:只包含因子2、3、5的数为丑数。求从小到大的顺序的第1500个丑数；
 * 注：习惯把1当作第一个丑数。
 *
 */
public class Offer31_UglyNumber {
    /**
     * 消除num中所有2、3、5因子，如果结果 == 1，则返回true
     * @param num
     * @return
     */
    private static boolean isUgly(int num){
        while(num%2==0){
            num /= 2;
        }
        while(num%3==0){
            num /= 3;
        }
        while(num%5==0){
            num /= 5;
        }
        return num == 1;
    }
}
