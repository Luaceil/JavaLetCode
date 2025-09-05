package strange_code;

import java.util.*;
public class Main {

    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       long n=sc.nextLong();
       long k=sc.nextLong();
       for(long i=0;i<k;i++){
           if (n%2==0){
               n=n/2;
           }
           else{
               n=n*3+1;
           }
       }
       System.out.println(n);
    }
}
