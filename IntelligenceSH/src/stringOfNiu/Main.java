package stringOfNiu;

import java.util.Arrays;
import java.util.Scanner;

/// 牛牛拥有一个长度为n的01串8="8182...87"(下标从1开始)。
/// 对于每个位置i(1≤i≤n),定义:
/// ai为在i左侧(即下标<i的位置)中,字符与8;不同的
/// 元素个数。
/// 请你输出整个序列{a1,a2,...,an}。
/*
2
4
1101
5
01010
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        for(int i=0;i<N ;i++){
            int M= sc.nextInt();
            String strOfNiu = sc.nextLine();
            int[] arr = new int[M];
            int num1=0,num0=0;
            for(int j=0;j<M;j++) {
               if(strOfNiu.charAt(j)==1){
                   num1++;
                   arr[j] =num0;
               }
               else{
                   num0++;
                   arr[j] =num1;
               }
            }
            Arrays.stream(arr).forEach(a->System.out.print(a+" "));
            System.out.println();
        }
        sc.close();
    }
}
