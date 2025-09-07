import java.util.Arrays;
import java.util.Scanner;

///* 小明接触到了一款城市建设的游戏。在这个游戏玩家需要建造很多的设施。其中一些设施可以提供电力,而另
///* 一些则会消耗电力。每种设施均只能建造至多一个。且建造设施还需要花费一定的资金。
///* 如果某一时刻剩余电量(即所有发电设施产生的电力减去其他设施肖耗的电力)恰好为1,则可以获得《高手
///* 电量》这一稀有成就。小明现在希望获得这一成就,请你帮他计算,如何才能在花费最少资金的情况下达成这
/// 4
/// 8 1
/// -4 2
/// -2 3
/// -1 4
///* 一成就。

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        class Factory{
            int elec;
            int cost;
        }
        Factory[] facArr = new Factory[N];
        for(int i=0;i<N;i++){
            Factory fac = new Factory();
            fac.elec = sc.nextInt();
            fac.cost = sc.nextInt();
            facArr[i] = fac;
        }
        sc.close();
//        Arrays.stream(facArr).forEach(i->{
//            System.out.println("elec"+i.elec+" cose"+i.cost);
//        });
        int[] prev = new int[12001];
        Arrays.fill(prev,Integer.MAX_VALUE);
        prev[6000]=0;
        for(int i=0;i<N;i++){
            int[] current =Arrays.copyOf(prev,prev.length);
            for(int j=0;j<12001;j++){
                if(prev[j]==Integer.MAX_VALUE) continue;
                int elec = j-6000;
                int newElec = facArr[i].elec + elec;
                int jNext = newElec+6000;
                if(newElec>=-6000&&newElec<=6000){
                    if(current[jNext]>prev[j]+facArr[i].cost){
                        current[jNext] = prev[j]+facArr[i].cost;
                    }
                }
            }

            prev =current;
        }
        if(prev[6001]==Integer.MAX_VALUE){System.out.println(-1);}
        else{System.out.println(prev[6001]);}
    }
}
