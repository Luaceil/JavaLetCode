package Hash;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class isHappy {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n)
    {
        Set<Integer> happyset=new HashSet<Integer>();
       happyset.add(n);
        int next =n;
        while(true)
        {
            next=inisquare(next);
            if(next==1)
                return true;
            if(!happyset.contains(next))
            {
                happyset.add(next);
            }
            else break;
        }
        return false;
    }
    public static int inisquare(int n)
    {
        int sum=0;
        while(n!=0) {
           // System.out.println(n%10);
            sum += (n % 10) * (n % 10);
          // System.out.println(sum);
            n/=10;
            //System.out.println("n"+n);
        }
        //System.out.println("sum"+sum);
        return sum;
    }
}
