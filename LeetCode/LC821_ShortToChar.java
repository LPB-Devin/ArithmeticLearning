package LeetCode;

/**
 *
 * 821.字符的最短距离
 * 给定一个字符串 S 和一个字符 C。
 * 返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * eg:
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 */
public class LC821_ShortToChar {
    public static int[] shorttestToChar(String S,char C){
        String[] sp = S.split("");
        Integer longth = sp.length;
        int[] distanceToC = new int[longth];
        for(int i=0 ; i<longth ; i++) {
            Integer jl = 0, jr = 0;
            Integer distanceToLeft = Integer.MAX_VALUE;
            Integer distanceToRight = Integer.MAX_VALUE;
            while (jl <= i) {
                if (sp[i - jl].charAt(0) == C) {
                    distanceToLeft = jl;
                    break;
                }
                jl++;
            }

            while ((i + jr) < longth) {
                if (sp[i + jr].charAt(0) == C) {
                    distanceToRight = jr;
                    break;
                }
                jr++;
            }
            distanceToC[i] = distanceToLeft > distanceToRight ? distanceToRight : distanceToLeft;
        }
        return distanceToC;
    }

    public static void main(String[] args) {
        int[] sout = shorttestToChar("leetcode",'o');
        for(int i : sout){
            System.out.print(i+"\t");
        }
    }
}
