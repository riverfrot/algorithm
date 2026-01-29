
import java.io.IOException;
import java.util.Arrays;

public class Main {

    static int value = -1;

    public static int dfs(int k, int[][] dungeons, boolean []visited){
        int count = 0;
        for(int i=0; i< dungeons.length; i++){
            if(!visited[i] && k>= dungeons[i][0]){
                visited[i] =true;
                count= Math.max(count,1+dfs(k-dungeons[i][1], dungeons,visited));
                visited[i] =false;
            }
        }
        return count;
    }

    public static void main(String args[]) throws IOException {
//        80	[[80,20],[50,40],[30,10]]	3
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        boolean visited[] = new boolean[dungeons.length];
        Arrays.fill(visited,false);
        int answer = dfs(k,dungeons,visited);
        System.out.println(answer);

    }
}
