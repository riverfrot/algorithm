package stackandqueue

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
//phone_book	return
//["119", "97674223", "1195524421"]	false
//["123","456","789"]	true
//["12","123","1235","567","88"]	false
//[1,1,3,3,0,1,1]	[1,3,0,1]
//[4,4,4,3,3]	[4,3]
        int []arr = {1,1,3,3,0,1,1};
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< arr.length;i++){
            if(stack.isEmpty()) {
                stack.push(arr[i]);
            }else {
                int stackVal = stack.peek();
                if(stackVal != arr[i]){
                    stack.push(arr[i]);
                }
            }
        }


        List<Integer> list = new ArrayList<>(stack);
        list.stream().mapToInt(i ->i).toArray();

        System.out.println("Hello Java");

        return answer;
    }
}
