package day_04.BOJ_3009;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Integer> xpos = new ArrayList<>();
        List<Integer> ypos = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        xpos.add(Integer.parseInt(st.nextToken()));
        ypos.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        xpos.add(Integer.parseInt(st.nextToken()));
        ypos.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        xpos.add(Integer.parseInt(st.nextToken()));
        ypos.add(Integer.parseInt(st.nextToken()));

        xpos.sort(Comparator.naturalOrder());
        ypos.sort(Comparator.naturalOrder());

        int x4 = Objects.equals(xpos.get(1), xpos.get(0)) ? xpos.get(2) : xpos.get(0);
        int y4 = Objects.equals(ypos.get(1), ypos.get(0)) ? ypos.get(2) : ypos.get(0);

        sb.append(x4).append(" ").append(y4);

        bw.write(sb.toString());
        bw.flush();
    }
}
