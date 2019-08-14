package Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和正好为s。
 * 注：如果有多对数字的和为s，输出其中任意一对即可
 *
 */
public class Offer39_findNumbersWithSum {
    public static ArrayList<Integer> findNumbersWithSum(int[] datas, int s){
        //参数校验
        if(datas == null || datas.length == 0 || s < datas[0]){
            throw new IllegalArgumentException("输入参数错误！");
        }

        int length = datas.length;
        int leftIndex = 0;
        int rightIndex = length-1;

        ArrayList<Integer> answer = new ArrayList<>(2);

        while(leftIndex < rightIndex){
            int needValue = s - datas[leftIndex];
            while (leftIndex < rightIndex && needValue < datas[rightIndex]){
                rightIndex -- ;
            }
            if(leftIndex < rightIndex && needValue == datas[rightIndex]){
                answer.add(datas[leftIndex]);
                answer.add(datas[rightIndex]);
                break;
            }else if(leftIndex < rightIndex){
                leftIndex ++;
                rightIndex = length-1;
                continue;
            }else{
                throw new IllegalArgumentException("输入参数错误！");
            }
        }
        return answer;
    }
    public static void main(String args[]){
        int[] datas ={1,2,3,4,5,6,7};
        int sum = 7;
        ArrayList<Integer> answer = findNumbersWithSum(datas,sum);
        for(int i:answer){
            System.out.println(i);
        }
    }
}
