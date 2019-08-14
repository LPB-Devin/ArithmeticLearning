package Offer;

import java.util.HashMap;

/**
 * 求一个字符串中第一个不重复的字符。
 */
public class Offer32_firstNotRepeatingChar {
    public static char firstNotRepeatingChar(String s){
        HashMap<String,Integer> hashMap = new HashMap<>();
        String[] str = s.split("");
        for(String substr : str){
            if(hashMap.containsKey(substr)){
                int value = hashMap.get(substr);
                value ++;
                hashMap.put(substr,value);
            }else{
                hashMap.put(substr,1);
            }
        }
        for(String substr:str){
            if(!hashMap.containsKey(substr)){
                throw new RuntimeException("运行异常：该元素未被录入哈希表中！");
            }
            else if(hashMap.get(substr) == 1){
                return substr.charAt(0);
            }
            else{
                continue;
            }
        }
        throw new IllegalArgumentException("Not Char OR havn`t NotRepeatingChar");
    }

    public static void main(String args[]){
        String string = "123456123456";
        System.out.println(firstNotRepeatingChar(string));
    }
}
