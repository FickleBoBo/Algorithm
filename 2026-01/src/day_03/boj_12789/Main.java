package day_03.boj_12789;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        boolean isPossible = true;

        for (int need = 1; need <= N; need++) {
            if (!stack.isEmpty() && stack.peek() == need) {
                stack.pop();
            } else {
                while (idx < N && arr[idx] != need) {
                    stack.push(arr[idx++]);
                }

                if (idx == N) {
                    isPossible = false;
                    break;
                }
                idx++;
            }
        }

        if (isPossible) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
