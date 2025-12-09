#include <bits/stdc++.h>
using namespace std;

long long lower_bound_param(long long key) {
    long long left = 1;
    long long right = 2000000000;

    while (left < right) {
        long long mid = (left + right) / 2;

        if ((3 * mid * (mid - 1) + 1) < key) {
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
