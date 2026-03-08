package day_07.boj_1976;

import java.io.*;
import java.util.*;

public class Main {

    static int[] p;

    static void make(int n) {
        p = new int[1 + n];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
    }

    static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        p[find(y)] = find(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        make(n);
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int root = find(Integer.parseInt(st.nextToken()));
        m--;

        while (m-- > 0) {
            if (root != find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
