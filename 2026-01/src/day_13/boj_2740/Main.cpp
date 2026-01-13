#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, k;
    cin >> n >> m;

    vector<vector<int>> a(n, vector<int>(m));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

    cin >> m >> k;
    vector<vector<int>> b(m, vector<int>(k));
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < k; j++) {
            cin >> b[i][j];
        }
    }

    vector<vector<int>> res(n, vector<int>(k));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < k; j++) {
            for (int t = 0; t < m; t++) {
                res[i][j] += a[i][t] * b[t][j];
            }
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < k; j++) {
            cout << res[i][j] << ' ';
        }
        cout << '\n';
    }
}
