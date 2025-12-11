#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    // 초기 윈도우의 합 계산
    int sum = 0;
    for (int i = 0; i < k; i++) {
        sum += v[i];
    }

    // 윈도우를 이동하며 최댓값 반복 갱신
    int mx = sum;
    for (int i = 0; i < n - k; i++) {
        sum = sum - v[i] + v[i + k];
        mx = max(mx, sum);
    }

    cout << mx;
}
