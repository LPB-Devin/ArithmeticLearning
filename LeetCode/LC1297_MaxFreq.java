package LeetCode;

/**
 * @auther Devin LinPaibin
 * @date 2020/1/2 .10:40
 *
 *
 * Given a string s, return the maximum number of ocurrences of any substring 
 * under the following rules:
 * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
 *
 * 1.The number of unique characters in the substring must be less than or
 * equal tomaxLetters.
 * 1、子串中不同字母的数目必须小于等于 maxLetters 。
 *
 * 2.The substring size must be between minSize and maxSize inclusive.
 * 2、子串的长度必须大于等于 minSize 且小于等于 maxSize 。
 *
 *eg：
 * Example 1:
 * Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * Output: 2
 * Explanation: Substring "aab" has 2 ocurrences in the original string.
 * It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
 *
 * Example 2:
 * Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * Output: 2
 * Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
 *
 * Example 3:
 * Input: s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * Output: 3
 *
 * Example 4:
 * Input: s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * Output: 0
 *
 * Constraints 提示：
 * 1 <= s.length <= 10^5
 * 1 <= maxLetters <= 26
 * 1 <= minSize <= maxSize <= min(26, s.length)
 * s only contains lowercase English letters.
 *  字符串s 只能包含英文字母
 */
public class LC1297_MaxFreq {

    public static void maxFreq(String s,int maxLetters,int minSize,int maxSize){

    }
}
