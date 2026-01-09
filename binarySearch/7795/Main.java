import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력값 셋팅
        int testCase = Integer.parseInt(br.readLine());
        

        for(int k=0; k<testCase; k++){

            String inputArr[] = br.readLine().split(" ");
            
            int N = Integer.parseInt(inputArr[0]);
            int M = Integer.parseInt(inputArr[1]);
            int firstArray[] = new int[N];
            int secondArray[] = new int[M];
            

            String firstInputArray[] = br.readLine().split(" ");
            String secondInputArray[] = br.readLine().split(" ");
            
            for(int i=0; i<N; i++){
                firstArray[i] = Integer.parseInt(firstInputArray[i]);
            }
            for(int i=0; i<M; i++){
                secondArray[i] = Integer.parseInt(secondInputArray[i]);
            }
            
            Arrays.sort(secondArray);
            int finalAnswer = 0;
            
            //  구현부
            //모든 경우의 수에서 현재 비교하는 값 보다 인덱스가 작은애를 찾기 만약 그 값이 존재한다면 그 값은 다 작은거임
// 1
// 5 3
// 8 1 7 3 1
// 3 6 1
            for(int i=0; i< N; i++){
            
                int target = firstArray[i];
                int left = 0;
                int right = M-1;
                int count =0;
                
                while( left<= right){
                    int mid = (left+right)/2;
                    if(secondArray[mid]>=target){
                        right = mid-1;
                    }else {
                        count = mid+1;
                        left = mid+1;
                    }
                }
                finalAnswer += count;
            }

            System.out.println(finalAnswer);
        }
    }
}