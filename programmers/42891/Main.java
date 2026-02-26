import java.util.*;

public class Main {

    public static int solution(int[] food_times, long k) {
        long total = 0;
        for (int t : food_times) total += t;
        if (total <= k) return -1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new long[]{food_times[i], i + 1});
        }

        long prev = 0;
        long remaining = food_times.length;

        while (!pq.isEmpty()) {
            long diff = pq.peek()[0] - prev;  // 현재 최소 음식을 다 먹으려면 각 음식당 추가로 필요한 시간
            long cost = diff * remaining;      // 한 바퀴에 remaining개씩, diff바퀴

            if (cost > k) break;               // 온전히 돌 수 없으면 중단

            k -= cost;
            prev = pq.poll()[0];
            remaining--;
        }

        // 남은 음식들을 원래 번호 기준 오름차순 정렬
        List<long[]> left = new ArrayList<>(pq);
        left.sort((a, b) -> Long.compare(a[1], b[1]));

        return (int) left.get((int) (k % remaining))[1];
    }


    public static void main(String[] args) throws Exception {
        //입출력 예
//        food_times	k	result
//          [3, 1, 2]	5	1
        int food_times[] = {3, 1, 2};
        int k = 5;
        System.out.println("Result : "+solution(food_times,k));
    }

}