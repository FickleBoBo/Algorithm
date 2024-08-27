package day_25.BOJ_G4_9935;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        String str = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : input){
            if(c == str.charAt(str.length()-1)){
                stack.push(c);

                boolean flag = true;

                if(deque.size() < str.length() - 1){
                    flag = false;
                }
                else{
                    for(int i=str.length()-2 ; i>=0 ; i--){
                        if(deque.peekLast() == str.charAt(i)){
                            stack.push(deque.pollLast());
                        }
                        else{
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag){
                    stack.clear();
                }
                else{
                    while(!stack.isEmpty()){
                        deque.addLast(stack.pop());
                    }
                }
            }
            else{
                deque.addLast(c);
            }
        }

        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }

        if(sb.toString().isEmpty()){
            bw.write("FRULA");
        }
        else{
            bw.write(sb.toString());
        }
        bw.flush();
    }
}
