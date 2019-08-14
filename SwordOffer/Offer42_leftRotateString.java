package Offer;

public class Offer42_leftRotateString {
    public static char[] leftRotateString(char[] data,int n){
        if(data==null||n<0||n>data.length){
            return data;
        }
        int length = data.length;
        reverse(data,0,length-1);
        reverse(data,0,length - n -1);
        reverse(data,length-n,length-1);
        return data;
    }

    public static void reverse(char[] data,int start,int end){
        if(data == null || data.length <1||start<0||end>data.length || start >end){
            return;
        }
        while(start < end){
            char tmp = data[start];
            data[start] = data[end];
            data[end] = tmp;

            start++;
            end--;
        }
    }

    public static void main(String args[]){
        char[] data={'a','b','c','d','e','f','g'};
        data = leftRotateString(data,4);
        for(char c:data){
            System.out.print(c + " ");
        }
    }
}
