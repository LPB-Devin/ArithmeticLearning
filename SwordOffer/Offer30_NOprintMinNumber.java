package Offer;

import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数目，
 * 打印能拼接出的所有数字中最小的一个
 *
 * 注意：正整数已经不包括0了，所以不用考虑最高位为0的情况。
 *
 */
public class Offer30_NOprintMinNumber {

    /**
     * 自定义比较器，实现算法说明的排序原理
     */
    private  static class MComparator implements Comparator<String> {

        /**
         *
         * @param o1
         * @param o2
         * @return  s1.compareTo(s2): >0 则前者s1大, <0 则后者s2大
         */
        @Override
        public int compare(String o1, String o2) {
            if(o1 == null || o2 == null){
                throw new IllegalArgumentException("Arg should not be null");
            }

            String s1 = o1 +o2;
            String s2 = o2 + o1;

            return s1.compareTo(s2);
        }
    }

    /**
     *  快排实现
     * @param array 待排序数组
     * @param start 排序起始位置
     * @param end   排序结束位置
     * @param comparator    自定义的比较器
     */
    private static void quickSort(String[] array,int start,int end,MComparator comparator){
        if(start < end){
            String pivot = array[start];
            int left = start;
            int right = end;
            while(start < end){
                while(start < end && comparator.compare(array[end],pivot) >= 0){
                    end--;
                }
                array[start] = array[end];//start位置的元素值在pivot中,可以直接将其覆盖掉

                while(start < end && comparator.compare(array[start],pivot ) <= 0){
                    start++;
                }
                array[end] = array[start];
            }

            array[start] = pivot;

            quickSort(array,left,start-1,comparator);
            quickSort(array,start+1,right,comparator);
        }
    }

    public static String printMinNumber(String[] array){
        if(array == null || array.length < 1){
            throw  new IllegalArgumentException("Array must contain value");
        }

        MComparator comparator = new MComparator();
        quickSort(array,0,array.length-1,comparator);

        StringBuilder builder = new StringBuilder(256);
        for(String s : array){
            builder.append(s);
        }

        return builder.toString();
    }

    public static void main(String args[]){
        String[] Str = {"5","4","9","2","7","1","8"};
        System.out.println(printMinNumber(Str));
    }
}
