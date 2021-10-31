package src.erxiangshi;

/**
 * Created by Administrator on 18-5-8.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个较小的数：");


        int k = sc.nextInt();
        System.out.println("请输入一个较大的数：");
        int n = sc.nextInt();
        sc.close();

        System.out.println("计算结果为： "+recu(k, n));
    }

    private static int recu(int k, int n) {
        if(k>n){
            System.out.println("输入错误，请重新输入");
            return 0;
        }else {
        if (k == 0 || k == n) {
            return 1;
        }
        return recu(k, n - 1) + recu(k - 1, n - 1);
    }
}
}