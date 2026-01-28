

import java.io.IOException;
import java.util.*;

public class Main {
//    sizes	result
//{{60, 50], {30, 70], [60, 30], [80, 40]]	4000
//        [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
//        [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133

    public static void main(String args[]) throws IOException {

        int[][] sizes = {{60, 50},{30, 70},{60, 30},{80, 40}};
        int maxWidth = -1;
        int maxHeight = -1;
        for (int[] size : sizes) {

            int length = Math.max(size[0], size[1]);
            int breadth = Math.min(size[0], size[1]);

            maxWidth = Math.max(maxWidth, length);
            maxHeight = Math.max(maxHeight, breadth);
        }
        int answer  = maxWidth * maxHeight;
//        return answer;
    }
}
