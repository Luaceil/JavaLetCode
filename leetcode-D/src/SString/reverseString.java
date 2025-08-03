package SString;

import java.util.*;

public class reverseString {
    public static char[] string1;

    public  static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        string1= sc.next().toCharArray();
        reverseString(string1);
        System.out.println(string1);
        String[] string2=sc.nextLine().split(" ");
        int[] a=Arrays.stream(string2).mapToInt(Integer::parseInt).toArray();
    }
    public static  void reverseString(char[] s)
    {
        for(int i=0,j=s.length-1;i<=j;i++,j--)
        {
            char tmp=s[i];
            s[i]=s[j];
            s[j]=tmp;
        }
    }
}
