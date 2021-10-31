package src.DFS_BFS;

/**
 * 那么广度优先搜索(BFS)呢?它有哪些应用呢？答：最短路径，分酒问题，八数码问题等。
 */
/**
 * 无向图
 * @author wly
 *
 */
public class NoDirectionGraph {

    private int mMaxSize; //图中包含的最大顶点数
    private GraphVertex[] vertexList; //顶点数组
    private int[][] indicatorMat; //指示顶点之间的连通关系的邻接矩阵
    private int nVertex; //当前实际保存的顶点数目


    public NoDirectionGraph(int maxSize) {
        mMaxSize = maxSize;
        vertexList = new GraphVertex[mMaxSize];
        indicatorMat = new int[mMaxSize][mMaxSize];
        nVertex = 0;
        //初始化邻接矩阵元素为0
        for(int j=0;j<mMaxSize;j++) {
            for(int k=0;k<mMaxSize;k++) {
                indicatorMat[j][k] = 0;
            }
        }
    }


    public void addVertex(GraphVertex v) {
        if(nVertex < mMaxSize) {
            vertexList[nVertex++] = v;

        } else {
            System.out.println("---插入失败，顶点数量已达上限!");
        }
    }

    /**
     * 修改邻接矩阵，添加新的边
     * @param start
     * @param end
     */
    public void addEdge(int start,int end) {
        indicatorMat[start][end] = 1;
        indicatorMat[end][start] = 1;
    }

    /**
     * 打印邻接矩阵
     */
    public void printIndicatorMat() {

        for(int[] line:indicatorMat) {
            for(int i:line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /**
     * 深度优先遍历
     * @param vertexIndex 表示要遍历的起点,即图的邻接矩阵中的行数
     */
    public void DFS(int vertexIndex) {
        ArrayStack stack = new ArrayStack();
        //1.添加检索元素到栈中
        vertexList[vertexIndex].setVisited(true);
        stack.push(vertexIndex);
        int nextVertexIndex = getNextVertexIndex(vertexIndex);//得到当前顶点的下一个顶点所在行
        while(!stack.isEmpty()) { //不断地压栈、出栈，直到栈为空(检索元素也没弹出了栈)为止
            if(nextVertexIndex != -1) {
                vertexList[nextVertexIndex].setVisited(true);
                stack.push(nextVertexIndex);
                stack.printElems();//打印栈中元素
            } else {
                stack.pop();
            }
            //检索当前栈顶元素是否包含其他未遍历过的节点
            if(!stack.isEmpty()) {
                nextVertexIndex = getNextVertexIndex(stack.peek());
            }
        }
    }

    /**
     * 得到当前顶点的下一个顶点所在行
     * @param column
     * @return
     */
    public int getNextVertexIndex(int column) {
        for(int i=0;i<indicatorMat[column].length;i++) {
            if(indicatorMat[column][i] == 1 && !vertexList[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 广度优先遍历
     * @param vertexIndex 表示要遍历的起点,即图的邻接矩阵中的行数
     */
    public void BFS(int vertexIndex) {
        ChainQueue queue = new ChainQueue();
        vertexList[vertexIndex].setVisited(true);
        queue.insert(new QueueNode(vertexIndex));
        int nextVertexIndex = getNextVertexIndex(vertexIndex);
        while(!queue.isEmpty()) {
            if(nextVertexIndex != -1) {
                vertexList[nextVertexIndex].setVisited(true);
                queue.insert(new QueueNode(nextVertexIndex));
            } else {
                queue.remove();
            }
            if(!queue.isEmpty()) {
                nextVertexIndex = getNextVertexIndex(queue.peek().data);
                queue.printElems();
            }
        }
    }
}