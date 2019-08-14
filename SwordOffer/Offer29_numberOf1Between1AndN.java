package Offer;

/**
 * 输入一个整数，求从1到n这n个整数的十进制中1的出现次数
 */
public class Offer29_numberOf1Between1AndN {

    /**
     *
     * @param n 输入
     * @return  1到n中，1出现的次数
     */
    public static int numberOf1Between1ToN(int n){
        if(n<0){
            return numberOf1Between1ToN(0-n)+1;
        }

        String value = n+"";
        int[] numbers = new int[value.length()];

        for(int i=0;i<numbers.length;i++){
            numbers[i] = value.charAt(i) - '0';
        }

        return numberOf1(numbers,0);
    }

    /**
     * 0-numbers表的数字中的1的个数
     *
     * @param numbers   数字数组
     * @param curIdx    当前处理的位置
     * @return          1的个数
     */
    private static int numberOf1(int[] numbers, int curIdx) {
        if(numbers == null || curIdx >= numbers.length || curIdx < 0){
            return 0;
        }
        //待处理的第一个数字
        int first = numbers[curIdx];

        //要处理的数字位数，数组长度-当前下标
        int length = numbers.length - curIdx;

        //如果只有一位且这一位为0，返回0
        if(length == 1 && first > 0){
            if(first > 0){
                return 0;
            }else if(first == 0){
                return 1;
            }
        }


        // numFirstDigit 记数字中第一位中的数目
        int numFirstDigit = 0;
        //最高位first大于
        if(first > 1){
            numFirstDigit = (int) Math.pow(10,length-1);
                    //powerBase10(length - 1);
        }else if(first == 1){//
            numFirstDigit = atoi(numbers , curIdx + 1) + 1;
        }

        int numOtherDigits = first * (length - 1) * (int)Math.pow(10,length-2);
                //powerBase10(length - 2);

        int numRecursize = numberOf1(numbers , curIdx + 1);

        return numFirstDigit + numOtherDigits + numRecursize;
    }

    /**
     *
     * @param n
     * @return
     */
    private static int powerBase10(int n) {
        int result = 1;
        for(int i = 0;i<n;i++){
            result *= 10;
        }
        return result;
    }

    /**
     * 将数字数组转换为数值
     * @param numbers   数组
     * @param i
     * @return
     */
    private static int atoi(int[] numbers,int i){
        int result = 0;
        for(int j=i;j < numbers.length;j++){
            result = (result * 10 + numbers[j]);
        }
        return result;
    }

    public static void main(String args[]){
        int a = 12;
        System.out.println(numberOf1Between1ToN(a));
    }
}
