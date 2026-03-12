#include <bits/stdc++.h>
using namespace std;

const int MX = 1000;
int g[1 + MX];
bool vis[16];  // 전처리로 미리 크기 계산

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 2; i <= n; i++) {
        memset(vis, 0, sizeof(vis));

        for (int j = 0; j <= (i - 1) / 2; j++) {
            vis[g[j] ^ g[i - 2 - j]] = true;
        }

        int mex = 0;
        while (vis[mex]) mex++;
        g[i] = mex;
    }

    if (g[n]) {
        cout << 1;
    } else {
        cout << 2;
    }
}
