import java.util.Arrays;
import java.util.Scanner;

/**算法思想：
 0. 将皇后编号1,2,3,4,5,6,7,8，并且排号为i的皇后，放在第i行
 1. 将1号皇后放在第1行（1号皇后是肯定不会冲突的）
 2  1号皇后放好之后，放2号皇后（3号及以后的类似），从第2行第1列开始检测，不冲突就可以落子；
 当本行没有合法的位置时，说明上一行皇后放的位置不好，则撤销上一行皇后的位置，并重新摆放（所谓回溯）
 3. 如果8个皇后放好之后，按照上文逻辑该放8 + 1 号皇后了，但是已经放完了，
 所以将摆放结果打印。再重新摆放第8行
 */
public class MQueens {
    private static int queenNum;//皇后的个数
    private static int[] hash;//下标表示i号皇后（皇后i放在第i行）value表示放的列号
    private static int count = 0;//合法摆放方式的个数

    public void placeQueen(int m) {
        if (m > queenNum) {//如果摆到了n+1行了，说明前n行都是不冲突的，合法的
            count++;
            System.out.println(Arrays.toString(hash));
            //打印合法的摆放结果
            for(int i = 1; i <= queenNum; i++){
                int column = hash[i];//hash值表示皇后i所在的列号
                for(int j = 1; j <= queenNum ;j++){
                    if(j!= column){
                        System.out.print("* ");
                    }else{
                        System.out.print("Q ");
                    }
                }
                System.out.println();
            }
            return;
        }
        /**
         * 回溯法的主要体现
         如果皇后m+1放完并返回了
         //1：冲突，返回
         //2.一直将所有的皇后全部放完并安全返回了
         //将皇后m回溯，探索新的可能或者安全的位置
         */
        for (int i = 1; i <= queenNum; i++) {
            if (isConfilct(m, i)) {
                continue;
            } else {//如果检测到第i列不冲突，是安全的，
                hash[m] = i;//将皇后m放在第i列
                placeQueen(m + 1);//再放皇后m+1,

            }
        }
    }

    private boolean isConfilct(int row, int column) {
        if(row == 1){//第1行永远不会冲突
            return false;
        }
        //只需要保证与那些已经就位的皇后不冲突即可
        for (int i = 1; i < row; i++) {
            //hash[i] 下标表示i号皇后（皇后i放在第i行）value表示放的列号
            if (hash[i] == column || ( column - row) == (hash[i] - i) || (row - column)== (i-hash[i])
                    || (row + column) == (hash[i] + i)) {//表示皇后的攻击范围
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("请输入要计算的皇后的个数：");
        Scanner sc = new Scanner(System.in);
        queenNum = sc.nextInt();
        hash = new int[queenNum + 1];
        for (int i = 0; i < hash.length; hash[i++] = -1);//初始化棋盘
        MQueens demo = new MQueens();
        demo.placeQueen(1);
        System.out.println(queenNum +" 个皇后 有 " +count+ " 种摆法");
    }
}