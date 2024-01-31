package day_31.SWEA_D4_5432;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {	
	
    static Stack<Integer> st = new Stack<Integer>();
    static Stack<Integer> laser = new Stack<Integer>();
	
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for(int tc=1 ; tc<=T ; tc++){

            char[] input = bf.readLine().toCharArray();
            
            int[] pipe = new int[input.length];
            int cnt = 0;

            for(int i=0 ; i<input.length ; i++){
                if(input[i]=='('){
                    st.push(i);
                } else{
                    if((i-st.peek())==1){
                    	laser.push(st.pop());
                    } else{
                        for(int j=st.pop() ; j<=i ; j++){
                            pipe[j]++;
                        }
                        cnt++;
                    }
                }
            }
            
            while(!(laser.isEmpty())) {
            	cnt += pipe[laser.pop()];
            }
            
            System.out.printf("#%d %d\n", tc, cnt);
        }
        bf.close();
    }
}