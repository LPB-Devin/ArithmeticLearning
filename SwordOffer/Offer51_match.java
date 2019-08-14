package Offer;

/**
 * 实现一个函数匹配包含'.'和'*'的正则表达式。其中字符'.'表示任意字符，
 * 而'*'表示它前面的字符可以出现0次或多次。
 * 本题中匹配是指所有字符匹配整个模式。
 * 例如，字符串“aaa”与模式“a.a”和“abaca”匹配，但与“aa.a”及“ab*a”均不匹配。
 */
public class Offer51_match {
    /**
     * 输入串和模式串匹配
     * @param input
     * @param pattern
     * @return
     */
    public static boolean match(String input,String pattern){
        //数据校检
        if(input == null || pattern == null){
            return false;
        }
        return matchCore(input,0,pattern,0);
    }

    /**
     * 对匹配串input和模式串pattern进行匹配。
     *
     * @param input     匹配串
     * @param i         匹配串下标
     * @param pattern   模式串
     * @param p         模式串下标
     * @return
     */
    public static boolean matchCore(String input,int i,String pattern,int p){
        //匹配串和模式串都到达结尾，匹配成功
        if(i >= input.length() && p >= pattern.length()){
            return true;
        }
        //只有模式串到达尾部
        if(i != input.length() && p >= pattern.length()){
            return false;
        }
        //读取模式串的下一个字符为 * 时
        if(p+1 < pattern.length() && pattern.charAt(p+1)=='*'){
            //如果匹配串input已经到结尾部分，对 * 的下一位进行递归判断
            if( i>= input.length()){
                return matchCore(input,i,pattern,p+2);
            }
            else{
                //当匹配串input和模式串pattern所在下标字符相等，或 模式串此时下标位置为任意字符
                if(pattern.charAt(p) == input.charAt(i) || pattern.charAt(p) =='.'){

                    return matchCore(input,i+1,pattern,p+2)
                            //将input的i+1位与pattern中*的下一位判断

                            || matchCore(input,i+1,pattern,p)
                            //将input的i+1位与pattern中的p位（循环）字符

                            || matchCore(input,i,pattern,p+2);
                            //将input的i位与pattern中*的下一位判断
                }else{

                    //如果下标字符不想等且模式串下标字符不为'.'，则判断
                    // input的i位字符是不是 * 的下一位

                    return matchCore(input,i,pattern,p+2);
                }
            }
        }
        //input已经结束
        if(i >= input.length()){
            return false;
        }
        else{
            //input最后一个字符匹配
            if(input.charAt(i) == pattern.charAt(p) || pattern.charAt(p) == '.'){
                return matchCore(input,i+1,pattern,p+1);
            }
        }
        return false;
    }
}
