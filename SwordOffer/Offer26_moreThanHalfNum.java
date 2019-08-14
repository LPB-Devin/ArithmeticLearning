package Offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 */
public class Offer26_moreThanHalfNum {
    public static int moreThanHalfNum(int[] numbers){
        //数组校验
        if(numbers == null || numbers.length <1){
            throw new RuntimeException("the Array length must large than 0");
        }

        //以第一个数组元素为起始点
        int result = numbers[0];
        //元素出现相对次数计数
        int count = 1;

        int length = numbers.length;
        for(int i=1;i<length ; i++){
            /**
             * count == 0时，result置为数组当前位置元素，重新计数
             * result == numbers[i]时，计数增加，否则进行抵消
             *
             */
            if(count == 0){
                result = numbers[i];
                count = 1;
            }
            else if(result == numbers[i]){

                count ++;
            }
            else {
                count --;
            }
        }

        count = 0;
        for(int number : numbers){
            if(result == number){
                count ++;
            }
        }

        //确定result元素个数 count>numbers.length/2
        if(count>numbers.length>>1){
            return result;
        }
        else{
            throw new IllegalArgumentException("invalid input");
        }
    }

    public static void main(String args[]){
        int[] num = {3,3,3,4,4,4,4};
        System.out.println(moreThanHalfNum(num));
    }
}
