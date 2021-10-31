package src.paixu;

/**  蛮力法
 * 简单选择排序的基本思想：选择最小的放前面
 */
//选择排序
public class SelectionSort {
    public static void main(String[] args) {
        int[]arr = new int[42];
        for (int i=0;i<=41;i++){
            arr[i] = (int) (Math.random() * 1000);
        }

        System.out.println("排序之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        //选择排序的优化
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[k]){
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println();
        System.out.println("排序之后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }

}