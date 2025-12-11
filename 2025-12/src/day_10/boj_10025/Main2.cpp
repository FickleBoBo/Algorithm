#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<pair<int, int>> input(n);  // 양동이의 얼음의 양과 좌표를 임시 저장
    int maxLen = 0;                   // 양동이의 좌표의 최댓값
    for (auto& p : input) {
        cin >> p.first >> p.second;
        maxLen = max(maxLen, p.second);
    }

    // 인덱스에 양동이의 좌표, 값에 양동이의 얼음의 양 저장
    vector<int> v(1 + maxLen);
    for (auto p : input) {
        v[p.second] = p.first;
    }

    // 윈도우의 크기
    int sz = 2 * k + 1;

    // 윈도우가 좌표의 최댓값보다 크면 모든 양동이에 닿을 수 있으므로 모든 양동이의 얼음의 합을 출력하고 리턴
    if (sz > maxLen) {
        int sum = 0;
        for (int x : v) {
            sum += x;
        }
        cout << sum;
        return 0;
    }

    // 초기 윈도우 내 얼음의 합 계산
    int sum = 0;
    for (int i = 0; i < sz; i++) {
        sum += v[i];
    }

    // 윈도우를 이동하며 얼음의 합의 최댓값 계산
    int mx = sum;
    for (int i = 0; i <= maxLen - sz; i++) {
        sum = sum - v[i] + v[i + sz];
        mx = max(mx, sum);
    }

    cout << mx;
}
