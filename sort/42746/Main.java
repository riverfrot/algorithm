
import java.awt.print.Pageable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String args[]) throws IOException {
//        array	commands	return
//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]

        int[] numbers = {6, 10, 2};
        String[] arrays = new String[numbers.length];

        for(int i =0; i< numbers.length; i++){
            arrays[i] = String.valueOf(numbers[i]);
        }

        //두개의 문자열을 합쳤을때 더 큰값을 앞으로 정렬
        Arrays.sort(arrays, ((o1, o2) -> (o2+o1).compareTo(o1+o2)));

        if(arrays[0].equals("0")){
            System.out.println("0");
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(arrays).forEach(sb::append);
        System.out.println(sb.toString());
    }
}
