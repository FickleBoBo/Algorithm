package day_10.boj_15565;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 라이언 인형의 인덱스를 저장하는 리스트
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (st.nextToken().equals("1")) list.add(i);
        }

        // 리스트의 크기가 K보다 작으면 라이언 인형이 K개 미만이라 -1을 출력하고 리턴
        if (list.size() < k) {
            System.out.println(-1);
            return;
        }

        // 슬라이딩 윈도우 수행
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= list.size() - k; i++) {
            min = Math.min(min, list.get(i + k - 1) - list.get(i) + 1);
        }

        System.out.println(min);
    }
}
