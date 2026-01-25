
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static class Disk implements Comparable<Disk>{
        int start;
        int work;

        public Disk(int start, int work) {
            this.start = start;
            this.work = work;
        }

        @Override
        public int compareTo(Disk o) {
            return this.work - o.work; // 소요 시간 짧은 순
        }
    }
    public static void main(String args[]) throws IOException {
//        jobs	return
//        우선순위 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높습니다.
//[[0, 3], [1, 9], [3, 5]]	8

        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        int answer =0;


        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<Disk> diskPriorityQueue = new PriorityQueue<>();

        int time = 0;
        int totalWait = 0;
        int count = 0;
        int jobIdx = 0;

        while (count<jobs.length){
            while (jobIdx<jobs.length && jobs[jobIdx][0] <=time){
                diskPriorityQueue.add(new Disk(jobs[jobIdx][0], jobs[jobIdx][1]));
                jobIdx++;
            }

            if(diskPriorityQueue.isEmpty()){
                time = jobs[jobIdx][0];
            } else{
                Disk current = diskPriorityQueue.poll();
                totalWait += (time - current.start) + current.work;
                time += current.work;
                count++;
            }
        }
        answer = totalWait / jobs.length;


//        return totalWait / jobs.length;
//
//        System.out.println(result);

    }
}
