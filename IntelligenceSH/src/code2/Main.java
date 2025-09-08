package code2;

import java.util.ArrayList;
import java.util.Scanner;

/// 小红拿到了一个仅包含小写字母的字符串 s,下标从1开始。对于每个下标p,如果p的二进制表示中1的个数是奇数,则将第 p 个
/// 字符转换成对应的大写字母。
/// 请你对字符串s进行上述修改,并输出最终结果。
/*
4
abcdefg
vwcvnwaomy
ovoxcfdtf
yynbve
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Boolean> isUP =new ArrayList<>();
        ArrayList<String> strUPArr = new ArrayList<>();
        int N;
        Scanner sc =new Scanner(System.in);
        N =sc.nextInt();
        sc.nextLine();
        int M=0; //最长字符串长度
        for(int i=0;i<N;i++){
            String strUP=  sc.nextLine();
            M=Math.max(strUP.length(),M);
            strUPArr.add(strUP);
        }
        setIsUP(isUP,M);
        //isUP.stream().forEach(System.out::print);
        for(int i=0;i<N;i++){
           String upStr= strUPArr.get(i);
           String newStr="";
           for(int j=0;j<upStr.length();j++){
               if(isUP.get(j)){
                  String tmpStr ="" + upStr.charAt(j);
               newStr =newStr+tmpStr.toUpperCase();
               }else {
                   newStr = newStr +upStr.charAt(j);
               }
           }
            System.out.println(newStr);
        }

        sc.close();
    }
    private static void setIsUP(ArrayList<Boolean> arr,int n){
        for(int i=1;i<=n;i++){
            int count = 0;
            for(int k=0;k<31;k++){
                int num = 1<<k;
                if((i&num)!=0){count++;}
            }
            //System.out.println("i,count:"+i+" "+count);
            count = count%2;
            if(count == 1){
                arr.add(true);
                continue;
            }
            arr.add(false);
        }
    }
}
