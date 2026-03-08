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

    for (int i = idx; i < n; i++) {
        sel[sidx] = arr[i];
        dfs(i + 1, sidx + 1);
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
