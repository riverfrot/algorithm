import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        long N = Integer.parseInt(input[0]);
        long M = Integer.parseInt(input[1]);

//        int percent = M*100/N;
        long percent = M*100/N;
        int result = Integer.MAX_VALUE;

        if(percent>=99){
            System.out.println(-1);
            return;
        }
        int left = 1;
        int right = 1000000000;
        // 3. Math.floor()로 소수점 버림
//        int percent = (int) Math.floor((double) a / b * 100);
//        System.out.println("percent"+percent);
        while(left<=right){
            int mid = (left+right)/2;
            long tempN = N+mid;
            long tempM = M+mid;
            long tempPercent = tempM*100/tempN;
//            System.out.println("tempPercent"+ tempPercent+ "M"+M + "N"+N);
//            System.out.println("tempPercent"+ tempPercent+ "M"+tempM + "N"+tempN);
            if(percent<tempPercent){
                result = Math.min(result,mid);
                right = mid-1;
            }else {
                left = mid+1;
            }
        }


            System.out.println(result);

//10 8

    }
}