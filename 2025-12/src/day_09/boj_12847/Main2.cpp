#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    for (auto& num : v) cin >> num;

    // 초기 윈도우의 합 계산
    long long sum = 0;
    for (int i = 0; i < m; i++) {
        sum += v[i];
    }

    // 윈도우를 이동하며 최댓값 반복 갱신
    long long mx = sum;
    for (int i = 0; i < n - m; i++) {
        sum = sum - v[i] + v[i + m];
        mx = max(mx, sum);
    }

    cout << mx;
}
