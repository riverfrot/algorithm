import java.io.*;
import java.util.*;

public class MergeSort {
    static int[] arr, temp;
    static long swapCount = 0; // 정답이 int 범위를 초과할 수 있음

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        temp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n - 1);
        System.out.println(swapCount);
    }

    static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // 오른쪽 원소가 더 작다면 역전(Inversion) 발생!
                // 왼쪽 배열에 남아있는 원소의 수만큼 swapCount 증가
                temp[k++] = arr[j++];
                swapCount += (mid - i + 1);
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int idx = left; idx <= right; idx++) {
            arr[idx] = temp[idx];
        }
    }
}