package Offer;

/**
 * 把n个骰子扔到地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能值出现的概率。
 *
 */
public class Offer43_printProbability {
    /**
     *
     * 通归实现
     * 时间复杂度 O（）
     * 空间复杂度 O（number * max）
     * @param number
     * @param max
     */
    public static void printProbability1(int number,int max){
        if(number < 1 || max < 1){
            return;
        }
        int maxSum = number * max;
        int[] probabilities = new int[maxSum - number +1];
        probability(number,probabilities,max);

        double total = 1;
        for(int i=0;i<number;i++){
            total *= max;
        }

        for(int i=number;i<=maxSum ; i++){  //每个骰子点数至少为 一 点，故6点起步
            double ratio = probabilities[i-number]/total;
            System.out.printf(i + ": %-8.24f \t",ratio);
            if(i%3 == 0){
                System.out.println();
            }
        }

        System.out.println();
    }

    /**
     *
     * @param number    骰子数目
     * @param probabilities 骰子点数和可能值数组
     * @param max       骰子的最大值
     */
    private static void probability(int number, int[] probabilities, int max) {
        for(int i=1;i<=max;i++){
            probability(number,number,i,probabilities,max);
        }
    }

    /**
     *
     * @param original      总骰子数
     * @param current       剩余骰子数
     * @param sum           之前的骰子点数和
     * @param probabilities 不同骰子点数出现次数的计数数组
     * @param max           单个骰子的最大值
     */
    private static void probability(int original, int current, int sum, int[] probabilities, int max) {
        if(current == 1){
            probabilities[sum - original]++;
        }else {
            for(int i=1;i<max;i++){
                probability(original,current-1,i+sum,probabilities,max);
            }
        }
    }


    public static void main(String[] args) {
        int number = 6;
        int max = 6;
        printProbability1(number,max);
    }
}
