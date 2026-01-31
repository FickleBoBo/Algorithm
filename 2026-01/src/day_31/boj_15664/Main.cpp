#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[8];
int sel[8];

void dfs(int idx, int selIdx) {
    if (selIdx == m) {
        for (int i = 0; i < m; i++) {
            cout << sel[i] << ' ';
        }
        cout << '\n';
        return;
    }

    int prev = 0;
    for (int i = idx; i < n; i++) {
        if (arr[i] == prev) continue;

        prev = sel[selIdx] = arr[i];
        dfs(i + 1, selIdx + 1);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);

    dfs(0, 0);
}
