
import java.io.IOException;
import java.util.*;

public class Main {

    public static void makePermutation(int depth, StringBuilder sb, HashSet<Integer> set) {
        if (depth > 0) {
            set.add(Integer.parseInt(sb.substring(0, depth)));
        }

        if (depth == sb.length()) {
            return;
        }

        for (int i = depth; i < sb.length(); i++) {
            swap(sb, depth, i); // i번째 숫자를 현재 depth 자리로 가져옴
            makePermutation(depth + 1, sb, set); // 다음 자리 결정
            swap(sb, depth, i); // 원상 복구
        }
    }

    public static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

    public static void main(String args[]) throws IOException {

//numbers	return
//"17"	3
//"011"	2
        String numbers = "17";
        HashSet<Integer> setData = new HashSet<>();
        makePermutation(0, new StringBuilder(numbers),setData);

        long count = setData.stream().filter(integer -> {
            if(integer<2) return false;
            for(int i=2; i<=(int)Math.sqrt(integer); i++){
                if(integer%i==0) return false;
            }
            return true;
        }).count();
        System.out.println(count);

    }
}
