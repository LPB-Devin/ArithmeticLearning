package Offer;

/**
 * 螺旋矩阵：
 * 输入一个矩阵，按照从外到内顺时针打印每一个元素
 */
public class Offer17_printMatrixClockWisely {
    public static void printMatrixClockWisely(int[][] numbers){

        //空矩阵情况
        if(numbers == null){
            return ;
        }

        //记录一圈开始位置的行数
        int x = 0;
        //记录一圈开始位置的列
        int y = 0;

        //在矩阵范围内进行顺时针遍历
        while(x<<1 < numbers.length && y<<1 < numbers[0].length){
            printMatrixInCircle(numbers,x,y);
            x++;
            y++;
        }
        
    }

    /**
     * 对矩阵中的某一圈进行遍历
     * @param numbers
     * @param x
     * @param y
     */
    private static void printMatrixInCircle(int[][] numbers, int x, int y) {
        int rows = numbers.length;
        int cols = numbers[0].length;

        //对上行进行遍历输出
        for(int i=y;i <= cols-y-1 ; i++){
            System.out.print(numbers[x][i] + " ");
        }

        //行数>=2，右方才有数据可以输出
        if(rows-x-1 > x){
            for(int i = x+1;i <= rows-x-1 ; i++){
                System.out.print(numbers[i][cols-y-1] + " ");
            }
        }

        //下行需要避免数据重复输出，且列数>=2，才有数据可以输出
        if(rows-x-1 > x && cols-1-y > y){
            for(int i = cols-2-y ; i>=y;i--){
                System.out.print(numbers[rows-1-x][i] + " ");
            }
        }

        //左行需要输出列位于矩阵中心左方（避免重复输出），且行数>=2，才有数据可以输出
        if(cols-1-y >y && rows-1-x > x+1){
            for(int i=rows-1-x-1;i>=x+1;i--){
                System.out.print(numbers[i][y] + " ");
            }
        }
    }

    public static void main(String args[]){
        int[][] n3 = { {1,2,3},{ 8,9 , 4},{ 7, 6, 5} };
        int[][] n4 = { {1,2,3,4},{ 12,13 , 14,5},{ 11, 16, 15,6} ,{ 10, 9, 8,7} };
        printMatrixClockWisely(n4);
    }
}
