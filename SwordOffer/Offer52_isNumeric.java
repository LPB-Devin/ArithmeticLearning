package Offer;

/**
 * 实现一个函数，判断字符串是否表示数值（包括整数和小数）
 */
public class Offer52_isNumeric {
    public static boolean isNumeric(String string){
        //数据校验
        if(string == null || string.length() < 1){
            return false;
        }
        int index = 0;

        //判断string开头是否存在 +/-符号
        if(string.charAt(index) == '+' || string.charAt(index) =='-'){
            index ++;
        }
        //以 +\- 结尾，返回false
        if(index >= string.length()){
            return false;
        }
        
        boolean numeric = true;

        index = scanDigits(string,index);
        
        if(index < string.length()){
            if(string.charAt(index) == '.'){    //扫描到'.'小数点
                index++;
                index = scanDigits(string,index);
                
                if(index >= string.length()){
                    numeric = true;
                }
                else if(index < string.length() && 
                        (string.charAt(index)=='e' || string.charAt(index) == 'E')){
                    numeric = isExponential(string,index);
                }else{
                    numeric =false;
                }
            }
            else if(string.charAt(index) == 'e' || string.charAt(index) == 'E'){    //扫描到指数符号
                numeric = isExponential(string,index);
            }else{  //除了小数点,指数e/E 的其他符号
                numeric = false;
            }
            return numeric;
        }else{
            return true;
        }
    }

    /**
     * 对科学计数法的判断，判断是否是科学计数法的结尾部分
     * @param string    字符串
     * @param index     开始匹配的位置
     * @return      匹配结果
     */
    private static boolean isExponential(String string, int index) {
        if(index >= string.length()
                || (string.charAt(index) != 'e' && string.charAt(index) != 'E')){
            return false;
        }
        index ++;

        //以 E\e 结尾，返回false
        if(index >= string.length()){
            return false;
        }

        if(string.charAt(index) == '+' || string.charAt(index) == '-'){
            index ++;
        }

        //以 +\- 结尾，返回false
        if(index >= string.length()){
            return false;
        }

        index = scanDigits(string,index);

        //到达尾部，返回true；否则返回false
        return index >= string.length();
    }

    /**
     * 扫描、跳过数字部分
     *
     * @param string
     * @param index
     * @return
     */
    private static int scanDigits(String string, int index) {
        while(index < string.length() && string.charAt(index) >= '0' && string.charAt(index) <= '9'){
            index ++;
        }
        return index;
    }
}
