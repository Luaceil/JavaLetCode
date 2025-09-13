package string;

import java.util.Scanner;
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('a','z');
        map.put('b','a');
        map.put('c','b');
        map.put('d','c');
        map.put('e','d');
        map.put('f','e');
        map.put('g','f');
        map.put('h','g');
        map.put('i','h');
        map.put('j','i');
        map.put('k','j');
        map.put('l','k');
        map.put('m','l');
        map.put('n','m');
        map.put('o','n');
        map.put('p','o');
        map.put('q','p');
        map.put('r','q');
        map.put('s','r');
        map.put('t','s');
        map.put('u','t');
        map.put('v','u');
        map.put('w','v');
        map.put('x','w');
        map.put('y','x');
        map.put('z','y');
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T!=0){
            int N=in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            int cur = -1;
            for(int i=0;i<N;i++){
                if(str.charAt(i)!='a')
                {cur = i;break;}
            }
            int length =N-cur;
            if(length>=26){
                String preStr = str.substring(0,cur);
                for(int i=cur;i<cur+26;i++) {
                    if (str.charAt(i) == 'a') {
                        String newStr = "z";
                        preStr = preStr + newStr;
                    } else {
                        char a = map.get(str.charAt(i));
                        String newStr = a + "";
                        preStr = preStr + newStr;
                    }
                }
                str=preStr+str.substring(cur+25);
            }
            System.out.println(str);

            T--;
        }
    }
}