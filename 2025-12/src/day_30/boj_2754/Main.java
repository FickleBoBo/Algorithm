package day_30.boj_2754;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String grade = br.readLine();
        double ans = 0;

        if (grade.charAt(0) == 'A') {
            ans += 4;
        } else if (grade.charAt(0) == 'B') {
            ans += 3;
        } else if (grade.charAt(0) == 'C') {
            ans += 2;
        } else if (grade.charAt(0) == 'D') {
            ans += 1;
        } else {
            System.out.println(ans);
            return;
        }

        if (grade.charAt(1) == '+') {
            ans += 0.3;
        } else if (grade.charAt(1) == '-') {
            ans -= 0.3;
        }

        System.out.println(ans);
    }
}
