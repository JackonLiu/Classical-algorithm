package src.paixu;

import java.util.Random;

/**
 * 分治法实现合并排序
 * 分成两个子序列，对子序列进行排序
 */
public class MergeSort1 {

    public static void merge(int[]a,int low,int mid,int high){//对两组已经排序的数组进行合并
        int[]b=new int[high-low+1]; //临时数组，存储个数为high - low + 1个数据  5－1＋1
        int s=low;
        int t=mid+1;
        int k=0;
        while(s<=mid&&t<=high){   //直至前半部或后半部数据完全录入暂存
            if(a[s]<=a[t])        //如果前半部的数据小于后半部的，前半部数据暂存
                b[k++]=a[s++];
            else                   //否则后半部数据暂存，并下标自加
                b[k++]=a[t++];
        }
        while(s<=mid)
            b[k++]=a[s++];
        while(t<=high)
            b[k++]=a[t++];
        for(int i=0;i<b.length;i++){     //将暂存的数据重新填充至array[low]--array[high]中
            a[low+i]=b[i];
        }
    }
    public static void MergeSort1(int a[],int low,int high){//对数组进行递归排序
        int mid;
        if(low<high){
            mid=(low+high)/2;
            //一部分为从第一个到中间的元素
            MergeSort1(a,low,mid);  //递归合并排序
            //另一部分为从中间到最后面的元素
            MergeSort1(a,mid+1,high);
            //对该部分进行排序
            merge(a,low,mid,high);
        }
    }
    public static void main(String[]args){
        int[]a = new int[42];
        for (int i=0;i<=41;i++){
            a[i] = (int) (Math.random() * 1000);
        }

        System.out.println("合并排序前数组为：");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" "); }
        MergeSort1(a,0,a.length-1);
        System.out.println("\n合并排序后数组为：");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");}
    }

}