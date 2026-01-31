#include <bits/stdc++.h>
using namespace std;

int n, m;
int sel[7];

void dfs(int selIdx) {
    if (selIdx == m) {
        for (int i = 0; i < m; i++) {
            cout << sel[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = 1; i <= n; i++) {
        sel[selIdx] = i;
        dfs(selIdx + 1);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;

    dfs(0);
}
