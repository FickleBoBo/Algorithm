package day_29.SWEA_모의SW역량테스트_등산로조성;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static int[][] tmpMap;
	static int N;
	static int K;
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			ans = 0;
			
//			findPath();
			
			findPath(K);
			
			System.out.printf("#%d %d\n", tc, ans);
			
		}
		sc.close();
	}
	
	static void copyMap(){
		tmpMap = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			tmpMap[i] = Arrays.copyOf(map[i], N);
		}
	}
	
	static Stack<int[]> findPeaks() {
		int tmpPeak = Integer.MIN_VALUE;
		Stack<int[]> st = new Stack<int[]>();
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(map[i][j] > tmpPeak) {
					st.clear();
					tmpPeak = map[i][j];
					st.push(new int[] {i, j});
				}
				else if(map[i][j] == tmpPeak) {
					st.push(new int[] {i, j});
				}
			}
		}
		return st;
	}
	
	static Stack<int[]> findPeaks(int row, int col) {
		copyMap();
		tmpMap[row][col] -= K;
		
		int tmpPeak = Integer.MIN_VALUE;
		Stack<int[]> st = new Stack<int[]>();
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(tmpMap[i][j] > tmpPeak) {
					st.clear();
					tmpPeak = tmpMap[i][j];
					st.push(new int[] {i, j});
				}
				else if(tmpMap[i][j] == tmpPeak) {
					st.push(new int[] {i, j});
				}
			}
		}
		return st;
	}

	static void findPath() {
		Stack<int[]> st = findPeaks();
		
		while(!st.isEmpty()) {
			int startRow = st.peek()[0];
			int startCol = st.peek()[1];
			st.pop();
			
			pathFinding1(startRow, startCol, 1);
		}
	}
	
	static void findPath(int K) {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				Stack<int[]> st = findPeaks(i, j);
//				System.out.println("----------스택 크기: " + st.size());
				
				while(!st.isEmpty()) {
					int startRow = st.peek()[0];
					int startCol = st.peek()[1];
					st.pop();
					
//					System.out.println("----------좌표: " + i + " " + j);
					pathFinding2(startRow, startCol, 1);
				}
			}
		}
	}
	
	static void pathFinding1(int r, int c, int len) {
		for(int dir=0 ; dir<4 ; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if((nr>=0) && (nc>=0) && (nr<N) && (nc<N) && 
					(map[nr][nc] < map[r][c])) {
//				System.out.println("길찾는중: " + nr + " " + nc + " 길이: " + (len+1));
				pathFinding1(nr, nc, len+1);
//				System.out.println("컷");
			}
		}
		if(len > ans) {
			ans = len;
		}
	}
	
	static void pathFinding2(int r, int c, int len) {
		for(int dir=0 ; dir<4 ; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if((nr>=0) && (nc>=0) && (nr<N) && (nc<N) && 
					(tmpMap[nr][nc] < tmpMap[r][c])) {
//				System.out.println("길찾는중: " + nr + " " + nc + " 길이: " + (len+1));
				pathFinding2(nr, nc, len+1);
			}
//			System.out.println("컷");
		}
		if(len > ans) {
			ans = len;
		}
	}
	
	static void printMap(int[][] arr) {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
