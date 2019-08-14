package Offer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字的顺序不变。
 * 标点符号与普通字母一样处理。
 * ??
 */
public class Offer41_reverseSentence {
    public static String reverseSentence(String sentence){
        if(sentence == null || sentence.length()==0){
            return null;
        }
        String[] senTemp = sentence.split(" ");

        return reverseSentence(senTemp);
    }

    /**
     *
     * @param data
     * @return
     */
    public static char[] reverseSentence(char[] data) {
        if (data == null || data.length < 1) {
            return data;
        }
        reverse(data, 0, data.length - 1);
        int start = 0;
        int end = 0;
        while (start < data.length) {
            if (data[start] == ' ') {
                start++;
                end++;
            } else if (end == data.length || data[end] == ' ') {
                reverse(data, start, end - 1);
                end++;
                start = end;
            } else {
                end++;
            }
        }
        return data;
    }
    /**
     * 将data中start到end之间的数字反转
     *
     * @param data
     * @param start
     * @param end
     */
    public static void reverse(char[] data, int start, int end) {
        if (data == null || data.length < 1 || start < 0 || end > data.length || start > end) {
            return;
        }
        while (start < end) {
            char tmp = data[start];
            data[start] = data[end];
            data[end] = tmp;
            start++;
            end--;
        }
    }

    private static String reverseSentence(String[] senTemp) {
        int length = senTemp.length-1;
        int low = 0;
        int high = senTemp.length-1;
        while(low < high){
            String temp = senTemp[low];
            senTemp[low] = senTemp[high];
            senTemp[high] = temp;
            low++;
            high--;
        }
        String answer = "";
        for(String str:senTemp){
            answer += " "+ str;
        }
        return answer;
    }
    public static void main(String args[]){
        String arg="I am a student.";
        System.out.println(reverseSentence(arg));
        System.out.println(arg);
    }
}
