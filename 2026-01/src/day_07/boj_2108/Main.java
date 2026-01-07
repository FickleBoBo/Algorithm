package day_07.boj_2108;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 4000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int sum = 0;
        int[] cntArr = new int[MAX + 1 + MAX];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            cntArr[arr[i] + MAX]++;
        }
        Arrays.sort(arr);

        int max = 0;  // 최빈값의 최댓값
        int cntMax = 0;  // 최빈값의 최댓값이 등장한 횟수
        for (int cnt : cntArr) {
            if (cnt > max) {
                max = cnt;
                cntMax = 1;
            } else if (cnt == max) {
                cntMax++;
            }
        }
        cntMax = Math.min(cntMax, 2);

        int mode = 0;  // 최빈값
        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] == max) cntMax--;
            if (cntMax == 0) {
                mode = i - MAX;
                break;
            }
        }

        System.out.println(Math.round((double) sum / N));
        System.out.println(arr[N / 2]);
        System.out.println(mode);
        System.out.println(arr[N - 1] - arr[0]);
    }
}
