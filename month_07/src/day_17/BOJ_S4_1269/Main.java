package day_17.BOJ_S4_1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cntA = Integer.parseInt(st.nextToken());
        int cntB = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            if(set.contains(n)){
                cntA--;
                cntB--;
            }
        }

        System.out.println(cntA + cntB);
    }
}
