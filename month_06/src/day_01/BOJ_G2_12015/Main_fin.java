package day_01.BOJ_G2_12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_fin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0 ; i<N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 앞에 1은 패딩으로 인덱스 1부터 실제 값이 저장됨
        int[] dp = new int[1+N];
        int maxLen = 0;

        for(int i=0 ; i<N ; i++){
            int idx = binarySearch(dp, 0, maxLen, A[i]);

            if(idx > maxLen){
                dp[++maxLen] = A[i];
            }
            else{
                dp[idx] = A[i];
            }
        }

        System.out.println(maxLen);
    }

    private static int binarySearch(int[] arr, int left, int right, int value){
        // dp 배열의 최댓값보다 value가 클 경우 바로 뒤에 붙이면 된다
        if(value > arr[right]) return right + 1;

        int mid = (left + right) / 2;

        // 찾는 위치는 dp 배열에서 value보다 크거나 같은 원소의 인덱스 중 최솟값
        while(left < right){
            if(value > arr[mid]){
                left = mid + 1;
            }
            else if(value < arr[mid]){
                right = mid;
            }
            else{
                break;
            }
            mid = (left + right) / 2;
        }

        return mid;
    }

}
