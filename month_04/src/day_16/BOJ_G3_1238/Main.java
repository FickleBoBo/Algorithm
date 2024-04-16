package day_16.BOJ_G3_1238;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Edge implements Comparable<Edge>{
		int st, ed, w;

		public Edge(int st, int ed, int w) {this.st = st; this.ed = ed; this.w = w;}

		@Override
		public int compareTo(Edge o) {return Integer.compare(this.w, o.w);}
	}

	static int N;
	static List<Edge>[] edges;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		
		edges = new ArrayList[1+N];
		for(int i=1 ; i<=N ; i++) {
			edges[i] = new ArrayList<Edge>();
		}
		for(int i=0 ; i<M ; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			edges[st].add(new Edge(st, ed, w));
		}
		
		int ans = 0;
		int[] XToHome = Dijkstra(X);
		for(int i=1 ; i<=N ; i++) {
			ans = Math.max(ans, Dijkstra(i)[X] + XToHome[i]);
		}
		
		System.out.println(ans);
		
		sc.close();
	}

	private static int[] Dijkstra(int start) {
		boolean[] visited = new boolean[1+N];
		
		int[] dist = new int[1+N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(Edge e : edges[start]) {
			dist[e.ed] = dist[e.st] + e.w;
			pq.add(e);
		}
		
		while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            visited[curr.st] = true;
	            
            for (Edge e : edges[curr.ed]) {
	                
                if(visited[e.ed]) continue;
	            
                if(dist[e.ed] > dist[e.st] + e.w) {
                    dist[e.ed] = dist[e.st] + e.w;
                    pq.add(new Edge(e.st, e.ed, dist[e.ed]));
                }
            }
        }
		
		return dist;
		
	}
	
}
