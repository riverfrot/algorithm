import java.io.*;
import java.util.*;

public class Main {
    // 1. 결정 함수: mid 길이로 잘랐을 때 M개 이상의 파닭이 나오는가?
    static boolean check(long mid, int M, int arr[]) {
        if (mid == 0) return true; // 0으로 나누기 방지

        long count = 0; // 파닭 개수는 int 범위를 넘을 수 있으므로 long
        for (int k : arr) {
            count += (k / mid);
        }

        // 목표한 M개보다 많이 만들어진다면, 더 길게 자를 수 있다는 뜻!
        return count >= M;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 파의 개수
        int M = Integer.parseInt(st.nextToken()); // 주문받은 파닭 수

        int arr[] = new int[N];
        long totalSum = 0; // 모든 파의 길이 합 (정답 도출용)
        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            totalSum += arr[i];
            if (arr[i] > maxLen) maxLen = arr[i];
        }

        long left = 1;
        long right = maxLen; // 가장 긴 파의 길이를 right로 설정
        long answer = 0;

        // 2. 매개변수 탐색 (Parametric Search)
        while (left <= right) {
            long mid = (left + right) / 2;

            if (check(mid, M, arr)) {
                // M개 이상 만들 수 있다면? 일단 정답 후보로 저장하고 더 길게 시도!
                answer = mid;
                left = mid + 1;
            } else {
                // M개를 못 만든다면? 너무 길게 자른 것이므로 길이를 줄임!
                right = mid - 1;
            }
        }

        // 3. 최종 출력: (전체 파의 합) - (파닭에 사용된 파의 합)
        // 주의: 파닭 하나에 answer만큼 들어가고, 총 M개를 만듭니다.
        System.out.println(totalSum - (long) M * answer);
    }
}