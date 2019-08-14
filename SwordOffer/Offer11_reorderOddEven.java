package Offer;

/**
 * 输入一个整型数组，实现一个函数对该数组中数字的顺序进行调整
 * 使所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 *
 */
public class Offer11_reorderOddEven {
    public static void reorderOddEven(int[] arr){

        if(arr==null || arr.length <2){
            return;
        }

        int low = 0;
        int high = arr.length-1;

        while(low < high){
            //low低位为奇数,注意：循环时候注意低位小于高位的条件
            while((arr[low]&1) == 1 && low<high){
                low++;
            }
            //high高位为偶数
            while((arr[high]&1) == 0 && low<high){
                high--;
            }
            swap(arr,low,high);
        }
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6};
        reorderOddEven(arr);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
