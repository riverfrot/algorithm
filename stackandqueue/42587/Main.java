
import java.io.IOException;
import java.util.*;

public class Main {
    static class Position{
        int priority;
        int index;
        public Position(int priority, int index){
            this.priority =priority;
            this.index = index;
        }
    }

    public static void main(String args[]) throws IOException {
//[2, 1, 3, 2]	2	1
//[1, 1, 9, 1, 1, 1]	0	5
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int answer = 0;

        Queue<Position> positionQueue = new LinkedList<>();

        for(int i=0; i<priorities.length; i++){
            positionQueue.add(new Position(priorities[i],i));
        }

        Arrays.sort(priorities);
        int targetIdx = priorities.length-1;


        while(!positionQueue.isEmpty()){
            Position pos = positionQueue.poll();

            if(pos.priority == priorities[targetIdx]){
                answer++;
                targetIdx--; // 다음으로 높은 우선순위 준비
                if(location==pos.index){
                    break;
                }
            }else {
                positionQueue.add(pos);
            }

        }

        System.out.println(answer);

    }
}
