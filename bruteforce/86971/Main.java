
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static ArrayList<Integer>[] adj;


    //인접한 간선 counting
    public static int dfs(int curr, int skip, boolean[] visited){
        visited[curr] =true;
        int cnt = 1;
        for (int next: adj[curr]){
            if(!visited[next] && next !=skip){
                cnt += dfs(next,skip,visited);
            }
        }
        return cnt;
    }

    public static void main(String args[]) throws IOException {

//    n	wires	result
//9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
//        4	[[1,2],[2,3],[3,4]]	0
//        7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	1

        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int answer = Integer.MAX_VALUE;

        adj = new ArrayList[n+1];
        for(int i=1; i<= n; i++){
            adj[i] = new ArrayList<>();
        }

        //간선 생성
        for(int[] wire: wires){
            int v1 = wire[0];
            int v2 = wire[1];
            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        for(int[] wire: wires){
            int curr = wire[0];
            int skip = wire[1];

            boolean visited[] = new boolean[n+1];
            int conn = dfs(curr,skip,visited);
            int other = n-conn;
            answer = Math.min(answer,Math.abs(other-conn));
        }
        System.out.println(answer);


//
//        boolean visited[] = new boolean[dungeons.length];
//        Arrays.fill(visited,false);
//        int answer = dfs(k,dungeons,visited);
//        System.out.println(answer);

    }
}
