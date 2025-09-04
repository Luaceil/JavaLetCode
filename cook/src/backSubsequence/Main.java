package backSubsequence;
import java.lang.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String  upStr = sc.nextLine();
        int N=upStr.length();
        int result=0;
        int[][] dp =new int[N][N];
        for(int i=N-1;i>=0;i--){
            for(int j=i;j<N;j++){
                if(i==j) {dp[i][j]=1;} else {
                     if(upStr.charAt(i)==upStr.charAt(j)&&i+1<N&&j>0){
                         dp[i][j]=dp[i+1][j-1]+2;
                     }
                     dp[i][j]=Math.max(dp[i+1][j], Math.max(dp[i][j],dp[i][j-1]));
                 }
                result = Math.max(dp[i][j],result);
            }
        }
        System.out.println(result);
    }
}

