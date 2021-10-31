package src.paixu;

/**  减治法
 * 　具体流程如下：
 　　1、首先比较数组的前两个数据，并排序；
 　　2、比较第三个元素与前两个排好序的数据，并将第三个元素放入适当的位置；
 　　3、比较第四个元素与前三个排好序的数据，并将第四个元素放入适当的位置；
 */
public class InsertSort {

    public static void main(String[] args) {
        int[]a = new int[42];
        for (int i=0;i<=41;i++){
            a[i] = (int) (Math.random() * 1000);
        }

        System.out.println("排序之前：");
        InsertSort.output(a);
        System.out.println();
        InsertSort.Sort(a);
        System.out.println("排序之后：");
        InsertSort.output(a);
    }
    //插入排序
    public static void Sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int tempdata = arr[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(arr[j]>tempdata){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = tempdata;
        }
    }
    //输出打印
    public static void output(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
}