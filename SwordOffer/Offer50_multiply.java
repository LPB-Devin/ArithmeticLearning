package Offer;

/**
 * 给定一个数组A[0,1,…,n-1],请构建一个数组B[0,1,…,n-1],其中B中的元素
 * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1],不能使用除法。
 *
 */
public class Offer50_multiply {
    /**
     * B0   1     A1    A2  A3
     * B1   A0    1     A2  A3
     * B2   A0    A1    1   A3
     * B3   A0    A1    A2  1
     * @param data
     * @return
     */
    public static double[] multiply(double[] data){
        if(data == null || data.length <2){
            return null;
        }

        double[] result = new double[data.length];

        result[0] = 1;
        for(int i = 1;i < data.length ; i++){
            //计算矩阵左下角
            //每一步的result[i]都等于上一步的result + data[i-1]
            result[i] = result[i-1] * data[i -1];
        }

        double tmp =1;

        for(int i=data.length - 2;i >= 0;i--){
            //计算矩阵右上角
            tmp *= data[i+1];
            result[i] *=tmp;
        }

        return result;
    }


}
