#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000;
bool vis[MAX + 1 + MAX];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;
        vis[MAX + x] = true;
    }

    for (int i = 0; i < sizeof(vis); i++) {
        if (vis[i]) {
            cout << i - MAX << ' ';
        }
    }
}
