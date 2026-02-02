import java.io.IOException;

public class Main {

    public static int dfs(int[] numbers, int target, int index, int sum){
        //모든 숫자 다사용시
        if(index== numbers.length){
            return sum == target?1:0;
        }

        //재귀 호출
        // 현재 숫자를 더한경우 + 현재 숫자를 뺀 경우
        return dfs(numbers, target, index+1, sum+numbers[index])
                +dfs(numbers,target,index+1, sum-numbers[index]);
    }

    public static void main(String args[]) throws IOException {
//        numbers	target	return
//         [1, 1, 1, 1, 1]	3	5
//        [4, 1, 2, 1]	4	2
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        System.out.println(dfs(numbers,target,0,0));


    }

    //예상 흐름도
    // -1 1 1 1 1
    // -1 -1 1 1 1
    // -1 -1 -1 1 1
    // -1 -1 -1 -1 1
    // -1 -1 -1 -1 -1
    // 1 -1 1 1 1
    // -1 -1 1 1 1
    // -1 -1 -1 1 1
    //음? 이렇게 중복처리가 되는건가?

}
