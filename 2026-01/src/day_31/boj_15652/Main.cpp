#include <bits/stdc++.h>
using namespace std;

int n, m;
int sel[8];

void dfs(int idx, int selIdx) {
    if (selIdx == m) {
        for (int i = 0; i < m; i++) {
            cout << sel[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = idx; i <= n; i++) {
        sel[selIdx] = i;
        dfs(i, selIdx + 1);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    dfs(1, 0);
}
