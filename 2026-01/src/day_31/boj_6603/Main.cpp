#include <bits/stdc++.h>
using namespace std;

int k;
int arr[13];
int sel[6];

void dfs(int idx, int selIdx) {
    if (selIdx == 6) {
        for (int x : sel) {
            cout << x << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = idx; i < k; i++) {
        sel[selIdx] = arr[i];
        dfs(i + 1, selIdx + 1);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while (true) {
        cin >> k;
        if (k == 0) break;

        for (int i = 0; i < k; i++) cin >> arr[i];

        dfs(0, 0);
        cout << '\n';
    }
}
