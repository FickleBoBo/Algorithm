#include <bits/stdc++.h>
using namespace std;

long long upper_bound_param(long long key) {
    long long left = 0;
    long long right = INT_MAX;

    while (left < right) {
        long long mid = (left + right) / 2;

        if (mid * mid <= key) {
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

    long long a, b;
    cin >> a >> b;

    long long cnt = upper_bound_param(b) - upper_bound_param(a);

    if (cnt == 0) {
        cout << 0;
    } else {
        long long g = gcd(cnt, b - a);
        cout << cnt / g << '/' << (b - a) / g;
    }
}
