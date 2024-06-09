package day_09.BOJ_G3_11437;

import java.io.*;
import java.util.*;

public class Main2 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parents = new int[1+N];

        List<Integer>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0 ; i<N-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            adj[nodeA].add(nodeB);
            adj[nodeB].add(nodeA);
        }

        int[] height = BFS(N, adj);

        int M = Integer.parseInt(br.readLine());

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            sb.append(find(nodeA, nodeB, N, adj, height) + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int[] BFS(int N, List<Integer>[] adj){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        boolean[] visited = new boolean[1+N];
        visited[1] = true;

        int[] height = new int[1+N];
        int level = 0;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0 ; i<len ; i++){
                int node = q.poll();
                for(int next : adj[node]){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next] = true;
                        parents[next] = node;
                    }
                }
                height[node] = level;
            }
            level++;
        }

        return height;
    }

    private static int find(int A, int B, int N, List<Integer>[] adj, int[] height){
        boolean[] ancestorOfA = new boolean[1+N];


        while(height[A] > height[B]){
            A = parents[A];
        }
        while(height[A] < height[B]){
            B = parents[B];
        }

        while(A != B){
            A = parents[A];
            B = parents[B];
        }

        return A;
    }

}
