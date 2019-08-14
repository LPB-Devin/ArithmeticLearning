package Offer;

/**
 *      在长度为n的数组中的所有数字在0到n-1的范围内，数组中某些数字是
 *  重复的，但并不知道哪些数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 */
public class Offer49_duplicate {
    public static int duplicate(int[] number){

        //输入参数校检
        if(number == null || number.length <2){
            return -1;
        }
        for(int i:number){
            if(i < 0 || i >= number.length){
                return -1;
            }
        }

        for(int i=0; i < number.length ; i++){
            while(number[i] != i){
                //如果i位置和number[i]位置的数字相同，则该数字即重复数字
                if(number[i] == number[number[i]]){
                    return number[i];
                }
                //不同，则交换值
                else{
                    swap(number,i,number[i]);
                }
            }
        }

        //不存在重复值
        return -1;
    }

    /**
     * 交换
     * @param data
     * @param x
     * @param y
     */
    private static void swap(int[] data, int x, int y){
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }
}
