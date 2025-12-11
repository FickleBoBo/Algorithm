#include <bits/stdc++.h>
using namespace std;

long long upper_bound_param(const vector<int>& v, int key) {
    long long left = 1;
    long long right = INT_MAX + 1LL;  // 랜선의 길이가 최대 2^31-1까지라서 right의 상한을 2^31로 설정

    while (left < right) {
        long long mid = (left + right) / 2;

        long long cnt = 0;
        for (int n : v) {
            cnt += n / mid;
        }

        if (cnt >= key) {
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

    int k, n;
    cin >> k >> n;

    vector<int> v(k);
    for (int& x : v) cin >> x;

    cout << upper_bound_param(v, n) - 1;
}
