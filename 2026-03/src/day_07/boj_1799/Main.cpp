#include <bits/stdc++.h>
using namespace std;

const int MAX = 10;
int n;
vector<pair<int, int>> poslist[MAX * 2];
bool d[MAX * 2];  // 좌상에서 우하 방향 대각선
int cnt;

void solve(int idx, int depth) {
    if (idx >= 2 * n - 1) {
        cnt = max(cnt, depth);
        return;
    }

    bool flag = false;
    for (auto [r, c] : poslist[idx]) {
        if (d[r - c + n - 1]) continue;

        d[r - c + n - 1] = true;
        solve(idx + 2, depth + 1);
        d[r - c + n - 1] = false;
        flag = true;
    }

    if (!flag) {
        solve(idx + 2, depth);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int x;
            cin >> x;
            if (x == 1) poslist[i + j].push_back({i, j});
        }
    }

    int ans = 0;

    cnt = 0;
    solve(0, 0);  // 하얀색 칸에 대한 비숍 배치
    ans += cnt;

    cnt = 0;
    solve(1, 0);  // 검은색 칸에 대한 비숍 배치
    ans += cnt;

    cout << ans;
}
