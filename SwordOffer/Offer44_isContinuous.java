package Offer;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是同一个顺子，即这五张牌是不是连续的。
 * 2-10为数字本身，A为1，J为11，Q为12，K为13.大小王可以看成任意数字。
 */
public class Offer44_isContinuous {
    /**
     *
     * 情况举例：
     * - 抽取牌数不等于5
     * - 抽到几张百变王牌（王牌数 == 允许填补的顺序 空缺数）
     * - 是否抽到重复数字的牌
     * @param numbers
     * @return
     */
    public static boolean isContinuous(int[] numbers){
        if(numbers == null || numbers.length != 5){
            return false;
        }
        Arrays.sort(numbers);

        int numberOfZero = 0;   //王牌张数
        for(int i=0;i<5 && numbers[i] == 0;i++){
            numberOfZero ++;
        }
        if(numberOfZero > 2){
            return false;
        }

        int numberOfGap = 0;
        int low = numberOfZero;
        int high = low+1;
        while(high < 5){
            if(numbers[low] == numbers[high]){
                return false;
            }
            numberOfGap += numbers[high] - numbers[low] -1;
            low = high;
            high ++;
        }

        return numberOfGap <= numberOfZero;
    }

    public static void main(String[] args){
        int[] data = {1,4,5,2,0};
        System.out.println(isContinuous(data));
    }
}
