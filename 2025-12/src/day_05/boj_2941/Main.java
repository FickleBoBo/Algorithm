package day_05.boj_2941;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'c') {
                if (i + 1 < arr.length && (arr[i + 1] == '=' || arr[i + 1] == '-')) {
                    i++;
                }
            } else if (arr[i] == 'd') {
                if (i + 1 < arr.length && arr[i + 1] == '-') {
                    i++;
                } else if (i + 2 < arr.length && arr[i + 1] == 'z' && arr[i + 2] == '=') {
                    i += 2;
                }
            } else if (arr[i] == 'l' || arr[i] == 'n') {
                if (i + 1 < arr.length && arr[i + 1] == 'j') {
                    i++;
                }
            } else if (arr[i] == 's' || arr[i] == 'z') {
                if (i + 1 < arr.length && arr[i + 1] == '=') {
                    i++;
                }
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
