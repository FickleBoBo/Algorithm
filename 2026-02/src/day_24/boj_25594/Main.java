package day_24.boj_25594;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Character, String> map = new HashMap<>();

        map.put('a', "aespa");
        map.put('b', "baekjoon");
        map.put('c', "cau");
        map.put('d', "debug");
        map.put('e', "edge");
        map.put('f', "firefox");
        map.put('g', "golang");
        map.put('h', "haegang");
        map.put('i', "iu");
        map.put('j', "java");
        map.put('k', "kotlin");
        map.put('l', "lol");
        map.put('m', "mips");
        map.put('n', "null");
        map.put('o', "os");
        map.put('p', "python");
        map.put('q', "query");
        map.put('r', "roka");
        map.put('s', "solvedac");
        map.put('t', "tod");
        map.put('u', "unix");
        map.put('v', "virus");
        map.put('w', "whale");
        map.put('x', "xcode");
        map.put('y', "yahoo");
        map.put('z', "zebra");

        String str = br.readLine();
        boolean flag = true;

        for (int i = 0; i < str.length(); i++) {
            String code = map.get(str.charAt(i));

            if (str.startsWith(code, i)) {
                sb.append(str.charAt(i));
                i += code.length() - 1;
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("It's HG!");
            System.out.println(sb);
        } else {
            System.out.println("ERROR!");
        }
    }
}
