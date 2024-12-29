package day_27.BOJ_1463;

import java.io.*;
import java.util.*;

public class Main_DFS {

    private static final Map<Integer, Integer> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp.put(1, 0);

        System.out.println(dfs(N));
    }

    private static int dfs(int N) {
        if (dp.containsKey(N)) return dp.get(N);

        if (N % 6 == 0) dp.put(N, Math.min(dfs(N - 1), Math.min(dfs(N / 3), dfs(N / 2))) + 1);
        else if (N % 3 == 0) dp.put(N, Math.min(dfs(N / 3), dfs(N - 1)) + 1);
        else if (N % 2 == 0) dp.put(N, Math.min(dfs(N / 2), dfs(N - 1)) + 1);
        else dp.put(N, dfs(N - 1) + 1);

        return dp.get(N);
    }

}
