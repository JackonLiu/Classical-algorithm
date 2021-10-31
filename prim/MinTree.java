/**基本思想：
 设G=(V,E)是连通网，T=(U,D)是最小生成树，V,U是顶点集合，E,D是边的集合
 ①若从顶点u开始构造最小生成树，则从集合V中取出顶点u放入集合U中，标记顶点v的visited[u]=1；
 ②若集合U中顶点ui与集合V-U中的顶点vj之间存在边，则寻找这些边中权值最小的边，但不能构成回路，
 将顶点vj加入集合U中，将边（ui,vj）加入集合D中，标记visited[vj]=1；
 ③重复步骤②，直到U与V相等，即所有顶点都被标记为访问过，此时D中有n-1条边。
 */
public class MinTree {

    /**创建图的邻接矩阵
     * int vexs;  //图中结点数目
     char data[];  //存放结点数据
     int [][]weight;  //存放边  */
    public void CreateGraph(MGraph graph,int vexs,char data[],int [][]weight){
        int i,j;
        for(i=0;i<vexs;i++){
            graph.data[i]=data[i];
            for(j=0;j<vexs;j++){
                graph.weight[i][j]=weight[i][j];
            }
        }
    }

    public void Prim(MGraph graph,int v){
        /*graph为图的邻接矩阵表示，v为起始顶点*/
        int visited[]=new int[graph.vexs];  // visited[]标记结点是否被访问过
        for(int i=0;i<graph.vexs;i++){   //初始化visited[]
            visited[i]=0;
        }

        visited[v]=1;
        int h1=-1,h2=-1;   //记录边的弧尾和弧头
        int minweight=10000;//minweight记录最小权重
        int min=0;
        for(int k=1;k<graph.vexs;k++){  //vexs个顶点，最小生成树中有vexs-1条边
            for(int i=0;i<graph.vexs;i++){  //i顶点表示被访问过的顶点
                for(int j=0;j<graph.vexs;j++){  // j顶点表示未被访问过的顶点
                    if(visited[i]==1 && visited[j]==0 && graph.weight[i][j]<minweight){
                        //寻找已访问的顶点与未访问的定点间的权值最小的边
                        minweight=graph.weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }
            }

            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+"> 权值："+minweight);
            min=min+minweight;
            visited[h2]=1;   //标记h2被访问过
            minweight=10000;
        }
        System.out.println("最短距离为："+min);
    }

    public static void main(String args[]){
        char []data=new char[]{'A','B','C','D','E','F'};
        int vexs=data.length;
/*        int [][]weight=new int[][]{
                {0,5,7,7,2},
                {5,0,7,6,3},
                {7,7,0,4,4},
                {7,6,4,0,4},
                {2,3,4,4,0}
        };*/
        int [][]weight=new int[][]{
                {0,3,8,7,11},
                {3,0,4,2,7},
                {8,4,0,5,6},
                {7,2,5,0,4},
                {11,7,6,4,0}
        };
        /* int [][]weight=new int[][]{
                {10000,4,8,5,10000},
                {4,10000,3,10000,7},
                {8,3,10000,6,6},
                {5,10000,6,10000,9},
                {10000,7,6,9,10000}
        };
        */
        // /初始化图的节点和边
        MGraph graph=new MGraph(vexs);
        MinTree mt=new MinTree();
        //创建图的邻接矩阵
        mt.CreateGraph(graph,vexs,data,weight);
        mt.Prim(graph, 0);
    }
}
