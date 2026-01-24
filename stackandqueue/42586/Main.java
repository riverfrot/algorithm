
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Queue<Integer> daysQueue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i];
            // 올림 처리를 위해 (나머지가 있으면 +1) 하는 방식
            int day = (remaining % speeds[i] == 0) ?
                    remaining / speeds[i] : (remaining / speeds[i]) + 1;
            daysQueue.add(day);
        }

        List<Integer> answer = new ArrayList<>();

        while (!daysQueue.isEmpty()) {
            int currentDeployDay = daysQueue.poll();
            int count = 1;

            // 기준일보다 빨리 혹은 같이 끝나는 뒤의 기능들을 모두 한 그룹으로 묶음
            while (!daysQueue.isEmpty() && daysQueue.peek() <= currentDeployDay) {
                daysQueue.poll();
                count++;
            }

            answer.add(count);
        }

    }
}
