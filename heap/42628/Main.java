
import java.io.IOException;
import java.util.TreeMap;

public class Main {

    public static void main(String args[]) throws IOException {
//        operations	return
//["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0,0]
//["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
//        I 숫자	큐에 주어진 숫자를 삽입합니다.
//        D 1	큐에서 최댓값을 삭제합니다.
//                D -1	큐에서 최솟값을 삭제합니다.

        TreeMap<Integer,Integer> map = new TreeMap<>();
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        for(String operation : operations){
            String[] arr = operation.split(" ");
            if(arr[0].equals("I")){
                int value = Integer.parseInt(arr[1]);
                map.put(value,map.getOrDefault(value,0)+1);
            }else if(!map.isEmpty() && arr[0].equals("D") && arr[1].equals("1")){
                //최대 값 삭제
                int max = map.lastKey();
                if(map.get(max)==1){
                    map.remove(max);
                }else {
                    map.put(max,map.get(max)-1);
                }
            }else if(!map.isEmpty() && arr[0].equals("D") && arr[1].equals("-1")){
                // 최소값 삭제
                int min = map.firstKey();
                if(map.get(min)==1){
                    map.remove(min);
                }else {
                    map.put(min, map.get(min)-1);
                }
            }
        }

        if(map.isEmpty()){
//            System.out.println("empty");
//            answer = [0,0];
        }else {
//            System.out.println("min: "+ map.firstKey()+" max : "+ map.lastKey());
//            answer = [map.lastKey(),map.firstKey()];
        }

    }
}
