/**  算法思考，初步思路：
 构建二维int或者short型数组，内存中模拟棋盘
 chess[r][c]=0表示：r行c列没有皇后，chess[r][c]=1表示：r行c列位置有一个皇后
 从第一行第一列开始逐行摆放皇后
 依题意每行只能有一个皇后，遂逐行摆放，每行一个皇后即可
 摆放后立即调用一个验证函数（传递整个棋盘的数据），验证合理性，安全则摆放下一个，不安全则尝试摆放这一行的下一个位置，直至摆到棋盘边界
 当这一行所有位置都无法保证皇后安全时，需要回退到上一行，清除上一行的摆放记录，并且在上一行尝试摆放下一位置的皇后（回溯算法的核心）
 当摆放到最后一行，并且调用验证函数确定安全后，累积数自增1，表示有一个解成功算出
 验证函数中，需要扫描当前摆放皇后的左上，中上，右上方向是否有其他皇后，有的话存在危险，没有则表示安全，
 并不需要考虑当前位置棋盘下方的安全性，因为下面的皇后还没有摆放
 */
import java.util.Date;


public class Eightqueen2 {
    private static final short K=15;        //使用常量来定义，方便之后解N皇后问题
    private static int count=0;            //结果计数器
    private static short N=0;

    public static void main(String[] args) {
        for(N=3;N<=K;N++){
            Date begin =new Date();
            /**
             * 初始化棋盘，使用一维数组存放棋盘信息
             * chess[n]=X:表示第n行X列有一个皇后
             */
            short chess[]=new short[N];
            for(int i=0;i<N;i++){
                chess[i]=0;
            }
            putQueenAtRow(chess,(short)0);
            Date end =new Date();
            System.out.println("解决 " +N+ "皇后问题，用时：" +String.valueOf(end.getTime()-begin.getTime())+ "毫秒，计算结果："+count);
        }
    }

    private static void putQueenAtRow(short[] chess, short row) {
        /**
         * 递归终止判断：如果row==N，则说明已经成功摆放了8个皇后
         * 输出结果，终止递归
         */
        if(row==N){
            count++;
//            System.out.println("第 "+ count +" 种解：");
//            for(int i=0;i<N;i++){
//                for(int j=0;j<N;j++){
//                    System.out.print(chess[i][j]+" ");
//                }
//                System.out.println();
//            }
            return;
        }

        short[] chessTemp=chess.clone();

        /**
         * 向这一行的每一个位置尝试排放皇后
         * 然后检测状态，如果安全则继续执行递归函数摆放下一行皇后
         */
        for(short i=0;i<N;i++){
            //摆放这一行的皇后
            chessTemp[row]=i;

            if( isSafety( chessTemp,row,i ) ){
                putQueenAtRow(chessTemp,(short) (row+1));
            }
        }
    }

    private static boolean isSafety(short[] chess,short row,short col) {
        //判断中上、左上、右上是否安全
        short step=1;
        for(short i=(short) (row-1);i>=0;i--){
            if(chess[i]==col)    //中上
                return false;
            if(chess[i]==col-step)    //左上
                return false;
            if(chess[i]==col+step)    //右上
                return false;

            step++;
        }

        return true;
    }
}