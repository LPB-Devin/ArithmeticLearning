package Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入n个整数，找出其中最小的k个数
 */
public class Offer27_getLeastkNumber {
    private static class MaxHeap<T extends Comparable<T>>{
        private List<T> items;
        private int cursor;

        public MaxHeap(){
            this(32);
        }
        public MaxHeap(int size){
            items = new ArrayList<>(size);
            cursor = -1;
        }

        /**
         * 向上调整堆
         * @param index
         */
        public void siftUp(int index){
            T intent = items.get(index);

            while(index > 0){
                int parentIndex = (index - 1)/2;
                T parent = items.get(parentIndex);
                if(intent.compareTo(parent) > 0){
                    items.set(index,parent);
                    index = parentIndex;
                }else{
                    break;
                }
            }

            //index此时记录的是最后一个被下放的父节点位置，将最开始调整的元素值放入index位置即可
            items.set(index,intent);
        }

        /**
         * 向下调整堆
         *
         * @param index 被下移元素的起始位置
         */
        public void siftDown(int index){
            T intent = items.get(index);
            int leftIndex = 2 * index + 1;

            while(leftIndex < items.size()){
                T maxChild = items.get(leftIndex);

                int maxIndex = leftIndex;

                int rightIndex = leftIndex + 1;

                if(rightIndex < items.size()){

                    T rightChild = items.get(rightIndex);

                    if(rightChild.compareTo(maxChild) > 0){
                        maxChild = rightChild;
                        maxIndex = rightIndex;
                    }
                }

                if(maxChild.compareTo(intent)> 0){
                    items.set(index,maxChild);
                    index = maxIndex;
                    leftIndex = index *2+1;
                }else{
                    break;
                }



            }

            items.set(index,intent);

        }


        public void  add(T item){
            items.add(item);
            siftUp(items.size() - 1);
        }

        public T deleteTop(){
            if(items.isEmpty()){
                throw new RuntimeException(" ");
            }
            T maxItem = items.get(0);
            T lastItem = items.remove(items.size() - 1);

            if(items.isEmpty()){
                return lastItem;
            }
            items.set(0 , lastItem);
            siftDown(0);
            return maxItem;
        }

        public T next(){
            if(cursor >= items.size()){
                throw new RuntimeException(" ");
            }
            return items.get(cursor);
        }

        public boolean hasNext(){
            cursor++;
            return cursor < items.size();
        }

        public T first(){
            if(items.size() == 0){
                throw new RuntimeException(" ");
            }

            return items.get(0);
        }

        public boolean isEmpty(){
            return items.isEmpty();
        }

        @Override
        public String toString(){
            return items.toString();
        }
    }
}
