package day_08.BOJ_G4_4803;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] p;
	static int[] edgeCnt;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			if(n==0 && m==0) break;
			
			p = new int[1+n];
			for(int i=1 ; i<=n ; i++) {
				p[i] = i;
			}
			edgeCnt = new int[1+n];
			visited = new boolean[1+n][1+n];
			
			for(int i=0 ; i<m ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if(x==y) continue;
				if(!visited[x][y]) {
					visited[x][y] = visited[y][x] = true;
					union(find(x), find(y));
				}
			}
			
			int[] countingArr = new int[1+n];
			for(int i=1 ; i<=n ; i++) {
				countingArr[find(p[i])]++;
			}
			
			for(int i=1 ; i<=n ; i++) {
				p[i] = find(p[i]);
				if(countingArr[i]==0 && edgeCnt[i]!=0) {
					edgeCnt[p[i]] += edgeCnt[i];
					edgeCnt[i] = 0;
				}
			}
			
//			System.out.println(Arrays.toString(p));
//			System.out.println(Arrays.toString(edgeCnt));
//			System.out.println(Arrays.toString(countingArr));
			
			int ans = 0;
			for(int i=1 ; i<=n ; i++) {
				if(p[i]==i && edgeCnt[i]==countingArr[i]-1) {
					ans++;
				}
			}
			
			if(ans > 1) System.out.printf("Case %d: A forest of %d trees.\n", tc++, ans);
			else if(ans == 1) System.out.printf("Case %d: There is one tree.\n", tc++);
			else System.out.printf("Case %d: No trees.\n", tc++);
			
		}
		sc.close();
	}

	private static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	
	private static void union(int x, int y) {
		p[y] = x;
		edgeCnt[x]++;
	}
	
}
