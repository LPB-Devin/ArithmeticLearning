package Offer;

/**
 * 连续子数组的最大和
 * 输入一个整形数组，数组中有整数也有负数。数组中一个或连续多个整数组成一个子数组。
 * 求，所有子数组的和的最大值。
 * 要求：时间复杂度为O（n）
 *
 */
public class Offer28_findGreatestSumOfSubArray {

    public static int findGreatestSumOfSubArray(int[] array){
        //参数检验，数组为空或者长度为0时，抛出异常
        if(array == null || array.length == 0){
            throw new IllegalArgumentException(" ");
        }
        //记录最大子数组和，开始时是最小的整数
        int max = Integer.MIN_VALUE;

        //当前的和
        int curMax = 0;

        //
        for(int i:array){
            //如果当前和 < 0 ，便从当前元素开始重新计算；否则进行累加
            if(curMax < 0 ){
                curMax = i;
            } else{
                curMax += i;
            }

            //更新记录到的最大连续子数组和
            if(max < curMax){
                max = curMax;
            }
        }
        return max;
    }
}
