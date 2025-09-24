package solution1;

import java.util.*;
///https://mp.weixin.qq.com/s/Wg8JO10bZ8tYzoVFax3fvA
public class Main {
    static class Edge{
        int station;
        int price;
        public Edge(int station,int price){
            this.station =station;
            this.price =price;
        }
    }
    static class Node{
        int station;
        int cost;
        public Node(int station,int cost){
            this.station=station;
            this.cost=cost;
        }
    }
    public static void main(String[] args) {
        //建图
        Scanner sc = new Scanner(System.in);
        String[] firstLine =sc.nextLine().split(" ");
        int M = Integer.parseInt(firstLine[0]);
        int X = Integer.parseInt(firstLine[1]);
        int Y = Integer.parseInt(firstLine[2]);
        int Z = Integer.parseInt(firstLine[3]);
        //System.out.println(M);
        List<List<Edge>> adj = new ArrayList<>();
        int maxStation = 500;
        for(int i=0;i<=maxStation;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            String[] line = sc.nextLine().split(" ");
          //  Arrays.stream(line).forEach(System.out::println);
            int price = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);
            int[] stations =new int[n];
            for(int j=0;j<n;j++){
                stations[j] = Integer.parseInt(line[2+j]);
            }
            for(int j=0;j<n-1;j++){
                int from = stations[j];
                int to = stations[j+1];
                adj.get(from).add(new Edge(to,price));
            }
        }
        int[] dist =new int[maxStation+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[X] =0;
        PriorityQueue<Node> pq =new PriorityQueue<>((a,b)-> a.cost-b.cost);
        pq.offer(new Node(X,0));
        while(!pq.isEmpty()){
            Node curr= pq.poll();
            if(curr.cost>dist[curr.station]){
                continue;
            }
            for(Edge e:adj.get(curr.station)){
                int newCost =curr.cost+e.price;
                if(newCost<dist[e.station]){
                    dist[e.station] =newCost;
                    pq.offer(new Node(e.station,newCost));
                }
            }
        }
        if(dist[Y]==Integer.MAX_VALUE||dist[Y]>Z){
            System.out.println(-1);
        }
        else{
            System.out.println(dist[Y]);
        }
        sc.close();
    }
}
