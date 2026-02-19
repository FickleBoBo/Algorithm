#include <bits/stdc++.h>
using namespace std;

int n, m, mx;
int days[20];
int pages[20];

void dfs(int idx, int dsum, int psum) {
    if (dsum > n) return;  // 읽는데 소요된 일수의 합이 n보다 크면 불가능한 경우

    if (idx == m) {
        mx = max(mx, psum);
        return;
    }

    dfs(idx + 1, dsum + days[idx], psum + pages[idx]);  // 현재 챕터를 읽는 경우
    dfs(idx + 1, dsum, psum);                           // 현재 챕터를 안 읽는 경우
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        cin >> days[i] >> pages[i];
    }

    dfs(0, 0, 0);

    cout << mx;
}
