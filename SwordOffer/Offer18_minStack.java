package Offer;

import java.util.Stack;

/**
 *
 *  定义一个栈的数据结构，再该类型中实现一个能够得到栈的最小数的min函数，
 * 在该栈中，调用min、push、pop的时间复杂度都是O（1）
 *
 */
public class Offer18_minStack {
    public static class minStack{
        Stack<Integer> mainStack;
        Stack<Integer> helpStack;
        public minStack(){
            mainStack = new Stack<>();
            helpStack = new Stack<>();
        }

        /**
         *
         * @return
         */
        public int min(){
            if(!helpStack.isEmpty()){
                return helpStack.peek();
            }
            else{
                throw new RuntimeException("the Stack is Empty!");
            }

        }

        /**
         *
         * @param val
         */
        public void push(int val){

            if(!mainStack.isEmpty() && !helpStack.isEmpty() && mainStack.size() == helpStack.size()){
                mainStack.push(val);
                if(helpStack.peek()>val){
                    helpStack.push(val);
                }else{
                    helpStack.push(helpStack.peek());
                }
            }else if(mainStack.isEmpty() && helpStack.isEmpty()){
                mainStack.push(val);
                helpStack.push(val);
            }else if(mainStack.size() != helpStack.size()){
                throw new RuntimeException("The dataStruct of the minStack is Error");
            }
        }

        public int pop(){
            if(mainStack.isEmpty() && helpStack.isEmpty()){
                throw new RuntimeException("Pop Error: The Stack have not Data!");
            }
            else if(mainStack.size() != helpStack.size()){
                throw new RuntimeException("The dataStruct of the minStack is Error");
            }else{
                helpStack.pop();
                return mainStack.pop();
            }
        }
    }

    public static void main(String args[]){
        minStack mStack = new minStack();

        for(int i=10;i>1;i--){
            mStack.push(i);
            mStack.min();

            System.out.println(mStack.min());
        }
        System.out.println(mStack.pop());
        System.out.println(mStack.min());

    }
}
