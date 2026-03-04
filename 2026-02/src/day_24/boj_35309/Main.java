package day_24.boj_35309;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        out:
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Deque<Integer> stack = new ArrayDeque<>();
            for (int x : arr) {
                if (x == 1 || (!stack.isEmpty() && stack.peek() + 1 == x)) {
                    stack.push(x);
                } else {
                    while (!stack.isEmpty() && stack.peek() + 1 != x) {
                        while (!stack.isEmpty() && stack.peek() != 1) {
                            stack.pop();
                        }
                        stack.pop();
                    }

                    if (stack.isEmpty() || stack.peek() + 1 != x) {
                        bw.write("NO\n");
                        continue out;
                    } else {
                        stack.push(x);
                    }
                }
            }

            bw.write("YES\n");
        }

        bw.flush();
    }
}
