#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int mn_x = 10000;
    int mn_y = 10000;
    int mx_x = -10000;
    int mx_y = -10000;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;

        mn_x = min(mn_x, x);
        mn_y = min(mn_y, y);
        mx_x = max(mx_x, x);
        mx_y = max(mx_y, y);
    }

    cout << (mx_x - mn_x) * (mx_y - mn_y);
}
