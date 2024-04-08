package day_08.BOJ_G5_13549;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(BFS(N, K));
		
		sc.close();
	}

	private static int BFS(int n, int k) {
		Deque<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[100_001];
		q.offer(n);
		visited[n] = true;
		int ans = 0;
		
		while(true) {
			int len = q.size();
			for(int i=0 ; i<len ; i++) {
				int pos = q.poll();
				
				if(pos==k) return ans;
				
				if(pos*2<=100_000 && !visited[pos*2]) {
					q.addFirst(pos*2);
					visited[pos*2] = true;
					i--;
				}
				if(pos-1>=0 && !visited[pos-1]) {
					q.offer(pos-1);
					visited[pos-1] = true;
				}
				if(pos+1<=100_000 && !visited[pos+1]) {
					q.offer(pos+1);
					visited[pos+1] = true;
				}

			}
			ans++;
		}
		
		
	}
}
