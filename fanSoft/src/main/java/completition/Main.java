package completition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static int result=0;
    public static boolean hasOrdered=false;
    public static int Solve (int N, int K, int[] R) {
        //贪心? 动态规划? 匹配问题 贪心!分差==K优先匹配
        //区间缩进法 //分差匹配问题
        if (N == 0) return result;
        if ( !hasOrdered ) {
            Arrays.sort(R);
            hasOrdered=true;
        }
        Arrays.stream(R).forEach(a->{
            System.out.print(a+" ");
        });
        System.out.println();
        int n = R.length;
        int[] NextR = new int[n / 2];
        HashMap <Integer,Integer> map = new HashMap<>();
        for (int l = n - 1; l >= n / 2; l--) {
            NextR[l - n / 2] = R[l];
            map.put(R[l], l);
        }
        boolean[] isvisited = new boolean[n];
        for (int i = K; i > 0; i--) {
            for (int j = 0; j < n / 2; j++) {
                if (!isvisited[j] && map.containsKey(R[j]+i)&&!isvisited[map.get(R[j]+i)] ) {
                        result++;
                        isvisited[map.get(R[j]+i)] = true;
                        isvisited[j] = true;
                }
            }
        }
        return Solve(N - 1, K, NextR);
    }

    public static void main(String[] args) {
        int N=3;
        int K=6;
        int[] R=new int[]{44,23,30,50,12,34,42,32};
        Solve(N, K, R);
        System.out.println(result);
    }
}
