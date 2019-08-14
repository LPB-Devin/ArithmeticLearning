package Offer;

/**
 * 实现一个函数，把字符串中的每个空格替换成“%20”
 *
 */
public class Offer02_replaceBlank {
    /**
     *
     * @param string    源字符串
     * @return  目标字符串
     */
    public static String replaceBlank(String string){

        int usedLength = string.length();

        if(string=="" || string.length()<usedLength){
            return null;  //返回-1，表示错误
        }

        String[] str =string.split("");

        //计算空格个数
        int whileCount = 0;
        for(int i=0;i<str.length;i++){
//            System.out.print(str[i]+"、");
            if(str[i] == " ")
                whileCount++;
        }

        int targetLength = whileCount*2 + usedLength;
        String[] targetStr = new String[400];


        int end = str.length-1;
        for(int i=0;i<usedLength;i++){
            if(" ".equals(str[i])){
                str[i] = "%20";
            }
        }
        String stemp = "";
        for(int i=0;i<usedLength;i++){
            stemp = stemp+str[i];
        }
        string = stemp;
        return string;
    }
    public static void main(String[] args){
        System.out.println(replaceBlank("We are Family!"));
    }
}
