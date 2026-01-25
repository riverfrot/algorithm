
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static class Food implements  Comparable<Food>{
        int scoville;
        public Food(int scoville){
            this.scoville = scoville;
        }

        @Override
        public int compareTo(Food o) {
            return this.scoville-o.scoville;
        }
    }

    public static void main(String args[]) throws IOException {
//        입출력 예
//        scoville	K	return
//[1, 2, 3, 9, 10, 12]	7	2
        int[] scoville = { 1, 2, 3, 9, 10, 12};
        int K =7;
        PriorityQueue<Food> foodPriorityQueue = new PriorityQueue<>();
        for(int i=0; i< scoville.length; i++){
            foodPriorityQueue.add(new Food(scoville[i]));
        }

        int result =0;
        while (foodPriorityQueue.peek().scoville<K){
            if (foodPriorityQueue.size() < 2) {
                result= -1; // 모든 음식을 섞어도 K 이상이 안 되는 경우
            }
            Food firstFood =foodPriorityQueue.poll();
            Food secondFood = foodPriorityQueue.poll();

            int tempScovile = firstFood.scoville+(secondFood.scoville*2);
            System.out.println(tempScovile);
            foodPriorityQueue.add(new Food(tempScovile));
            result++;
        }


        System.out.println(result);

    }
}
