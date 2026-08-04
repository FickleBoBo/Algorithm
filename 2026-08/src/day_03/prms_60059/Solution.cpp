#include <bits/stdc++.h>
using namespace std;

int n, m;

vector<vector<int>> rotate(vector<vector<int>>& key) {
    vector<vector<int>> res(m, vector<int>(m));
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
            res[i][j] = key[m - 1 - j][i];
        }
    }

    return res;
}

void attach(vector<vector<int>>& lock, vector<vector<int>>& key, int sr, int sc) {
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
            if (sr + i < 0 || sr + i >= n || sc + j < 0 || sc + j >= n) continue;
            lock[sr + i][sc + j] += key[i][j];
        }
    }
}

void detach(vector<vector<int>>& lock, vector<vector<int>>& key, int sr, int sc) {
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
            if (sr + i < 0 || sr + i >= n || sc + j < 0 || sc + j >= n) continue;
            lock[sr + i][sc + j] -= key[i][j];
        }
    }
}

bool match(vector<vector<int>>& lock) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (lock[i][j] != 1) return false;
        }
    }

    return true;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    n = lock.size();
    m = key.size();

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
