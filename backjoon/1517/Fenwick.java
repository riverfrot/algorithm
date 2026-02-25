import java.io.*;
import java.util.*;

public class Fenwick {
    static int[] tree;

    static class Element implements Comparable<Element> {
        int value;
        int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Element o) {
            // 1순위: 값 내림차순
            // 2순위: 인덱스 내림차순 (이 부분이 수정되었습니다!)
            if (this.value == o.value) return o.index - this.index;
            return Integer.compare(o.value, this.value);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Element[] elements = new Element[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(Integer.parseInt(st.nextToken()), i + 1);
        }

        Arrays.sort(elements);

        tree = new int[n + 1];
        long swapCount = 0;

        for (int i = 0; i < n; i++) {
            int originIdx = elements[i].index;

            swapCount += query(originIdx - 1);
            update(originIdx, 1, n);
        }

        System.out.println(swapCount);
    }

    static void update(int i, int delta, int max) {
        for (; i <= max; i += (i & -i)) {
            tree[i] += delta;
        }
    }

    static int query(int i) {
        int sum = 0;
        for (; i > 0; i -= (i & -i)) {
            sum += tree[i];
        }
        return sum;
    }
}