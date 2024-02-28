package day_28.SWEA_모의SW역량테스트_4013;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int K = Integer.parseInt(sc.nextLine());
			
			String[][] magnet = {
					sc.nextLine().split(" "), 
					sc.nextLine().split(" "), 
					sc.nextLine().split(" "), 
					sc.nextLine().split(" ")
			};
			
			int[][] magnetIdx = {
					{0, 6, 2}, 
					{0, 6, 2}, 
					{0, 6, 2}, 
					{0, 6, 2}
			};
			
			
			for(int n=0 ; n<K ; n++) {
				String[] input = sc.nextLine().split(" ");
				int choice = Integer.parseInt(input[0])-1;
				int[] turnDirection;
				if(((choice%2==1) && (Integer.parseInt(input[1]) == 1)) || 
						(choice%2==0) && (Integer.parseInt(input[1]) == -1)) {
					turnDirection = new int[]{1, -1, 1, -1};
				}
				else {
					turnDirection = new int[]{-1, 1, -1, 1};
				}
				boolean[] turnMagnet = checkMagnetConnetion(choice, magnet, magnetIdx);
				
				for(int i=0 ; i<4 ; i++) {
					if(turnMagnet[i]) {
						magnetIdx = turnMagnet(turnDirection[i], i, magnetIdx);
					}
				}
			}
			
			
			
			int ans = 0;
			if(magnet[0][magnetIdx[0][0]].equals("1")) ans = ans + 1;
			if(magnet[1][magnetIdx[1][0]].equals("1")) ans = ans + 2;
			if(magnet[2][magnetIdx[2][0]].equals("1")) ans = ans + 4;
			if(magnet[3][magnetIdx[3][0]].equals("1")) ans = ans + 8;
			System.out.printf("#%d %d\n", tc, ans);
			
			
			
//			for(int i=0 ; i<4 ; i++) {
//				for(int j=0 ; j<3 ; j++) {
//					System.out.print(magnetIdx[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
			
		}
		sc.close();
	}
	
	static int[][] turnMagnet(int dir, int magNum , int[][] magIdx) {
		magIdx[magNum][0] = (magIdx[magNum][0] + 8 + dir) % 8;
		magIdx[magNum][1] = (magIdx[magNum][1] + 8 + dir) % 8;
		magIdx[magNum][2] = (magIdx[magNum][2] + 8 + dir) % 8;
		return magIdx;
	}
	
	static boolean[] checkMagnetConnetion(int choice, String[][] mag, int[][] magIdx) {
		
		boolean[] tmp = new boolean[4];
		tmp[choice] = true;
		
		for(int i=choice ; i<mag.length-1 ; i++) {
			if(!(mag[i][magIdx[i][2]].equals(mag[i+1][magIdx[i+1][1]]))) {
				tmp[i+1] = true;
			}
			else {
				break;
			}
		}
		
		for(int i=choice ; i>0 ; i--) {
			if(!(mag[i][magIdx[i][1]].equals(mag[i-1][magIdx[i-1][2]]))) {
				tmp[i-1] = true;
			}
			else {
				break;
			}
		}
		return tmp;
	}
	
}
