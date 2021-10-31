package src.DFS_BFS;

/**
 * Created by Administrator on 18-4-17.
 */
/**
 * 使用数组实现栈结构
 * @author wly
 *
 */
public class ArrayStack {

    private int[] tArray;
    private int topIndex = -1; //表示当前栈顶元素的索引位置
    private int CAPACITY_STEP = 12; //数组容量扩展步长


    public ArrayStack() {
        /***创建泛型数组的一种方法***/
        tArray = new int[CAPACITY_STEP];
    }

    /**
     * 弹出栈顶元素方法
     * @return
     */
    public int pop() {
        if(isEmpty()) {
            System.out.println("错误，栈中元素为空，不能pop");
            return -1;
        } else {
            int i = tArray[topIndex];
            tArray[topIndex--] = -1; //擦除pop元素
            return i;
        }
    }

    /**
     * 向栈中插入一个元素
     * @param t
     */
    public void push(int t) {
        //检查栈是否已满
        if(topIndex == (tArray.length-1)) {
            //扩展容量
            int[] tempArray = new int[tArray.length + CAPACITY_STEP];
            for(int i=0;i<tArray.length;i++) {
                tempArray[i] = tArray[i];
            }
            tArray = tempArray;
            tempArray = null;
        } else {
            topIndex ++;
            tArray[topIndex] = t;
        }
    }

    /**
     * 得到栈顶元素，但不弹出
     * @return
     */
    public int peek() {
        if(isEmpty()) {
            System.out.println("错误，栈中元素为空，不能peek");
            return -1;
        } else {
            return tArray[topIndex];
        }
    }

    /**
     * 判断当前栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return (topIndex < 0);
    }

    /**
     * 打印栈中元素
     */
    public void printElems() {
        for(int i=0;i<=topIndex;i++) {
            System.out.print(tArray[i] + " ");
        }
        System.out.println();
    }
}