package Offer;

/**
 * 实现一个函数找出字符流中第一个只出现一次的字符。
 * eg:  当从字符流中只读出前两个字符“Go”时，第一个只出现一次的字符是‘g’。当
 * 从该字符流中读出前六个字符“google”时，第一个只出现1次的字符是”l”。
 */
public class Offer53_FirstAppearOnceChar {
    public static class CharStatistics{

        private int index = 0;
        private int[] occurrence = new int[256];

        public CharStatistics(){
            for(int i=0;i < occurrence.length;i++){
                occurrence[i] = -1;
            }
        }
    }

    public static char FirstAppearOnceChar(String str){
        if(str == null || str.length() == 0 ){
            throw new IllegalArgumentException("NULL String");
        }
        if(str.length() ==1){
            return str.charAt(0);
        }
        int[] occurrence = new int[256];
        int length = str.length();
        for(int i=0;i<length ; i++){
            occurrence[i] = 0;
        }

        //遍历一次字符串，计数并存入数组
        for(int i =0; i<length ; i++){
            occurrence[str.charAt(i)-'\0'] += 1;
        }

        //检查数组
        for(int i=0;i<length;i++){
            //检查到 1 便返回结束
            if(occurrence[str.charAt(i)-'\0'] == 1){
                return str.charAt(i);
            }
        }
        throw new IllegalArgumentException("Not The Char that Appear Once in the string");
    }

    public static void main(String[] args) {
        String str = "fgnajfjinsaig";
        System.out.println(FirstAppearOnceChar(str));
    }
}
