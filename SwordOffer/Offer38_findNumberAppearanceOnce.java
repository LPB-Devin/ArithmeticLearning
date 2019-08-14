package Offer;

import java.util.Arrays;

/**
 * 一个整型数组中除了两个数字之外，其他的数字都出现了两次，请找出这两个只出现一次的
 * 数字。
 * 要求：时间复杂度为O（n），空间复杂度为O（1）;
 */
public class Offer38_findNumberAppearanceOnce {
    public static int[] findNumberAppearanceOnce(int[] data){
        if(data == null || data.length <= 0){
            return null;
        }
        int[] ansower = new int[2];
        int addIndex = 0;
        Arrays.sort(data);
        for(int i:data){
            System.out.print(i + "  ");
        }
        int lowIndex = 0;
        int length = data.length;
        if(data[lowIndex] != data[lowIndex+1]){
            ansower[addIndex] = data[lowIndex];
            addIndex++;
        }
        lowIndex++;
        while(lowIndex < length-1){
            if(data[lowIndex] != data[lowIndex-1] && data[lowIndex] != data[lowIndex+1]){
                ansower[addIndex] = data[lowIndex];
                addIndex++;
            }
            lowIndex++;
        }
        if(data[lowIndex] != data[lowIndex-1] && addIndex <2){
            ansower[addIndex] = data[lowIndex];
        }else if(addIndex >= 2){
            throw new RuntimeException(" ………………");
        }
        return ansower;
    }

    public static void main(String args[]){
        int[] arg = {2,4,3,6,3,2,5,5};
        int[] an = findNumberAppearanceOnce(arg);
        for(int i : an){
            System.out.print(i + " ");
        }

    }
}
