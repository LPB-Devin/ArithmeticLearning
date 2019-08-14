package Offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列，实现队列的两个函数appendTail和deleteHead
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 */
public class Offer05_MList {
    public static class MList<T>{
        //用于队尾插入节点元素
        private Stack<T> stack1 = new Stack<>();
        //弹出栈，用于弹出、返回队头元素
        private Stack<T> stack2 = new Stack<>();

        public MList(){

        }

        /**
         * 添加队尾节点
         * @param t
         */
        public void appendTail(T t){
            stack1.push(t);
        }

        /**
         * 删除并返回队列头节点
         * @return
         */
        public T deleteHead(){

            /**
             * 弹出栈stack2为空时，从插入栈stack1中弹出所有元素节点并转移到stack2中，
             * 在进行删除队头节点操作。
             */
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            if(stack2.isEmpty())
                throw new RuntimeException("Not Data In Queue!");

            return stack2.pop();
        }

        /**
         * 当插入栈和弹出栈都为空时，才能判断该队列为空
         * @return
         */
        public boolean isEmpty(){
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    public static void main(String args[]){
        MList<Integer> mList = new MList<>();
        for(int i=0;i<4;i++){
            mList.appendTail(i);
        }
        while(!mList.isEmpty()){
            System.out.print(mList.deleteHead()+" ");
        }
    }
}
