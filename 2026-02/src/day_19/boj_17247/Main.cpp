#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    vector<pair<int, int>> pos;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            int x;
            cin >> x;
            if (x == 1) pos.push_back({i, j});
        }
    }

    cout << abs(pos[0].first - pos[1].first) + abs(pos[0].second - pos[1].second);
}
