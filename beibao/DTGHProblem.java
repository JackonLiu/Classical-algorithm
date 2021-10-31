package src.beibao;

/**思路：
 1. 01背包的状态转换方程 f[i,j] = Max{f[i-1,j-Wi]+Pi( j >= Wi ), f[i-1,j] }

 f[i,j]：在前i件物品中选择若干件放在承重为 j 的背包中，可以取得的最大价值。
 Pi表示第i件物品的价值。
 决策：为了背包中物品总价值最大化，第 i件物品应该放入背包中吗 ？
 2. 以a8（行为a，列为的8的单元格）举例
 f[i,j] = a8 = 15
 f[i-1,j] = b8 = 9
 f[i-1,j-Wi] 表示我有一个承重为6的背包（等于当前背包承重减去物品a的重量），当只有物品b,c,d,e四件可选时，这个背包能装入的最大价值
 f[i-1,j-Wi] +Pi =b(8 - 2) + 6 = b6 + 6 = 15
 */
public class DTGHProblem {

    // 所有的物品
    private Knapsack[] bags;
    // 物品的数量
    private int n;
    // 背包总承重
    private int totalWeight;
    // 第一维：当前第几个物品；第二维：当前的背包承重；值：当前背包最大价值
    private int[][] bestValues;
    // 最终背包中最大价值
    private int bestValue;

    public DTGHProblem(Knapsack[] bags, int totalWeight) {
        this.bags = bags;
        this.totalWeight = totalWeight;
        this.n = bags.length;
        if (bestValues == null) {
            // 考虑0的状态+1，防止数组角标越界
            bestValues = new int[n + 1][totalWeight + 1];
        }
    }

    public void solve() {
        // 遍历背包的承重
        for (int j = 0; j <= totalWeight; j++) {
            //System.out.println("");
            //System.out.print(" "+j+" ");
           // System.out.print("\t");
            // 遍历指定物品
            for (int i = 0; i <= n; i++) {
                // 当背包不放入物品或承重为0时，其最大价值均为0
                if (i == 0 || j == 0) {
                    bestValues[i][j] = 0;
                } else {
                    // 如果第 i个物品重量大于总承重，则最优解存在于前 i-1 个背包中
                    if (j < bags[i - 1].getWeight()) {
                        bestValues[i][j] = bestValues[i - 1][j];
                    } else {
                        // 如果第 i个物品不大于总承重，则最优解要么是包含第 i个背包的最优解，
                        // 要么是不包含第 i个背包的最优解， 取两者最大值
                        int weight = bags[i - 1].getWeight();
                        int value = bags[i - 1].getValue();
                        bestValues[i][j] = Math.max(bestValues[i - 1][j], value
                                + bestValues[i - 1][j - weight]);

                        //System.out.print(" "+String.valueOf(bestValues[i][j]));
                    }
                }
            }
        }

        bestValue = bestValues[n][totalWeight];
    }

    public int getBestValue() {
        return bestValue;
    }

    public int[][] getBestValues() {
        return bestValues;
    }
}