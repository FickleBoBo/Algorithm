package day_10.BOJ_G4_1963;

import java.io.*;
import java.util.*;

public class Main {

    static boolean[] isPrime = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        init();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            st = new StringTokenizer(br.readLine());

            int primeA = Integer.parseInt(st.nextToken());
            int primeB = Integer.parseInt(st.nextToken());

            int ans = BFS(primeA, primeB);

            if(ans >= 0){
                sb.append(ans).append("\n");
            }
            else{
                sb.append("Impossible\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void init(){
        Arrays.fill(isPrime, true);

        for(int i=2 ; i*i<10000 ; i++){
            if(isPrime[i]){
                for(int j=i*i ; j<10000 ; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=0 ; i<1000 ; i++){
            isPrime[i] = false;
        }
    }

    private static int BFS(int primeA, int primeB){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(primeA);

        boolean[] visited = new boolean[10000];
        visited[primeA] = true;

        int dist = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int node = q.poll();

                if(node == primeB) return dist;

                for(int j=0 ; j<10 ; j++){
                    int changeDigit1 = node % 1000 + j * 1000;
                    if(!visited[changeDigit1] && isPrime[changeDigit1]){
                        q.offer(changeDigit1);
                        visited[changeDigit1] = true;
                    }

                    int changeDigit2 = node / 1000 * 1000 + node % 100 + j * 100;
                    if(!visited[changeDigit2] && isPrime[changeDigit2]){
                        q.offer(changeDigit2);
                        visited[changeDigit2] = true;
                    }

                    int changeDigit3 = node / 100 * 100 + node % 10 + j * 10;
                    if(!visited[changeDigit3] && isPrime[changeDigit3]){
                        q.offer(changeDigit3);
                        visited[changeDigit3] = true;
                    }

                    int changeDigit4 = node / 10 * 10 + j;
                    if(!visited[changeDigit4] && isPrime[changeDigit4]){
                        q.offer(changeDigit4);
                        visited[changeDigit4] = true;
                    }
                }
            }

            dist++;
        }

        return -1;
    }

}
