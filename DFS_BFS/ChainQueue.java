package src.DFS_BFS;

/**
 * Created by Administrator on 18-4-17.
 */
/**
 * 使用链表实现队列
 *
 * @author wly
 *
 */
public class ChainQueue {
    private QueueNode head; // 指向队列头节点
    private QueueNode tail; // 指向队列尾节点
    private int size = 0; // 队列尺寸

    public ChainQueue() {

    }

    /**
     * 插入新节点到队列尾
     */
    public void insert(QueueNode node) {

        // 当然也可以这么写,添加tail.prev = node
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = tail;
            tail.prev = node; // 双向连接，确保head.prev不为空
            tail = node;
        }
        size++;
    }

    /**
     * 移除队列首节点
     */
    public QueueNode remove() {
        if (!isEmpty()) {
            QueueNode temp = head;
            head = head.prev;
            size--;
            return temp;
        } else {
            System.out.println("异常操作，当前队列为空!");
            return null;
        }
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 返回队列首节点，但不移除
     */
    public QueueNode peek() {
        if (!isEmpty()) {
            return head;
        } else {
            System.out.println();
            System.out.println("异常操作，当前队列为空!");
            return null;
        }
    }

    /**
     * 返回队列大小
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 打印队列中的元素
     */
    public void printElems() {
        QueueNode tempNode = head;
        while(tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.prev;
        }
        System.out.println();
    }
}

/**
 * 节点类
 *
 * @author wly
 *
 */
class QueueNode {
    QueueNode prev;
    QueueNode next;

    int data;

    public QueueNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        super.toString();
        return data + "";
    }
}