package src.DFS_BFS;

/**
 * 基于图的深度优先搜索
 */
public class Test_BFS_DFS {

    public static void main(String[] args) {

        //初始化测试数据
        NoDirectionGraph graph = new NoDirectionGraph(7);
        graph.addVertex(new GraphVertex("A"));
        graph.addVertex(new GraphVertex("B"));
        graph.addVertex(new GraphVertex("C"));
        graph.addVertex(new GraphVertex("D"));
        graph.addVertex(new GraphVertex("E"));
        graph.addVertex(new GraphVertex("F"));
        graph.addVertex(new GraphVertex("G"));
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 6);
        graph.addEdge(2, 5);

        System.out.println("--图的邻接矩阵--");
        graph.printIndicatorMat();

        //测试深搜
        System.out.println("--深度优先搜索--");
        graph.DFS(0);

        graph = new NoDirectionGraph(7);
        graph.addVertex(new GraphVertex("A"));
        graph.addVertex(new GraphVertex("B"));
        graph.addVertex(new GraphVertex("C"));
        graph.addVertex(new GraphVertex("D"));
        graph.addVertex(new GraphVertex("E"));
        graph.addVertex(new GraphVertex("F"));
        graph.addVertex(new GraphVertex("G"));
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 6);
        graph.addEdge(2, 5);
        System.out.println("--广度优先搜索--");
        graph.BFS(0);

    }
}