import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Pos {
        int x;
        int y;
        public Pos(int y, int x){
            this.y=y;
            this.x=x;
        }
    }

    public static void main(String args[]) throws IOException {
        int dy[] = {1,0,-1,0};
        int dx[] = {0,1,0,-1};

        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int n = maps.length;    // 세로(y)
        int m = maps[0].length; // 가로(x)
        int[][] visited = new int[n][m];
        for(int[] visit : visited){
            Arrays.fill(visit,-1);
        }

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0,0));
        visited[0][0]=1;

        while (!queue.isEmpty()){
            Pos currentPos = queue.poll();

            for(int i=0; i<4; i++){
                int ny = dy[i]+currentPos.y;
                int nx = dx[i]+currentPos.x;


                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(visited[ny][nx] != -1 || maps[ny][nx] == 0) continue;

                queue.add(new Pos(ny,nx));
                visited[ny][nx]=visited[currentPos.y][currentPos.x]+1;
            }
        }

        System.out.println(visited[n-1][m-1]);
    }

}
