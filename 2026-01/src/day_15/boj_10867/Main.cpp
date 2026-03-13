#include <bits/stdc++.h>
using namespace std;

const int MX = 1000;
bool vis[MX + 1 + MX];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;
        vis[MX + x] = true;
    }

    for (int i = 0; i < sizeof(vis); i++) {
        if (vis[i]) {
            cout << i - MX << ' ';
        }
    }
}
