package LeetCode;
/**
 * （10） 正则表达式匹配
 * 1、模式串为空时，字符串为空，则匹配成功，否则匹配失败
 * 2、模式串只有一个字符时，只有字符串也为一个且与模式串字符相同，或者模式串剩余字符为'.'则匹配成功
 * 3、
 */
public class LC10_IsMatch {
    /**
     * 
     * @param s     模式串
     * @param p     字符串
     * @return
     */
    public static boolean isMatch(String s, String p) {

        if (p.isEmpty()) { // 当模式串为空时，字符串为空，则匹配成功，否则匹配失败
            return s.isEmpty();
        } 
        else if (p.length() == 1) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        } 
        else if (p.charAt(1) != '*') { // 判断模式串第二位不为 * 的情况
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    && isMatch(s.substring(1), p.substring(1));
        } 
        else // 判断当模式串第二位为 * 的情况
        {
            while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) { // 若后序字符串匹配成功则返回 true
                    return true;
                }
                s = s.substring(1); // 消除字符串与模式串当前字符相等字符
            }
            return isMatch(s, p.substring(2)); // 继续匹配后序字符串
        }
    }

    public static void main(String[] args) {
        String s = "a";
        String p = "a*";
        System.out.println(isMatch(s, p));

        int sum = 0;
        int num = 1;
        while(num<101){
            sum += num;
            num++;
        }
        System.out.println(sum);
    }
}