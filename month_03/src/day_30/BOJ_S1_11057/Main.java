package day_30.BOJ_S1_11057;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[1+N+1][10+1];

        Arrays.fill(dp[1], 0, 10, 1);
        for(int i=2 ; i<=N+1 ; i++){
            for(int j=9 ; j>=0 ; j--){
                dp[i][j] = (dp[i-1][j] + dp[i][j+1])%10007;
            }
        }

        System.out.println(dp[N+1][0]);

        sc.close();
    }
}
