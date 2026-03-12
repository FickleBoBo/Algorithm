#include <bits/stdc++.h>
using namespace std;

const int MX = 3000000;
int fibo[32];  // 전처리로 미리 크기 계산
int g[1 + MX];
bool vis[16];  // 전처리로 미리 크기 계산

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    fibo[0] = fibo[1] = 1;
    for (int i = 2; i < 32; i++) {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
    }

    for (int i = 1; i <= MX; i++) {
        memset(vis, 0, sizeof(vis));

        for (int x : fibo) {
            if (i >= x) vis[g[i - x]] = true;
        }

        int mex = 0;
        while (vis[mex]) mex++;
        g[i] = mex;
    }

    int nimsum = 0;

    int n;
    cin >> n;

    while (n--) {
        int p;
        cin >> p;
        nimsum ^= g[p];
    }

    if (nimsum) {
        cout << "koosaga";
    } else {
        cout << "cubelover";
    }
}
