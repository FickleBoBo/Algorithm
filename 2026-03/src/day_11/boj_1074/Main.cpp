#include <bits/stdc++.h>
using namespace std;

int dfs(int n, int r, int c) {
    if (n == 0) return 0;

    int len = 1 << (n - 1);
    int area = len * len;

    if (r < len) {
        if (c < len) {
            return dfs(n - 1, r, c);
        } else {
            return area + dfs(n - 1, r, c - len);
        }
    } else {
        if (c < len) {
            return area * 2 + dfs(n - 1, r - len, c);
        } else {
            return area * 3 + dfs(n - 1, r - len, c - len);
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, r, c;
    cin >> n >> r >> c;
    cout << dfs(n, r, c);
}
