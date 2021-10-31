package best;

/**
 * Created by Administrator on 18-5-22.
 */
import java.util.ArrayList;
import java.util.List;
public class NQueens {
    private int numSolutions;//求解结果数量
    private int queenSize;//皇后的多少
    private Board board;//棋盘
    private List<Queen> queens = new ArrayList<Queen>();//皇后
    //private List<Queen> nQueens = new ArrayList<Queen>();
    public NQueens(){
    }
    public NQueens(int size){
        numSolutions = 0;
        queenSize = size;
        board = new Board(queenSize);
        for (int i = 0; i < queenSize; i++) {
            Queen queen = new Queen();
            queens.add(queen);
        }
    }
    public void solve(){
        System.out.println("Start solve....");
        putQueen(0);
    }
    private void putQueen(int index){
        int row = index;
//如果此列可用
        for (int col = 0; col < board.getQueenSize(); col++) {
            if (board.getLayout()[row][col] == 0) {
//将皇后的位置置为此列位置
                queens.get(row).setPosition(col);
//然后将相应的位置（此列的正下方以及两个对角线）加1（即使其不可用）
                for (int i = row + 1; i < board.getQueenSize(); i++) {
                    board.getLayout()[i][col] ++;
                    if (row + col - i >= 0) {
                        board.getLayout()[i][row + col - i] ++;
                    }
                    if (i + col - row < board.getQueenSize()) {
                        board.getLayout()[i][i + col - row] ++;
                    }
                }
                if (row == board.getQueenSize()-1) {
                    numSolutions++;
                    printSolution(numSolutions);
                }else {
                    putQueen(row + 1);
                }
//回溯，将相应的位置（此列的正下方以及两个对角线）减1
                for (int i = row + 1; i < board.getQueenSize(); i++) {
                    board.getLayout()[i][col] --;
                    if (row + col - i >= 0) {
                        board.getLayout()[i][row + col - i] --;
                    }
                    if (i + col - row < board.getQueenSize()) {
                        board.getLayout()[i][i + col - row] --;
                    }
                }
            }
        }
    }
    //打印求解结果
    private void printSolution(int i){
        System.out.println("The "+i+ " solution is:");
        for (int j = 0; j < board.getQueenSize(); j++) {
            for (int k = 0; k < board.getQueenSize(); k++) {
                System.out.print(queens.get(j).getPosition() == k ? " Q ":" - ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("共有 "+i+" 摆法");
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
//可以改变参数
        NQueens nQueens = new NQueens(4);
        nQueens.solve();
    }
}