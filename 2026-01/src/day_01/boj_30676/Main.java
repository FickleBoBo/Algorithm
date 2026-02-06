package day_01.boj_30676;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        if (x >= 620) {
            System.out.println("Red");
        } else if (x >= 590) {
            System.out.println("Orange");
        } else if (x >= 570) {
            System.out.println("Yellow");
        } else if (x >= 495) {
            System.out.println("Green");
        } else if (x >= 450) {
            System.out.println("Blue");
        } else if (x >= 425) {
            System.out.println("Indigo");
        } else {
            System.out.println("Violet");
        }
    }
}
