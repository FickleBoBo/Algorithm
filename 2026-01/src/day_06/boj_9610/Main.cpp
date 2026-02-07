#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<int> cnt(5);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;

        if (x == 0 || y == 0) {
            cnt[0]++;
            continue;
        }

        if (x > 0) {
            if (y > 0) {
                cnt[1]++;
            } else {
                cnt[4]++;
            }
        } else {
            if (y > 0) {
                cnt[2]++;
            } else {
                cnt[3]++;
            }
        }
    }

    cout << "Q1: " << cnt[1] << '\n';
    cout << "Q2: " << cnt[2] << '\n';
    cout << "Q3: " << cnt[3] << '\n';
    cout << "Q4: " << cnt[4] << '\n';
    cout << "AXIS: " << cnt[0] << '\n';
}
