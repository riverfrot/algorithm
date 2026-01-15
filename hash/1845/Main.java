

import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {

//        nums	result
//        [3,1,2,3]	2
//        [3,3,3,2,2,4]	3
//        [3,3,3,2,2,2]	2

        int[] nums = {3,3,3,2,2,4};

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int mapSize = map.keySet().size();
        int solv = nums.length/2;
        if(solv>mapSize){
            System.out.println(mapSize);
        }else {
            System.out.println(solv);
        }
    }
}
