package Offer;

/**
 * 统计一个数字在排序数组中出现的次数
 */
public class Offer35_getFirstK {
    /**
     * 查找排序数组中k第一次出现的位置
     *
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getFirstK(int[] data , int k,int start , int end){
        if(data == null || data.length < 1 || start > end){
            return -1;
        }
        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];
        if(midData == k){
            if(midIdx > 0 && data[midIdx] != k || midIdx == 0){
                return midIdx;
            }else{
                end = midIdx - 1;
            }
        }else if(midData > k){
            end = midIdx -1;
        }else{
            start = midIdx + 1;
        }
        return getFirstK(data,k,start,end);
    }

    /**
     * 查找数组中k出现的最后位置
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getLastK(int[] data,int k,int start , int end){
        if(data == null || data.length < 1 || start > end){
            return -1;
        }
        int midIdx = start + (end - start) /2;
        int midData = data[midIdx];

        if(midData == k){
            if(midIdx + 1<data.length && data[midIdx + 1] !=k || midIdx == data.length -1 ){
                return midIdx;
            }else{
                return midIdx +1;
            }
        }else if(midData < k){
            start = midIdx +1;
        }else{
            end = midIdx -1;
        }
        return getLastK(data,k,start,end);
    }

    /**
     * 统计 k 在数组中出现的次数
     * @param data
     * @param k
     * @return
     */
    public static int getNumberOfK(int [] data,int k){
        int number = 0;
        if(data != null && data.length > 0){
            int first = getFirstK(data,k,0,data.length-1);
            int last = getLastK(data,k,0,data.length -1);

            if(first > -1 && last> -1){
                number = last - first +1;
            }
        }
        return number;
    }

    public static int getNumberOfKBySelf(int[] data,int k){
        if(data == null || data.length == 0){
            return -1;
        }
        int length = data.length;
        int left = data[0];
        int right = data[length -1];
        if(left == right){
            return data.length;
        }else{
            int lowIndex = 0;
            int highIndex = length-1;
            while(data[lowIndex] != k){
                lowIndex ++;
            }
            while(data[highIndex] != k){
                highIndex --;
            }
            if(lowIndex > highIndex){
                return -1;
            }else{
                return highIndex - lowIndex + 1;
            }
        }
    }

    public static void  main(String args[]){
        int[] num = {1,2,3,3,3,3,4};
        System.out.println(getNumberOfKBySelf(num,3));
    }
}
