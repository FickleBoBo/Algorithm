#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<bool> vis(42);
    for (int i = 0; i < 10; i++) {
        int x;
        cin >> x;
        vis[x % 42] = true;
    }

    cout << count(vis.begin(), vis.end(), true);
}
