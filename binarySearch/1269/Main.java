import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String firstInput[] = br.readLine().split(" ");
        String secondInput[] = br.readLine().split(" ");

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            map.put(Integer.parseInt(firstInput[i]),1);
        }

        for(int i=0; i<M; i++){
            map.put(Integer.parseInt(secondInput[i]),map.getOrDefault(Integer.parseInt(secondInput[i]),0)+1);
        }

        int cnt=0;

        for(int value : map.values()) {
            if(value == 1) cnt++; // 중복되지 않은(한 쪽에만 있는) 원소만 카운트
        }
        
        System.out.println(cnt);

        

// 3 5
// 1 2 4
// 2 3 4 5 6        

        
    }    
}
