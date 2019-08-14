package Offer;

/**
 * 实现一个函数StringToInt，实现把字符串转换成整数这个功能。
 * 注：不能使用atoi或其他类似的库函数
 */
public class Offer47_stringToInt {
    public static int StringToInt(String num){
        if(num == null || num.length() == 0){
            throw new NumberFormatException(num);
        }
        char first = num.charAt(0);
        if(first == '-'){
            return parseString(num,1,false);
        }else if(first == '+'){
            return parseString(num,1,true);
        }else if(first <= '9' && first >= '0'){
            return parseString(num,0,true);
        }else{
            throw new NumberFormatException(num);
        }
    }

    private static int parseString(String num, int index, boolean b) {
        if(index >= num.length()){
            throw new NumberFormatException(num);
        }
        int result;
        long tmp = 0;
        while(index < num.length() && isDigit(num.charAt(index))){
            tmp = tmp * 10 + num.charAt(index)-'0';
            if(tmp > 0x80000000L){
                throw new NumberFormatException(num);
            }
            index ++;
        }
        if(b == true){
            if(tmp >= 0x80000000L){
                throw new NumberFormatException(num);
            }else{
                result = (int)tmp;
            }
        }else{
            if(tmp == 0x8000_0000L){
                result = 0x80000000;
            }else{
                result=(int) - tmp;
            }
        }

        return result;
    }

    public static boolean isDigit(char c){
        if(c>='0' && c<='9'){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String args[]){
        System.out.println(StringToInt("-98343948"));
    }
}
