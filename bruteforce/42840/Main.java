
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
//    sizes	result
//{{60, 50], {30, 70], [60, 30], [80, 40]]	4000
//        [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
//        [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
//1, 2, 3, 4, 5 //모듈러 연산
//2, 1, 2, 3, 2, 4, 2, 5 // 모듈러 연산
//3, 3, 1, 1, 2, 2, 4, 4, 5, 5
//    마지막 정렬
//    answers	return
//[1,2,3,4,5]	[1]
//[1,3,2,4,2]	[1,2,3]
    static class Person {
        int index;
        int answerCnt;
        Person(int index, int answerCount){
            this.index = index;
            this.answerCnt = answerCount;
        }

    }


    public static void main(String args[]) throws IOException {

        int[] answers = {1,3,2,4,2};
        int[] person_1 = {1, 2, 3, 4, 5};
        int[] person_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        Person[] pArray = new Person[3];
        pArray[0]= new Person(1,0);
        pArray[1]= new Person(2,0);
        pArray[2]= new Person(3,0);
        for(int i=0; i< answers.length; i++){

            if(person_1[i%person_1.length]==answers[i]){
                pArray[0].answerCnt++;
            }
            if(person_2[i%person_2.length]==answers[i]){
                pArray[1].answerCnt++;
            }
            if(person_3[i%person_3.length]==answers[i]){
                pArray[2].answerCnt++;
            }
//            System.out.println(person_1[i%person_1.length]);
//            System.out.println(person_2[i%person_2.length]);
//            System.out.println(person_3[i%person_3.length]);
        }


        Arrays.sort(pArray, (o1, o2) -> {
            return o2.answerCnt  - o1.answerCnt;
        });

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(pArray[0].index);
        System.out.println("index : "+ pArray[0].index+ " value : "+pArray[0].answerCnt);
        System.out.println("index : "+ pArray[1].index+ " value : "+pArray[1].answerCnt);
        System.out.println("index : "+ pArray[2].index+ " value : "+pArray[2].answerCnt);
        if(pArray[0].answerCnt==pArray[1].answerCnt){
            arrayList.add(pArray[1].index);
        }
        if(pArray[0].answerCnt==pArray[2].answerCnt){
            arrayList.add(pArray[2].index);
        }
        arrayList.stream().forEach(System.out::println);
        int pr[] = arrayList.stream().mapToInt(i->i).toArray();

        System.out.println(pr.length);
//        return answer;
    }
}
