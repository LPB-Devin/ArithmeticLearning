package Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正数s，打印所有和为s的连续正数序列（序列至少有两个数）
 */
public class Offer40_findContinuousSequence {
    public static List<List<Integer>> findContinuousSequence(int s){
        if(s <= 3){
            throw new IllegalArgumentException("Error: Invailed Input!");
        }

        List<List<Integer>> result = new ArrayList<>();
        int small = 1;
        int big = 2;
        int middle = s/2;
        int curSum = small + big;

        //最小值small不能超过s的一半middle
        while(small < middle){
            //当前和curSum 等于 所求值s
            if(curSum == s){
                List<Integer> list = new ArrayList<>(2);
                for(int i=small;i<=big;i++){
                    list.add(i);
                }
                result.add(list);
            }
            //当前和curSum大于s，
            while(curSum > s && small < middle){
                //curSum减去低位small
                curSum -= small;
                small ++;
                if(curSum == s){
                    List<Integer> list = new ArrayList<>(2);
                    for(int i=small;i<=big;i++){
                        list.add(i);
                    }
                    result.add(list);
                }
            }

            big ++;
            curSum += big;
        }
        return result;
    }
    public static void main(String args[]){
        List<List<Integer>> lists = findContinuousSequence(17);
        for(List<Integer> list:lists){
            for(int i:list){
                System.out.print(i +" ");
            }
            System.out.println();
        }
    }
}
