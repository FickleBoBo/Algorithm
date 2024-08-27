package day_24.BOJ_S3_2910;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())));

        for(Map.Entry<Integer, Integer> item : list){
            int key = item.getKey();
            int value = item.getValue();

            for(int i=0 ; i<value ; i++){
                sb.append(key).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
