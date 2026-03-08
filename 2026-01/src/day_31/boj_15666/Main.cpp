#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[8];
int sel[8];

void dfs(int idx, int sidx) {
    if (sidx == m) {
        for (int i = 0; i < m; i++) {
            cout << sel[i] << ' ';
        }
        cout << '\n';
        return;
    }

    int prv = 0;
    for (int i = idx; i < n; i++) {
        if (arr[i] == prv) continue;

        prv = sel[sidx] = arr[i];
        dfs(i, sidx + 1);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);

    dfs(0, 0);
}
