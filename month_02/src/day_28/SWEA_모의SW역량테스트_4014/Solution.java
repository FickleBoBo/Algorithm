package day_28.SWEA_모의SW역량테스트_4014;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int ans = 2 * N;
			
			int[][] map = new int[N][N];
			int len = X+N+X;
			int[][] putRampRow = new int[len][len];
			int[][] putRampCol = new int[len][len];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			
			
			for(int row=0 ; row<N ; row++) {
				for(int col=0 ; col<N-1 ; col++) {
					if(map[row][col] > map[row][col+1]) {
						for(int i=1 ; i<=X ; i++) {
							putRampRow[X+row][X+col+i] += map[row][col] - map[row][col+1];
						}
					}
					else if(map[row][col] < map[row][col+1]) {
						for(int i=0 ; i<X ; i++) {
							putRampRow[X+row][X+col-i] += map[row][col+1] - map[row][col];
						}
					}
				}
			}

			
			
			for(int row=0 ; row<N ; row++) {
				for(int col=0 ; col<N-1 ; col++) {
					if(map[col][row] > map[col+1][row]) {
						for(int i=1 ; i<=X ; i++) {
							putRampCol[X+col+i][X+row] += map[col][row] - map[col+1][row];
						}
					}
					else if(map[col][row] < map[col+1][row]) {
						for(int i=0 ; i<X ; i++) {
							putRampCol[X+col-i][X+row] += map[col+1][row] - map[col][row];
						}
					}
				}
			}
			
			for(int i=0 ; i<len ; i++) {
				for(int j=0 ; j<len ; j++) {
					if((putRampRow[i][X-1] > 0) || (putRampRow[i][N+X] > 0)) {
						ans--;
						break;
					}
					if(putRampRow[i][j] > 1) {
						ans--;
						break;
					}
				}
			}

			for(int i=0 ; i<len ; i++) {
				for(int j=0 ; j<len ; j++) {
					if((putRampCol[X-1][i] > 0) || (putRampCol[N+X][i] > 0)) {
						ans--;
						break;
					}
					if(putRampCol[j][i] > 1) {
						ans--;
						break;
					}
				}
			}
			
//			for(int i=0 ; i<len ; i++) {
//				for(int j=0 ; j<len ; j++) {
//					System.out.print(putRampRow[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			
//			for(int i=0 ; i<len ; i++) {
//				for(int j=0 ; j<len ; j++) {
//					System.out.print(putRampCol[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
			
			
			System.out.printf("#%d %d\n", tc, ans);
			
		}
		sc.close();
	}
}
