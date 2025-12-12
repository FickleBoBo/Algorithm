package day_12.boj_2851;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if (sum + arr[i] <= 100) {
                sum += arr[i];
                continue;
            }

            if ((100 - sum) >= (sum + arr[i] - 100)) {
                sum += arr[i];
                continue;
            }

            break;
        }

        System.out.println(sum);
    }
}
