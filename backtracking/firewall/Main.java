import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int M;

    static int[][] maps;

    static ArrayList<Pos> blanks = new ArrayList<>();
    static ArrayList<Pos> fires = new ArrayList<>();

    static int maxSafetyArea = 0;

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];

        for (int y = 0; y < N; y++) {

            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < M; x++) {

                maps[y][x] = Integer.parseInt(st.nextToken());

                if (maps[y][x] == 0) {
                    blanks.add(new Pos(y, x));
                }

                if (maps[y][x] == 2) {
                    fires.add(new Pos(y, x));
                }
            }
        }

        // 벽 3개 세우기 DFS
        dfs(0, 0);

        System.out.println(maxSafetyArea);
    }

    // 벽 3개 조합 만들기
    static void dfs(int start, int count) {

        if (count == 3) {

            int[][] copyMaps = new int[N][M];

            for (int y = 0; y < N; y++) {
                System.arraycopy(maps[y], 0, copyMaps[y], 0, M);
            }

            // 불 DFS 확산
            for (Pos fire : fires) {
                spreadFire(copyMaps, fire.y, fire.x);
            }

            // 안전 영역 계산
            int safeArea = 0;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {

                    if (copyMaps[y][x] == 0) {
                        safeArea++;
                    }
                }
            }

            maxSafetyArea = Math.max(maxSafetyArea, safeArea);

            return;
        }

        for (int i = start; i < blanks.size(); i++) {

            Pos currentPos = blanks.get(i);

            maps[currentPos.y][currentPos.x] = 1;

            dfs(i + 1, count + 1);

            maps[currentPos.y][currentPos.x] = 0;
        }
    }

    // 불 퍼뜨리기 DFS
    static void spreadFire(int[][] copyMaps, int y, int x) {

        for (int i = 0; i < 4; i++) {

            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

            if (copyMaps[ny][nx] != 0) continue;

            copyMaps[ny][nx] = 2;

            spreadFire(copyMaps, ny, nx);
        }
    }
}