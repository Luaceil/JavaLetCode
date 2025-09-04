package backSubString;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String faString =sc.next();
        int N=faString.length();
        int[][] dp = new int[N][N];
        int iResult=0, maxLen=1;
        for(int i=N-1;i>=0;i--){
            for(int j=i;j<N;j++){
                if(i==j){
                    dp[i][j]=1;continue;
                }
                if(faString.charAt(i)==faString.charAt(j)){
                    if(j-i==1){
                        dp[i][j]=2;
                    }else {
                        if (i + 1 < N && j - 1 > 0 && i + 1 <= j - 1 && dp[i + 1][j - 1] != 0) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                    }
                }else{
                    dp[i][j]=0;
                }
                if(maxLen<=dp[i][j]){
                    maxLen=dp[i][j];
                    iResult=i;
                }
            }
        }
        String resultString = faString.substring(iResult,iResult+maxLen);
        System.out.println(resultString);
    }
}
