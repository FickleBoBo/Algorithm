#include <bits/stdc++.h>
using namespace std;

long long lower_bound_param(long long key) {
    long long left = 0;
    long long right = sqrt(LLONG_MAX) + 1;

    while (left < right) {
        long long mid = (left + right) / 2;

        if (mid * mid < key) {
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

    long long n;
    cin >> n;
    cout << lower_bound_param(n);
}
