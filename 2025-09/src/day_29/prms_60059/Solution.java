package day_29.prms_60059;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        // 회전을 고려한 4종류의 열쇠를 담아둔 3차원 배열
        int[][][] keys = initKeys(key);

        // 열쇠와 자물쇠의 크기를 고려해 열쇠의 0행 0열을 넣을 곳을 탐색
        for (int i = -key.length + 1; i < lock.length; i++) {
            for (int j = -key.length + 1; j < lock.length; j++) {

                // 회전을 고려한 열쇠들에 대해 탐색
                for (int k = 0; k < 4; k++) {

                    // 한번이라도 열 수 있으면 true 리턴
                    if (isFit(keys[k], lock, i, j)) return true;
                }
            }
        }

        return false;
    }

    // 0도, 90도, 180도, 270도 회전한 열쇠를 순서대로 저장
    private static int[][][] initKeys(int[][] key) {
        int[][][] keys = new int[4][key.length][key.length];

        keys[0] = key;
        keys[1] = rotate(keys[0]);
        keys[2] = rotate(keys[1]);
        keys[3] = rotate(keys[2]);

        return keys;
    }

    // 90도 회전한 열쇠를 반환하는 메서드
    private static int[][] rotate(int[][] arr) {
        int len = arr.length;
        int[][] result = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[i][j] = arr[len - 1 - j][i];
            }
        }

        return result;
    }

    // 자물쇠의 모든 영역에서 맞물리면 true 반환
    private static boolean isFit(int[][] key, int[][] lock, int r, int c) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                int keyValue = 0;

                // r, c는 자물쇠를 기준으로 열쇠를 넣을 인덱스인데 열쇠의 실제 인덱스로는 i - r, j - c가 되며 이 인덱스가 열쇠 범위 안이면 열쇠의 값 사용
                if (0 <= i - r && i - r < key.length && 0 <= j - c && j - c < key.length) {
                    keyValue = key[i - r][j - c];
                }

                if (lock[i][j] + keyValue != 1) return false;
            }
        }

        return true;
    }
}
