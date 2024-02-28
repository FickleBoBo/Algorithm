package day_28.SWEA_D3_4615;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static Stack<int[]> st = new Stack<int[]>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			map[N/2-1][N/2-1] = 2;
			map[N/2-1][N/2] = 1;
			map[N/2][N/2-1] = 1;
			map[N/2][N/2] = 2;
			
			for(int i=0 ; i<M ; i++) {
				
				int xpos = sc.nextInt()-1;
				int ypos = sc.nextInt()-1;
				int player = sc.nextInt();
				
				map = setMap(map, xpos, ypos, player);
				
//				printMap(map, xpos, ypos);
			}
			
			int[] stones = countStones(map);
			System.out.printf("#%d %d %d\n", tc, stones[0], stones[1]);
			
		}
		sc.close();
	}
	
	static int[][] copyMap(int[][] arr){
		int N = arr.length;
		int[][] tmp = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			tmp[i] = Arrays.copyOf(arr[i], N);
		}
		return tmp;
	}
	
	static int[][] setMap(int[][]arr, int col, int row, int player){
		int N = arr.length;
		int[][] tmp = copyMap(arr);
		tmp[row][col] = player;
		int otherPlayer = player==1 ? 2 : 1;
		
		for(int dir=0 ; dir<8 ; dir++) {
			int nrow = row + dr[dir];
			int ncol = col + dc[dir];
			while((nrow >= 0) && (ncol >= 0) && (nrow < N) && (ncol < N) 
					&& (tmp[nrow][ncol] == otherPlayer)) {
				st.push(new int[] {nrow, ncol});
				nrow += dr[dir];
				ncol += dc[dir];
			}
			if((nrow >= 0) && (ncol >= 0) && (nrow < N) && (ncol < N) 
					&& tmp[nrow][ncol] == player) {
				while(!st.isEmpty()) {
					int[] turn = st.pop();
					tmp[turn[0]][turn[1]] = player;
				}
			}
			else {
				st.clear();
			}
		}
		return tmp;
	}
	
	static int[] countStones(int[][] arr) {
		int N = arr.length;
		int black = 0;
		int white = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(arr[i][j] == 1) black++;
				else if(arr[i][j] == 2) white++;
			}
		}
		return new int[] {black, white};
	}
	
	static void printMap(int[][] arr, int col, int row) {
		int N = arr.length;
		System.out.println("row : " + row + " col : " + col);
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
