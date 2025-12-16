#include <bits/stdc++.h>
using namespace std;

constexpr int LOG = 20;
constexpr int MAXN = 100000;

int a[MAXN];
int st[LOG][MAXN];
int lg[1 + MAXN];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> a[i];

    for (int i = 2; i <= n; i++) {
        lg[i] = lg[i / 2] + 1;
    }

    for (int i = 0; i < n; i++) {
        st[0][i] = a[i];
    }

    for (int k = 1; k < LOG; k++) {
        for (int i = 0; i + (1 << k) <= n; i++) {
            st[k][i] = min(st[k - 1][i], st[k - 1][i + (1 << (k - 1))]);
        }
    }

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        a--;
        b--;

        int k = lg[b - a + 1];
        cout << min(st[k][a], st[k][b - (1 << k) + 1]) << '\n';
    }
}
