package binarySearch

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int input = Integer.parseInt(br.readLine());
        int inputArr[] =new int[input];
        int insertArr[] = new int[input];
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<input; i++){
            inputArr[i]=Integer.parseInt(st.nextToken());
            insertArr[i] = -1;
        }

        //arrayList를 사용한 이유 동적으로 증가하는 배열이 필요함
        for(int i=0; i<input; i++){
            if(arrayList.size()==0){
                arrayList.add(inputArr[i]);
                insertArr[i]=0;
            }else {
                int left =0;
                int right = arrayList.size()-1;

                if(inputArr[i]>arrayList.get(arrayList.size()-1)){
                    arrayList.add(inputArr[i]);
                    insertArr[i]= arrayList.size() - 1;
                }else {
                    // 작거나 같다면 이분 탐색으로 대치할 위치 찾기
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        // 오름차순 이분 탐색 로직
                        if (arrayList.get(mid) < inputArr[i]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }


                        arrayList.set(left, inputArr[i]);
                        insertArr[i] = left;
                }

            }
        }

        //역추적 부분이 필요(백트랙킹)

        int targetIndex = arrayList.size() -1;
        Stack<Integer> stacck = new Stack<>();

        for(int i= input-1; i>=0; i--){
            if(insertArr[i]==targetIndex){
                stacck.push(inputArr[i]);
                targetIndex--;
            }
        }

        while(!stacck.isEmpty()){
            sb.append(stacck.pop()).append(" ");
        }

        System.out.println(arrayList.size());
        System.out.println(sb.toString());
    }
}