package Offer;

/**
 * 旋转数组的最小数字：
 *
 * 把一个数组的最开始的若干元素搬到数组末尾，称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * （数组{3,4,5,1,2} 为{1,2,3,4,5}的一个旋转，该数组最小值为1）
 *
 * 与二分查找的思路类似
 */
public class Offer06_minArray {
    /**
     *
     * @param numbers   旋转数组
     * @return      数组的最小值
     */
    public static int min(int[] numbers){

        //判断输入是否合法
        if(numbers == null || numbers.length == 0){
            throw new RuntimeException("Invaild Input!");
        }

        //第一个位置
        int low = 0;
        //最后一个位置
        int high = numbers.length-1;
        //中间位设置初始值
        int middle = low;

        //确保low位在前一个排好序的部分，high在排好序的后一个部分
        while(numbers[low] >= numbers[high]){

            /**
             * 当处理范围只有两个数字时，返回后一个结果，
             * 因为numbers[low] >= numbers[high]总是成立，所以后一个结果是最小值
             */
            if(high-low == 1){
                return numbers[high];
            }

            //取中间值middle
            middle = low + (high-low)/2;

            /**
             * 如果middle、low、high、三个位置的数据一样，则
             * 需要在这个处理范围内进行顺序查找
             */
            if(numbers[middle]==numbers[low] && numbers[high] == numbers[middle]){
                return minInorder(numbers,low,high);
            }

            /**
             * 如果中间值numbers[middle] >= numbers[low],即
             *      middle位置在前半个排序部分，low=middle 处理范围可进一步缩小
             */
            if(numbers[middle] >= numbers[low]){
                low = middle;
            }

            /**
             * 如果中间值numbers[middle] <= numbers[high]，即
             *      middle位置在后半部分，high=middle 处理范围进一步缩小
             */
            else if(numbers[middle] <= numbers[high]){
                high = middle;
            }
        }
        return numbers[middle];
    }

    /**
     * 对numbers中low到high区间内进行顺序查找最小数字
     * @param numbers   待查找数组
     * @param low       低位
     * @param high      高位
     * @return          该数组在[low,high]区间中的最小数字
     */
    private static int minInorder(int[] numbers, int low, int high) {
        if(low>high){
            throw new RuntimeException("Invailed Input!");
        }
        int temp = numbers[low];
        for(int i=low+1;i<=high;i++){
            if(numbers[i] < temp)
                temp = numbers[i];
        }
        return temp;
    }

    public static void main(String args[]){
        int[] min={4,5,2,3};
        System.out.print(min(min));
    }
}
