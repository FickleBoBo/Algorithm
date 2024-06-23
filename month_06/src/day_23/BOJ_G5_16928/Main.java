package day_23.BOJ_G5_16928;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int NM = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        int[] map = new int[1 + 100];

        for(int i=0 ; i<NM ; i++){    // NM은 N + M - 따로 해도 아무 상관 없음
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a] = b;
        }

        int ans = BFS(map);

        System.out.println(ans);
    }

    private static int BFS(int[] map){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        boolean[] visited = new boolean[1 + 100];
        visited[1] = true;

        int ans = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int node = q.poll();

                if(node == 100){
                    return ans;
                }

                for(int j=1 ; j<=6 ; j++){
                    int next = node + j;

                    if((next <= 100) && !visited[next]){
                        if(map[next] == 0){
                            q.offer(next);
                            visited[next] = true;
                        }
                        else{
                            q.offer(map[next]);
                            visited[map[next]] = true;
                        }
                    }
                }
            }

            ans++;
        }

        return -1;
    }

}
