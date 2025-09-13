package balance;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T!=0){
            int N = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> litteArr =new ArrayList<>();
            ArrayList<Integer> bigArr = new ArrayList<>();
            for(int i=0;i<N;i++){
                int num =sc.nextInt();
                if(num>m){
                    bigArr.add(num);
                }
                if(num<m){
                    litteArr.add(num);
                }
            }
            int result=0;
            if(litteArr.size()>(N-1)/2){
              int count = litteArr.size()-(N-1)/2;
              litteArr.sort((o1,o2)->{return o2-o1;}); //倒序
              litteArr.stream().forEach(i->{System.out.print(i+" ");});
              System.out.println();
              for(int i=0;i<count;i++){
                  result+=m-litteArr.get(i);
              }
            }
            if(bigArr.size()>(N-1)/2){
                int count = bigArr.size()-(N-1)/2;
                bigArr.sort((o1,o2)->{return o1-o2;}); //倒序
                bigArr.stream().forEach(i->{System.out.print(i+" ");});
                System.out.println();
                for(int i=0;i<count;i++){
                    result+=bigArr.get(i)-m;
                }
            }
            System.out.println(result);
            T--;
        }
    }
}
