package day_07.boj_14003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> dp = new ArrayList<>();

        int[] pos = new int[N];
        int[] prev = new int[N];
        Arrays.fill(prev, -1);

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int idx = lowerBound(dp, num);

            if (idx == dp.size()) {
                dp.add(num);
            } else {
                dp.set(idx, num);
            }

            pos[idx] = i;
            if (idx > 0) prev[i] = pos[idx - 1];
        }

        sb.append(dp.size()).append("\n");
        sb.append(traceback(arr, prev, pos[dp.size() - 1]));

        bw.write(sb.toString());
        bw.flush();
    }

    static int lowerBound(List<Integer> list, int key) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    static String traceback(int[] arr, int[] prev, int pos) {
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();
        while (pos != -1) {
            stack.push(arr[pos]);
            pos = prev[pos];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString();
    }
}
