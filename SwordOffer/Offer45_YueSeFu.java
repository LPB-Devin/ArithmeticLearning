package Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 约瑟夫环问题
 * 0，1，2，3……n-1 这n个数字排成一个圈圈，从0开始每次从圈中删除第m个子。
 * 求该圈中剩下的最后一个数字。
 */
public class Offer45_YueSeFu {
    /**
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n,int m){
        if(n<1 || m<1){
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i<n;i++){
            list.add(i);
        }
        int idx = 0;

        while(list.size() > 1){
            for(int i = 0;i<m;i++){
                idx = (idx +1) % list.size();
            }

            list.remove(idx);
        }
        return list.get(0);
    }

    public static int lastRemaining1(int n,int m){
//        if(n == 1){
//            return 1;
//        }
//        else {
//            return (lastRemaining1(n-1 , m)+m)%n;
//        }
        int p=0;
        for(int i=2;i<=n;i++){
            p=(p+m)%i;
        }
        return p+1;
    }


    public static void main(String args[]){
        int n=4;
        int m=3;
        System.out.println(lastRemaining(n,m));
        System.out.println(lastRemaining1(n,m));
    }
}
