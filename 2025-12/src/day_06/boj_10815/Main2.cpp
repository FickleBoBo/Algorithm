#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 10000000;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<bool> visited(MAX + 1 + MAX);
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;

        visited[x + MAX] = true;
    }

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int x;
        cin >> x;

        if (visited[x + MAX]) {
            cout << "1 ";
        } else {
            cout << "0 ";
        }
    }
}
