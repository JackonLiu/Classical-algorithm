package best;

/**
 * Created by Administrator on 18-5-22.
 */
import java.io.Serializable;
//棋盘类
public class Board implements Serializable,Cloneable {
    /**
     *
     */
    private static final long serialVersionUID = -2530321259544461828L;
    //棋盘的大小
    private int queenSize;
    //棋盘的布局
    private int[][] layout;
    public Board(int size){
        this.queenSize = size;
        this.layout = new int[queenSize][queenSize];
//初始化，使棋盘所有位置都可用，即全部置为0
        for (int i = 0; i < queenSize; i++) {
            for (int j = 0; j < queenSize; j++) {
                layout[i][j] = 0;
            }
        }
    }
    public int getQueenSize() {
        return queenSize;
    }
    public void setQueenSize(int queenSize) {
        this.queenSize = queenSize;
    }
    public int[][] getLayout() {
        return layout;
    }
    public void setLayout(int[][] layout) {
        this.layout = layout;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}