package sort

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String args[]) throws IOException {
//        array	commands	return
//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]

        int[] citations = {3, 0, 6, 1, 5};
//        Arrays.sort(citations,(o1,o2)-> Comparator.reverseOrder().compare(o1, o2));
        Arrays.sort(citations);
        int hIndex = 0;
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;

            // 현재 논문의 인용 횟수가 h편 이상인지 확인
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }
        System.out.println(hIndex);
    }
}
