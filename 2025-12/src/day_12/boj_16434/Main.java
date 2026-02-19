package day_12.boj_16434;

import java.io.*;
import java.util.*;

public class Main {

    static class Hero {
        long hMax;
        long hCur;
        long hAtk;  // 포션을 먹는 과정에서 공격력도 오버플로우 주의

        public Hero(long hMax, int hAtk) {
            this.hMax = hMax;
            this.hCur = hMax;
            this.hAtk = hAtk;
        }

        void drink(int atk, int hp) {
            hAtk += atk;
            hCur = Math.min(hCur + hp, hMax);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int hAtk = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(lowerBound(map, hAtk));
    }

    static long lowerBound(int[][] map, int hAtk) {
        long left = 1;
        long right = Long.MAX_VALUE - 1;

        while (left < right) {
            long mid = left + (right - left) / 2;

            boolean result = simul(map, new Hero(mid, hAtk));
            if (!result) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    static boolean simul(int[][] map, Hero hero) {
        for (int[] stage : map) {
            int t = stage[0];
            int a = stage[1];
            int h = stage[2];

            if (t == 1) {
                long heroAtkCnt = (h + hero.hAtk - 1) / hero.hAtk;
                long monsAtkCnt = (hero.hCur + a - 1) / a;

                if (heroAtkCnt <= monsAtkCnt) {
                    hero.hCur -= a * (heroAtkCnt - 1);
                } else {
                    return false;
                }
            } else {
                hero.drink(a, h);
            }
        }

        return true;
    }
}
