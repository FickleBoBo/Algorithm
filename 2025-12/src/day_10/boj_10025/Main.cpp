#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<pair<int, int>> input(n);  // 양동이의 얼음의 양과 좌표를 임시 저장
    int maxLen = 0;                   // 양동이의 좌표의 최댓값
    for (auto& [a, b] : input) {
        cin >> a >> b;
        maxLen = max(maxLen, b);
    }

    // 인덱스에 양동이의 좌표, 값에 양동이의 얼음의 양 저장
    vector<int> v(1 + maxLen);
    for (auto [a, b] : input) {
        v[b] = a;
    }

    // 누적합 배열 계산
    vector<int> psum(1 + maxLen);
    psum[0] = v[0];
    for (int i = 1; i <= maxLen; i++) {
        psum[i] = psum[i - 1] + v[i];
    }

    // 닿을 수 있는 범위
    int sz = 2 * k + 1;

    // 모든 양동이에 닿을 수 있으면 모든 양동이의 얼음의 양의 합을 출력하고 리턴
    if (sz > maxLen) {
        cout << psum[maxLen];
        return 0;
    }

    // 누적합 배열에서 구간을 이동하며 최댓값 계산
    int mx = 0;
    for (int i = 0; i <= maxLen - sz; i++) {
        mx = max(mx, psum[i + sz] - psum[i]);
    }

    cout << mx;
}
