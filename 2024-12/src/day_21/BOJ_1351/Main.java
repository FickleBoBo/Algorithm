package day_21.BOJ_1351;

import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Long, Long> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        dp.put(0L, 1L);

        System.out.println(dfs(N, P, Q));
    }

    private static long dfs(long N, int P, int Q) {
        if (dp.containsKey(N)) return dp.get(N);
        dp.put(N, dfs(N / P, P, Q) + dfs(N / Q, P, Q));
        return dp.get(N);
    }

}
