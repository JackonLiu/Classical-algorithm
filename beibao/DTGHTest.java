package src.beibao;

import java.util.Scanner;

public class DTGHTest {
    public static void main(String[] args) {
        Knapsack[] bags = new Knapsack[] { new Knapsack(2, 12),
            new Knapsack(1, 10), new Knapsack(3, 20), new Knapsack(2, 15)};
       // Knapsack[] bags = new Knapsack[]{new Knapsack(3, 25),
       //         new Knapsack(2, 20), new Knapsack(1, 15), new Knapsack(4, 40), new Knapsack(5, 50)};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入背包的总重量：");
        int totalWeight = sc.nextInt();
        DTGHProblem problem = new DTGHProblem(bags, totalWeight);
        System.out.println("该问题的求解过程：");
        System.out.printf("最优值矩阵：");
        problem.solve();
        System.out.println("");
        int[][] bestValues = problem.getBestValues();
        for (int i = 0; i < bestValues.length; i++) {
            for (int j = 0; j < bestValues[i].length; j++) {
                System.out.printf("%-5d", bestValues[i][j]);
               ;
            } System.out.println();
        }
            System.out.println(" -------- 该背包问题实例的解: --------- ");
            System.out.println("最优值：" + problem.getBestValue());

    }
}
