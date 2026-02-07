package day_03.boj_31429;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println("12 1600");
        } else if (n == 2) {
            System.out.println("11 894");
        } else if (n == 3) {
            System.out.println("11 1327");
        } else if (n == 4) {
            System.out.println("10 1311");
        } else if (n == 5) {
            System.out.println("9 1004");
        } else if (n == 6) {
            System.out.println("9 1178");
        } else if (n == 7) {
            System.out.println("9 1357");
        } else if (n == 8) {
            System.out.println("8 837");
        } else if (n == 9) {
            System.out.println("7 1055");
        } else if (n == 10) {
            System.out.println("6 556");
        } else {
            System.out.println("6 773");
        }
    }
}
