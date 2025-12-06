package day_05.boj_25206;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double totalSum = 0;
        double creditSum = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) continue;

            if (grade.equals("A+")) {
                totalSum += credit * 4.5;
            } else if (grade.equals("A0")) {
                totalSum += credit * 4.0;
            } else if (grade.equals("B+")) {
                totalSum += credit * 3.5;
            } else if (grade.equals("B0")) {
                totalSum += credit * 3.0;
            } else if (grade.equals("C+")) {
                totalSum += credit * 2.5;
            } else if (grade.equals("C0")) {
                totalSum += credit * 2.0;
            } else if (grade.equals("D+")) {
                totalSum += credit * 1.5;
            } else if (grade.equals("D0")) {
                totalSum += credit;
            }
            creditSum += credit;
        }

        System.out.println(totalSum / creditSum);
    }
}
