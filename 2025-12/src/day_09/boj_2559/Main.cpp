#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    vector<int> psum(1 + n);
    for (int i = 1; i <= n; i++) {
        psum[i] = psum[i - 1] + v[i - 1];
    }

    // 누적합의 차로 구간합 계산 및 최댓값 갱신
    int mx = INT_MIN;
    for (int i = 0; i <= n - k; i++) {
        mx = max(mx, psum[i + k] - psum[i]);
    }

    cout << mx;
}
