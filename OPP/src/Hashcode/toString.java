package Hashcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
3
aaa
 */
public class toString {
    public static String toString(int[] arr){
        String str="";
        for(int i=0;i<arr.length;i++){
            str = str+arr[i];
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N =in.nextInt();
        String str =in.next();
        int count = 1;
        for(int i=1;i<N;i++){
            //子串长度
            Set<String> set = new HashSet<>();
            for(int j=0;j<N-i+1;j++){
                //子串初始位置
                int[] arr = new int[26];
                for(int k=j;k<j+i;k++){
                    int index =str.charAt(k)-'a';
                    arr[index]++;
                }

                set.add(toString(arr));
            }
            //System.out.println(set.size());
            count += set.size();
        }
        System.out.print(count);
    }
}