#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<pair<int, int>> input(n);  // 양동이의 얼음의 양과 좌표를 임시 저장
    for (auto& [a, b] : input) cin >> b >> a;
    sort(input.begin(), input.end());  // 양동이의 좌표를 기준으로 정렬

    int l = 0;
    int r = 0;
    int sum = 0;
    int mx = 0;
    while (r < n) {
        // 더 잡을 수 있으면 오른쪽 포인터를 이동하며 더 잡을 수 없으면 왼쪽 포인터를 이동
        if (input[r].first - input[l].first > (2 * k + 1)) {
            sum -= input[l++].second;
        } else {
            sum += input[r++].second;
            mx = max(mx, sum);
        }
    }

    cout << mx;
}
