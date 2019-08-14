package Offer;

/**
 * {1,2,3,4,5} K=5
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到
 * 下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断该数组中是否含有该整数
 */
public class Offer01_FindArray {
    public static boolean find(int[][] matrix, int number){
        //判断二维数组 matrix
        if(matrix == null || matrix.length<1 || matrix[0].length<1){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;


        int row = 0;
        int col = cols - 1;

        //在数组中范围内查找该数
        while(row>=0 && row<rows && col>=0 && col<cols){
            if(matrix[row][col] == number) {  //找到该number
                return true;
            }
            else if(matrix[row][col] > number){
                //该位置元素大于number ，说明查找的数在当前位置的左边
                col --; //列数-1，代表向左移动
            }
            else{
                //该位置元素小于number ，说明查找的数在当前位置的下边
                row ++;//行数+1，代表向下移动
            }
        }

        return false;
    }
    public static void main(String args[]){
        int k = 20;
        int[][] m = new int[4][4];
        for(int i=0;i < m.length;i++){
            for(int j=0;j < m.length;j++){
                m[i][j] = i*m.length+j;
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(find(m,k));
    }
}
