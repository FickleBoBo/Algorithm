package day_10.BOJ_G4_1976;

import java.io.*;
import java.util.*;

public class Main {

    static int[] p;

    private static int find(int x){
        if(x != p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private static void union(int x, int y){
        p[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<int[]> edges = new LinkedList<>();

        for(int i=1 ; i<=N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=N ; j++){
                if(st.nextToken().equals("1")){
                    edges.add(new int[]{i, j});
                }
            }
        }

        p = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }

        for(int[] e : edges){
            union(find(e[0]), find(e[1]));
        }

        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        int root = find(Integer.parseInt(st.nextToken()));
        while(st.hasMoreTokens()){
            if(root != find(Integer.parseInt(st.nextToken()))){
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }
}
