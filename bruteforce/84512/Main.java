
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static int CharToInt(String character){
        int value = 0;
        if(character.equals("E")){
            value =1;
        }else if(character.equals("I")){
            value =2;
        }else if(character.equals("O")){
            value =3;
        }else if(character.equals("U")){
            value =4;
        }
        return  value;
    }

    public static void main(String args[]) throws IOException {
//        781 = 5^0 + 5^1 + 5^2 + 5^3 + 5^4
//        156 = 5^0 + 5^1 + 5^2 + 5^3
//        31 = 5^0 + 5^1 + 5^2
//        6 = 5^0 + 5^1
//        1 = 5^0
//      등비수열로 풀이

        String word = "EIO";
        String[] arr= word.split("");
        int multiply = 1;
        int answer = 0;
        for(int i=0; i<arr.length; i++){
            int charPosition = CharToInt(arr[i]);

            if(i==0){
                multiply = 781;

            }else if (i==1){
                multiply = 156;
            } else if (i==2){
                multiply = 31;
            } else if (i==3){
                multiply = 6;
            } else if (i==4){
                multiply = 1;
            }
            answer+= (charPosition*multiply) +1;
        }

        System.out.println(answer);

    }
}
