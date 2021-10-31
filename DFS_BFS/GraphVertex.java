package src.DFS_BFS;

/**
 * Created by Administrator on 18-4-17.
 */
public class GraphVertex {

    Boolean visited=false;
    String label="";

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public GraphVertex(String label) {
        this.label = label;
    }

    public boolean isVisited() {
        return visited;
    }
}
