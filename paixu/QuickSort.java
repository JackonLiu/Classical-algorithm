package src.paixu;

import java.util.Arrays;
//快速排序  分治法
public class QuickSort {
    public static void sort(int a[], int low, int hight) {
        int i, j, index;
        //如果位置相反，跳出此方法
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用第一个记录小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比第一个记录大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将第一个记录数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序

    }

    public static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        System.out.println("快速排序之前：");
        int[]a = new int[42];
        for (int i=0;i<=41;i++){
            a[i] = (int) (Math.random() * 1000);
        }

        System.out.println(Arrays.toString(a));
        quickSort(a);
        System.out.println();
        System.out.println("快速排序之后：");
        System.out.println(Arrays.toString(a));
    }
}