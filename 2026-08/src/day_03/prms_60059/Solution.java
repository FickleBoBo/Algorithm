package day_03.prms_60059;

class Solution {

    static int n, m;

    public boolean solution(int[][] key, int[][] lock) {
        n = lock.length;
        m = key.length;

        for (int d = 0; d < 4; d++) {
            for (int i = -m + 1; i < n; i++) {
                for (int j = -m + 1; j < n; j++) {
                    attach(lock, key, i, j);
                    if (match(lock)) return true;
                    detach(lock, key, i, j);
                }
            }

            key = rotate(key);
        }

        return false;
    }

    static int[][] rotate(int[][] key) {
        int[][] res = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = key[m - 1 - j][i];
            }
        }

        return res;
    }

    static void attach(int[][] lock, int[][] key, int sr, int sc) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (sr + i < 0 || sr + i >= n || sc + j < 0 || sc + j >= n) continue;
                lock[sr + i][sc + j] += key[i][j];
            }
        }
    }

    static void detach(int[][] lock, int[][] key, int sr, int sc) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (sr + i < 0 || sr + i >= n || sc + j < 0 || sc + j >= n) continue;
                lock[sr + i][sc + j] -= key[i][j];
            }
        }
    }

    static boolean match(int[][] lock) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lock[i][j] != 1) return false;
            }
        }

        return true;
    }
}
