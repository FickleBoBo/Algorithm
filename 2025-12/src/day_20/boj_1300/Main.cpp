#include <bits/stdc++.h>
using namespace std;

long long lower_bound_param(long long n, int k) {
    long long left = 1;
    long long right = min(1000000000LL, n * n);

    while (left < right) {
        long long mid = (left + right) / 2;

        long long cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += min(mid / i, n);
        }

        if (cnt < k) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return right;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;
    cout << lower_bound_param(n, k);
}
