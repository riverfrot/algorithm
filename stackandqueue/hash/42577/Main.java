
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
//phone_book	return
//["119", "97674223", "1195524421"]	false
//["123","456","789"]	true
//["12","123","1235","567","88"]	false

        String[] phone_book = {"119", "97674223", "1195524421"};
        //정렬 하고 푸냐 아니면 바로 푸냐
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i< phone_book.length; i++){
            map.put(phone_book[i],1);
        }

        boolean isFound = false;
        for(String key: map.keySet()){
                System.out.println("KEY :" +key);
            if(isFound){
                break;
            }
            for(int j=0; j<20; j++){
                if(key.length()-1==j){
                    break;
                }

                System.out.println("KEY :" +key.substring(0,j+1));
                if(map.get(key.substring(0,j+1))!=null){
                    isFound = true;
                    break;
                }
            }
        }

        System.out.println(isFound);
    }
}
