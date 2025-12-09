#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<int> v(n);
    for (auto& num : v) cin >> num;

    // 초기 윈도우의 합 계산
    int sum = 0;
    for (int i = 0; i < k; i++) {
        sum += v[i];
    }

    // 원형으로 윈도우 이동 및 최댓값 갱신
    int mx = sum;
    for (int i = 0; i < n; i++) {
        sum = sum - v[i] + v[(i + k) % n];
        mx = max(mx, sum);
    }

    cout << mx;
}
