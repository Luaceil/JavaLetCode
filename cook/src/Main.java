import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.nextLine();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> sum = new ArrayList<>();
        for(int i = 0; i < N; i++) {
           String line =  input.nextLine();
          // System.out.println(line);
           ArrayList<Integer> lineArr=Arrays.stream( line.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayList::new));
           list.add(lineArr);
        }
        //list.stream().flatMap(Collection::stream).forEach(System.out::println);
       // list.get(0).stream().forEach(System.out::print);
        for(int i = 0; i < N; i++) {
            ArrayList<Integer> lineArr = list.get(i);
            sum.add(0);
            ArrayList<Integer> notVisit = new ArrayList<>();
            for(int j = 1; j < lineArr.size(); j++) {
               sum.set(i,list.get(i).get(j)+sum.get(i));
               notVisit.add(list.get(i).get(j));
            }
            Boolean[] isVisit =new Boolean[list.get(i).get(0)];
            if(sum.get(i)%4!=0)
            { System.out.println("no");continue;}
            int obj = sum.get(i)/4;
            for(int j = 1; j < lineArr.size(); j++) {
              if(  !dfs(notVisit,obj,j))
                  System.out.println("no");
            }
            System.out.println("yes");


        }

    }
   static boolean dfs(ArrayList<Integer> list, int target,int j)
    {
      for(int i=j+1; i<list.size();i++)
          {
           if(list.get(i)==target)
              continue;
           if(list.get(i)>target)
               return false;
          if( dfs(list,target,list.get(i)))
              continue;
          else return false;
          }
      return true;
    }

}