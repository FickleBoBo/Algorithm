package day_04.BOJ_G3_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] p;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] cost = new int[N];
        int idx = 0;
        while(st.hasMoreTokens()){
            cost[idx++] = Integer.parseInt(st.nextToken());
        }

        p = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<K ; i++){
            sb.append(br.readLine() + " ");
        }

        st = new StringTokenizer(sb.toString(), " ");

        while(st.hasMoreTokens()){
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            p[child] = parent;
        }

        int W = Integer.parseInt(br.readLine());

        // 데이터 잘 들어갔나 확인
        System.out.printf("T : %d / N : %d / K : %d\n", T, N, K);
        System.out.println("비용 배열 : " + Arrays.toString(cost));
        System.out.println("부모자식 배열 : " + Arrays.toString(p));

        br.close();
    }

    private static int find(int x){
        if(x == p[x]){
            return x;
        }
        return find(p[x]);
    }

    private static void union(int x, int y){
        p[y] = x;
    }
}
