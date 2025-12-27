package day_12.prms_42747;

import java.util.*;

class Solution2 {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = citations[citations.length - 1]; i >= 0; i--) {
            int cnt = citations.length - lowerBound(citations, i);
            if (cnt >= i) return i;
        }

        return -1;
    }

    static int lowerBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
