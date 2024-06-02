package day_01.BOJ_P5_14003;

import java.io.*;
import java.util.StringTokenizer;

public class Main_fin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0 ; i<N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 앞에 1은 패딩으로 인덱스 1부터 실제 값이 저장됨
        int[] dp = new int[1+N];
        int maxLen = 0;
        dp[0] = Integer.MIN_VALUE;    // 수열의 첫 원소가 음수일 수 있으므로 이분 탐색 조건에 맞춰 초기화
        int[] result = new int[N];    // dp 배열에 들어갈 때 인덱스를 저장할 배열

        for(int i=0 ; i<N ; i++){
            int idx = binarySearch(dp, 0, maxLen, A[i]);

            if(idx > maxLen){
                dp[++maxLen] = A[i];
            }
            else{
                dp[idx] = A[i];
            }

            result[i] = idx;
        }

        // 실제 LIS를 저장할 배열로 result 배열을 역순으로 돌며 찾아나감
        int[] lis = new int[maxLen];
        int idx = maxLen - 1;
        for(int i=N-1 ; i>=0 ; i--){
            if(result[i] == maxLen){
                lis[idx] = A[i];
                maxLen--;
                idx--;
            }
        }

        bw.write(lis.length + "\n");
        for(int i=0 ; i<lis.length ; i++){
            bw.write(lis[i] + " ");
        }
        bw.flush();
        bw.close();
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
