package Hashcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
3
aaa
*/
public class by10000000and7 {
        public static int toInt(int[] arr){
            int a=0;
            for(int i=0;i<arr.length;i++){
                a=(a+arr[i]*squre(i))%(1000000000+7);
            }
            return  a;
        }
        public static Integer squre(int i){
            if(i==0) return 1;
            return (squre(i-1)*1001)%(1000000000+7);
        }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int N =in.nextInt();
            String str =in.next();
            int count = 1;
            for(int i=1;i<N;i++){
                //子串长度
                Set<Integer> set = new HashSet<>();
                for(int j=0;j<N-i+1;j++){
                    //子串初始位置
                    int[] arr = new int[26];
                    for(int k=j;k<j+i;k++){
                        int index =str.charAt(k)-'a';
                        arr[index]++;
                    }
                    int var =toInt(arr);
                    // System.out.println(var);
                    set.add(var);
                }
                //System.out.println(set.size());
                count += set.size();
            }
            System.out.print(count);
        }
    }

