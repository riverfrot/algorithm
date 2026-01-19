
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Position{
        int weight;
        int outTime;
        public Position(int weight, int outTime){
            this.weight =weight;
            this.outTime = outTime;
        }
    }

    public static void main(String args[]) throws IOException {
//[2, 1, 3, 2]	2	1
//[1, 1, 9, 1, 1, 1]	0	5
//        100	100	[10,10,10,10,10,10,10,10,10,10]
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        int time = 0;
        int currentWeight = 0;
        int truckIdx = 0;

        int answer = 0;

        Queue<Position> bridge = new LinkedList<>();

            while(truckIdx < truck_weights.length || !bridge.isEmpty()) {
                time++;
                if(!bridge.isEmpty() && bridge.peek().outTime== time) {
                    Position arrivedTruck = bridge.poll();
                    currentWeight -= arrivedTruck.weight;
                }

                if(truckIdx < truck_weights.length) {
                    if(currentWeight + truck_weights[truckIdx] <= weight && bridge.size() < bridge_length) {
                        //현재 시간 + 다리 길이 = 이 트럭이 나갈 시간
                        int outTime = time+bridge_length;
                        bridge.add(new Position(truck_weights[truckIdx],outTime));
                        currentWeight += truck_weights[truckIdx];
                        truckIdx++;
                    }
                }
            }


            answer = time;
            System.out.println(answer);
        }
}
