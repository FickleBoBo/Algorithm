#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[8];
int sel[8];
bool visited[8];

void dfs(int selIdx) {
    if (selIdx == m) {
        for (int i = 0; i < m; i++) {
            cout << sel[i] << ' ';
        }
        cout << '\n';
        return;
    }

    int prev = 0;
    for (int i = 0; i < n; i++) {
        if (visited[i]) continue;
        if (arr[i] == prev) continue;

        prev = sel[selIdx] = arr[i];
        visited[i] = true;
        dfs(selIdx + 1);
        visited[i] = false;
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
