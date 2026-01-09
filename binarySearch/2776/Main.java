import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i< testCase; i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());


            int firstNote[] = new int[N];
            for(int j=0; j<N; j++){
                firstNote[j]= Integer.parseInt(st.nextToken());
            }
            Arrays.sort(firstNote);

            int M = Integer.parseInt(br.readLine());
            int secondNote[] = new int[M];

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                int secondInput= Integer.parseInt(st2.nextToken());

                int left =0;
                int right=firstNote.length-1;
                
                boolean isFound = false;

                while(left<=right){
                    int mid= (left+right)/2;
                    if(firstNote[mid]==secondInput){
                        isFound=true;
                        break;
                    }else if(firstNote[mid]>secondInput){
                        right= mid-1;
                    }
                    else {
                        left = mid+1;
                    }
                }

                if(isFound){
                    sb.append("1\n");
//                    System.out.println("1");
                }else {
                    sb.append("0\n");
//                    System.out.println("0");
                }
            
            }

        }

        System.out.print(sb.toString());
    }
}