package Offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等
 */
public class Offer19_StackTest {
    public static boolean sequenseIsPop(int[] data1 , int[] data2){

        //第一个序列为空，表示栈空情况
        if(data1 == null){
            if(data2 == null)
                return true;
            else
                return false;
        }

        //两个序列长度不同
        else if(data1.length!=data2.length){
            return false;
        }
        else {
            Stack<Integer> helpstack = new Stack<>();
            //将第一个序列按顺序压入栈中
            for (int i : data1) {
                helpstack.push(i);
            }

            //将栈的弹出顺序与第二个序列一一进行比较
            int length2 = data2.length;
            for (int i = 0; i < length2; i++) {
                if (helpstack.peek() != data2[i])
                    return false;
                helpstack.pop();
            }

            return true;
        }
    }

    public static void main (String args[]){
        int[] test1 = {1,2,3,4};
        int[] test2 = {0,4,3,2,1};
        System.out.println(sequenseIsPop(test1,test2));
    }
}
