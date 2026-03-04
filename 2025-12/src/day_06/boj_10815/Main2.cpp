#include <bits/stdc++.h>
using namespace std;

const int MAX = 10000000;
bool visited[20000001];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

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
