
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException {
//        String s
//        boolean answer = true;
//
//        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//        System.out.println("Hello Java");
//
//        return answer;
    //        s	answer
    //        "()()"	true
    //        "(())()"	true
    //        ")()("	false
    //        "(()("	false
        String s = "(()(";
        char arr[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char spell : arr){
            if(!stack.isEmpty()){
                System.out.println(stack.peek());
                if(stack.peek()=='(' && spell==')'){
                    stack.pop();
                    continue;
                }
            }
            stack.push(spell);
        }

        System.out.println(stack.size());
        boolean answer = false;
        if(stack.isEmpty()){
            answer = true;
        }

        System.out.println(answer);

    }
}
