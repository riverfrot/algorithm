
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static ArrayList<Integer>[] adj;
    static boolean visited[];

    public static void dfs(int start){

        for(int value:adj[start]){

            if(!visited[value])
            {
                visited[value]=true;
                dfs(value);
            }

        }
    }

    public static void main(String args[]) throws IOException {

//        n	computers	return
//        3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
//        3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int n =3;
        int count =0;
        adj = new ArrayList[n+1];
        for(int i=1; i<n+1;i++){
            adj[i]=new ArrayList<>();
        }
         visited= new boolean[n+1];
        for(int i=1; i<n+1;i++){
            for(int j=1; j<n+1;j++) {
                if(computers[i-1][j-1]==1)
                    adj[i].add(j);
            }
        }


        for(int i=1; i<n+1;i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }

        System.out.println(count);

    }

    //예상 흐름도
    // -1 1 1 1 1
    // -1 -1 1 1 1
    // -1 -1 -1 1 1
    // -1 -1 -1 -1 1
    // -1 -1 -1 -1 -1
    // 1 -1 1 1 1
    // -1 -1 1 1 1
    // -1 -1 -1 1 1
    //음? 이렇게 중복처리가 되는건가?

}
