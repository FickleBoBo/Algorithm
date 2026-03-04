#include <bits/stdc++.h>
using namespace std;

int cnt[10002][3];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 2; i < 2 + n; i++) {
        int x;
        cin >> x;

        if (x >= cnt[i - 1][0]) {
            cnt[i][1] = cnt[i - 1][0];
            x -= cnt[i - 1][0];
        } else {
            cnt[i][1] = x;
            continue;
        }

        if (x >= cnt[i - 1][1]) {
            cnt[i][2] = cnt[i - 1][1];
            x -= cnt[i - 1][1];
        } else {
            cnt[i][2] = x;
            continue;
        }

        cnt[i][0] = x;
    }

    int sum = 0;
    for (int i = 2; i < 2 + n; i++) {
        sum += 3 * cnt[i][0] + 2 * (cnt[i][1] + cnt[i][2]);
    }

    cout << sum;
}
