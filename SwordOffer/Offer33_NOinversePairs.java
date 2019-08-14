package Offer;

/**
 * weilijie
 * 数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 * eg：
 * {7,5,6,4}中,一共存在5个逆序对,分别是{7,6},{7,5},{7,4},{6,4},{5,4}
 *
 */
public class Offer33_NOinversePairs {
    public static int inversePairs(int[] data){
        if(data == null || data.length == 0){
            throw new IllegalArgumentException("Array arg should contain at least a value");
        }
        int[] copy = new int[data.length];

        System.arraycopy(data,0,copy,0,data.length);

        return inversePairsCore(data,copy,0,data.length-1);

    }

    private static int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if(start == end){
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;
        int left = inversePairsCore(copy,data,start,start+length);
        int right = inversePairsCore(copy,data,start+length+1,end);

        int i = start+ length;
        int j = end;
        int indexCopy = end;
        int count = 0;

        while(i >= start && j>=start+length+1){
            if(data[i]>data[j]){
                copy[indexCopy] = data[i];
                indexCopy -- ;
                i--;
                count += j - (start + length);
            }else{
                copy[indexCopy] = data[j];
                indexCopy--;
                j--;
            }
        }

        for(;i>=start;i--){
            copy[indexCopy] = data[i];
            indexCopy--;
            i--;
        }
        for(;j>=start+length+1;j--){
            copy[indexCopy] = data[j];
            indexCopy--;

        }

        return count + left + right;
    }

    public static void main(String args[]){
        int[] data = {7,6,5,4};
        System.out.println(inversePairs(data));
    }
}
