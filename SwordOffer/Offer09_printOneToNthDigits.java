package Offer;

/**
 * 输入一个整数n，按顺序打印出从1到n位最大十进制数的数值。
 * 如 输入 3，则打印1、2、3……999。
 */
public class Offer09_printOneToNthDigits {
    /**
     * 直接运算，忽略n的数值过大问题
     * 如果10^n的数值超过int、long的大小，就不行了
     * @param n
     */
    public static void printOneToNthDigits(int n){
        int[] num = new int[n];
        for(int i=1 ; i<Math.pow(10,n) ; i++){
            System.out.print(i+"\t");
            if(i%20==0)
                System.out.println();
        }

    }

    /**
     * 第一种解法：
     * 利用数组的形式实现输出，从根本解决n的数值过大问题
     * @param n
     */
    public static void printOneToNthDigits_1(int n){
        if(n<1)
            throw new RuntimeException("Invalid Input!");

        int[] arr = new int[n];
        printOTD(0,arr);
    }

    private static void printOTD(int n, int[] arr) {
        if(n >= arr.length){
            printArray(arr);
        }else{
            for(int i=0;i<=9;i++){
                arr[n] = i;
                printOTD(n+1,arr);
            }
        }
    }

    private static void printArray(int[] arr) {
        int index=0;
        while(index<arr.length && arr[index]==0){
            index++;
        }
        for(int i=index;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        if(index < arr.length){
            System.out.println();
        }
    }


    /**
     * 比上一种方法少用内存空间
     * @param n
     */
    public static void printOneToNthDigits_2(int n){
        if(n<0){
            throw  new RuntimeException("The input number must larger than 0");
        }

        int[] arr = new int[n];

        for(int i=0;i<arr.length;i++){
            arr[i] = 0;
        }

        while(addOne(arr) == 0){
            printArray(arr);
        }
    }

    /**
     * 对arr表示的数值的最低位加1，arr中的每个数都不能超过9、不能少于0
     * 每个位置模拟一个数位
     * @param arr   待加数组
     * @return      判断最高位是否有进位，有则返回1，否则返回0
     */
    private static int addOne(int[] arr) {
        int carry = 1;
        int index = arr.length;

        do{
            index -- ;
            arr[index] += carry;
            carry = arr[index] / 10;
            arr[index] %= 10;
        }while(carry !=0 && index >0);

        //
        if(carry >0 && index == 0){
            return 1;
        }

        //无进位，返回0
        return 0;
    }

    public static void main(String args[]){
//        printOneToNthDigits(7);
        printOneToNthDigits_1(7);
    }
}
