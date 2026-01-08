#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int r, e, c;
        cin >> r >> e >> c;

        if (r > e - c) {
            cout << "do not advertise\n";
        } else if (r < e - c) {
            cout << "advertise\n";
        } else {
            cout << "does not matter\n";
        }
    }
}
