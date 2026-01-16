
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
//phone_book	return
//["119", "97674223", "1195524421"]	false
//["123","456","789"]	true
//["12","123","1235","567","88"]	false

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        //정렬 하고 푸냐 아니면 바로 푸냐
        HashMap<String,Integer> map = new HashMap<>();
        int length = clothes.length;
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],1)+1);
        }
        int result = 1;
        for(String key : map.keySet()){
            result*=map.get(key);
        }

        result = result-1;
//        아무것도 안입는겨웅에 케이스를 추가한거임,ㅡ로
        System.out.println(result);
    }
}
