package day_18.boj_7785;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Set<String> set = new TreeSet<>(Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String type = st.nextToken();

            if (type.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        for (String name : set) {
            bw.write(name);
            bw.newLine();
        }

        bw.flush();
    }
}
