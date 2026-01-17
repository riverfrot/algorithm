

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
//        String[] participant, String[] completion
//        participant	completion	return
//["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
//["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
//["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i< participant.length; i++){
            map.put(participant[i],map.getOrDefault(participant[i],0)+1);
        }

        for(int i=0; i< completion.length; i++){
            map.put(completion[i],map.get(completion[i])-1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break; // 찾았으면 바로 종료 가능!
            }
        }

        // 타입스크립트와 다르게 자바는 람다 내부의 값을 바꿀때 지역변수를 수정 하는게 불가능함
        String[] result = new String[1];
        map.forEach((key, value) -> {
            if (value != 0) {
                result[0] = key;
            }
        });
        System.out.println(result[0]);
//        map.forEach((key,value)->{
//            if(value==1){
//                System.out.println(key);
//                return;
//            }
//        });

    }
}
