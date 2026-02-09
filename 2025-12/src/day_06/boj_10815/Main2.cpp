#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 10000000;
bool visited[20000001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

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
        cout << visited[x + MAX] << ' ';
    }
}
