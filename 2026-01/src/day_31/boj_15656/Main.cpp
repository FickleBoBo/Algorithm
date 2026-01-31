#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[7];
int sel[7];

void dfs(int selIdx) {
    if (selIdx == m) {
        for (int i = 0; i < m; i++) {
            cout << sel[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = 0; i < n; i++) {
        sel[selIdx] = arr[i];
        dfs(selIdx + 1);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);

    dfs(0);
}
