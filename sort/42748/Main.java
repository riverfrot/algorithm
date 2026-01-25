
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {

    public static void main(String args[]) throws IOException {
//        array	commands	return
//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = {};
        answer = new int[commands.length];
//        for(int[] command : commands){
        for(int i=0; i< commands.length; i++){
            int []command = commands[i];
            int [] copyArr = Arrays.copyOfRange(array,command[0]-1,command[1]);
            Arrays.sort(copyArr);
//            System.out.println(command[2]);
            answer[i] = copyArr[command[2]-1];
//            System.out.println();
        }
    }
}
