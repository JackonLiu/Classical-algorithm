/**
 * Created by Administrator on 18-5-15.
 */
public class MGraph {
    /*图的邻接矩阵表示*/
    int vexs;  //图中结点数目
    char data[];  //存放结点数据
    int [][]weight;  //存放边
    public MGraph(int ve){
        vexs=ve;
        data=new char[ve];
        weight=new int[ve][ve];
    }
}