package day_01.BOJ_G3_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1 ; tc<=T ; tc++) {
			char[] input = br.readLine().toCharArray();
			int N = Character.getNumericValue(input[0]);
			int K = Character.getNumericValue(input[1]);
			
			for(int i=0 ; i<K ; i++) {
				sb.append(br.readLine() + " ");
			}
			st = new StringTokenizer(sb.toString(), " ");
			
			int[][] adj = new int[N+1][N+1];
			int[] inDegree = new int[N+1];
			
			while(st.hasMoreTokens()) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				adj[A][B]++;
				inDegree[B]++;
			}
			
			
		}
		
		br.close();
	}
}
