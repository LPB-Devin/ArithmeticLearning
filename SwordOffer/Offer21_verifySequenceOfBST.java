package Offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 是则返回true，否则返回false。
 * 注：假设输入的数组的任意两个数字都互不相同。
 */
public class Offer21_verifySequenceOfBST {
    /**
     *判断是否存在数据，不存在直接返回，存在则做进一步判断
     * @param sequence
     * @return
     */
    public static boolean verifySequenceOfBST(int[] sequence){
        //序列为空，或者长度为0，均返回正确结果
        if(sequence  == null || sequence.length == 0){
            return true;
        }

        //存在数据，调用辅助方法进行判断
        else{
            return verifySequenceOfBST(sequence,0,sequence.length-1);
        }

    }

    /**
     *
     * @param sequence  目标序列
     * @param start     判断范围[start,end]
     * @param end
     * @return
     */
    private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        //处理的数据只有一个，或者已没有出需要处理，则返回true
        if(start >= end){
            return true;
        }

        //找到根节点（sequence[end]）的右子树的位置
        int index = start;
        while(index<end-1 && sequence[index] < sequence[end]){
            index++;
        }

        //对右子树中的所有节点进行判断是否大于根节点，否则跳出
        int right = index;
        while(index<end-1 && sequence[index] > sequence[end]){
            index++;
        }

        //如果当前该根节点存在子节点不符合二叉搜索树的性质，返回false
        if(index!=end-1){
            return  false;
        }
        else{//符合二叉搜索树性质，对其左子树和右子树进一步判断
            index = right;
            return verifySequenceOfBST(sequence,start,index-1)
                    && verifySequenceOfBST(sequence , index , index-1);
        }

    }

    public static void main(String args[]){
        int[] arg = {1,2,4,7,5,3};
        System.out.print(verifySequenceOfBST(arg));
    }
}
