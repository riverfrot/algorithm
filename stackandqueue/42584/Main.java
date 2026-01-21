package stackandqueue

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {


    public static void main(String args[]) throws IOException {
//[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
//[1, 2, 3, 2, 1]	[4, 2, 1, 1, 0]
        int[] prices = {1, 2, 3, 2, 3};
//        return answer;
        int n = prices.length;
        int[] answer = new int[n];
        //가격이 아닌 인덱스를 저장
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i); // 현재 인덱스를 스택에 넣음
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = n - 1 - index; // 마지막 시간(n-1)과의 차이 계산
        }

        System.out.println(answer);

    }
}
