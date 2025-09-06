package StoneStr;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    /*
    小明是一个魔法项链回收商,他的工作是将这些魔法项链进行无害化处理。魔法项链由若干颗魔法石组成,可
以视作一个字符串,不同种类的魔法石可以用小写字母a~z来进行表示。小明可以将魔法项链切割为若干段(也
可以不切割),每一段中相同种类的魔法石可以进行能量抵消,如果最终宝石全部抵消或者只剩一颗,那么就算
完成了无害化处理。

提示
输入样例2
abcdabcd
输出样例2
1
无需切割,最初的项链串本身就可以完成无害化处理,此时记为1段。

样例解释2
rrzbbaau
输入样例3
输出样例3
2
可以切割为rrz,bbaau两个子串。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stoneStr = sc.nextLine();
        sc.close();
        //dp?
        HashMap<Integer,Integer> dpMap = new HashMap<>();
        dpMap.put(0,0);
        int state = 0;
        int n= stoneStr.length();
        for(int i=0;i<n;i++){
            char c =stoneStr.charAt(i);
            int intC=c-'a';
            state =state^(1<<intC);
            int minVal=Integer.MAX_VALUE;
            if(dpMap.containsKey(state)){
                minVal=Math.min(minVal,dpMap.get(state));
            }
            for(int k=0;k<26;k++){
                int candidate =state^(1<<k);
                if(dpMap.containsKey(candidate)){
                    minVal = Math.min(minVal,dpMap.get(candidate));
                }
            }
            int newDP= minVal+1;
            if(!dpMap.containsKey(state)||newDP<dpMap.get(state)){
                dpMap.put(state,newDP);
            }
        }
        System.out.println(dpMap.get(state));
    }
}
