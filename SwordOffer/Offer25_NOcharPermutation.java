package Offer;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 如：输入字符串abc，则打印出adb、acb、bac、bca、cab、cba。
 */
public class Offer25_NOcharPermutation {
    public static void permutation(char[] chars){
        //chars校验
        if(chars == null || chars.length <1){
            return ;
        }

        //排列操作
        permutation(chars , 0);
    }


    /**
     * 递归解法：
     * 1、首先求所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换
     * 2、仍把后面的所有字符分成两部分，后面字符的第一个字符，以及这个字符之后的所有字符。
     *
     * @param chars
     * @param begin
     */
    private static void permutation(char[] chars, int begin) {
        //最后一个元素，输出结果
        if(chars.length -1 == begin){
            System.out.print(new String(chars) + " ");
        }
        else{
            //对当前未处理的字符串进行处理，每个字符都可作为当前位置的元素
            char tmp;
            //
            for(int i= begin ; i<chars.length ; i++){
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;

                //对下一个位置递归处理
                permutation(chars , begin+1);

                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;
            }
        }
    }

    public static void main(String args[]){
        char[] abc = {'a','b','c'};
        permutation(abc);
    }
}
