
import java.io.IOException;
import java.util.HashSet;

public class Main {


    public static void main(String args[]) throws IOException {

//numbers	return
//        brown	yellow	return
//                10	2	[4, 3]
//        8	1	[3, 3]
//        24	24	[8, 6]

//        가로는 brown = horizon*2+(vertical-2)*2
//         (brown/2)+2 = horizon+vertical
//        7=horizon+vertical
//        최소 vertical은 3이상 어야함 horizon은 뭐가나와도 상관없음
//        최소 탈출조건 크거나 아래 조건을 만족하면 esccape
//         (brown/2)+2 = horizon+vertical

        int brown = 24;
        int yellow = 24;

        int resultBrown = (brown/2)+2;
        int vertical=3;
        int horizon = resultBrown-vertical;
        int answer[] = new int[2];
        while(vertical<=horizon){
//            System.out.println("vertical : "+vertical);
//            System.out.println("horizon : "+horizon);
            if((horizon)*(vertical)==brown+yellow){
//                System.out.println("FoundAnswer");
                answer[0]=horizon;
                answer[1]=vertical;
                break;
            }

            vertical++;
            horizon--;
        }

//        System.out.println(answer[0]);
//        System.out.println(answer[1]);



    }
}
