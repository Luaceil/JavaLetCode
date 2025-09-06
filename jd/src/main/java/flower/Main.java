package flower;

import java.util.Arrays;
import java.util.Scanner;
/*
昙花是一种很美丽的花,可惜的是,昙花开花的时间非常短暂,所以才有"昙花一现"之说。人们常说,目睹昙
花一现,意味着好的事情即将发生。
小明是一位大魔法师,他种植了n株昙花,并预知了这些昙花开花的时间t,,t2,.......th。每一株昙花只会开花
m秒,m是一个固定的数值。也就是说,第i株昙花将会在[t,t+m-1]开花。
小明想让自己欣赏昙花开花的时间尽可能长。但是,小明不满足于看两株及以上的昙花开花,他认为那样太过
艳丽、有失风采。也就是说,小明想让恰有一株昙花开花的时刻尽可能多。
作为大魔法师,小明可以施展至多一次魔法:他可以选定任意一株昙花花,并将这株昙花的开花时间t,
修改成任意正整数。请问,小明最多能让恰有一株昙花开花的时间变为多久?
2
4 10
1 3 12 20
5 5
2 1 10 3 11

 */

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        while(N!=0){
            int result =0;
            int M = sc.nextInt();
            int T = sc.nextInt();
            int[] arr =new int[M];
            for(int i=0;i<M;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            for(int i=0;i<M;i++)
            {
                //第i朵不参与统计
                int iResult=0;
                int lastTime = 0;
                int lastOpen = 0;
                for(int j=0;j<M;j++)
                {
                   if (i==j) continue;
                   if(arr[j]>=lastTime){
                       iResult = T+iResult;
                       lastOpen = arr[j];
                   }
                   if(arr[j]<lastTime){
                       iResult = iResult -(lastTime-Math.max(lastOpen,arr[j]));
                       iResult = iResult + arr[j]+T-lastTime;
                       lastOpen=lastTime;
                   }
                   lastTime = arr[j]+T;
                }
                result = Math.max(result,iResult);
            }
            result =result+T;
            System.out.println(result);
            N--;
        }
    }
}
