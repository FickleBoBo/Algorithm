#include <bits/stdc++.h>
using namespace std;

long long arr[1000002];
long long cnt[1000002][3];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, b, c;
    cin >> n >> b >> c;

    for (int i = 2; i < 2 + n; i++) {
        cin >> arr[i];
    }

    if (b <= c) {
        long long cnt = 0;

        for (int i = 2; i < 2 + n; i++) {
            cnt += arr[i];
        }

        cout << cnt * b;
    } else {
        for (int i = 2; i < 2 + n; i++) {
            long long x = arr[i];

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

        long long sum = 0;
        for (int i = 2; i < 2 + n; i++) {
            sum += b * cnt[i][0] + c * (cnt[i][1] + cnt[i][2]);
        }

        cout << sum;
    }
}
