#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, x;
    cin >> n >> x;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    // 초기 윈도우의 방문자 수 합 계산
    int sum = 0;
    for (int i = 0; i < x; i++) {
        sum += v[i];
    }

    // 윈도우를 이동하며 최대 방문자수 계산
    int mx = sum;
    int cnt = 1;
    for (int i = 0; i < n - x; i++) {
        sum = sum - v[i] + v[i + x];

        // 이동한 구간의 최대 방문자 수가 더 많으면 최댓값과 개수를 갱신하고 동일하면 개수만 갱신
        if (sum > mx) {
            mx = sum;
            cnt = 1;
        } else if (sum == mx) {
            cnt++;
        }
    }

    if (mx == 0) {
        cout << "SAD";
    } else {
        cout << mx << '\n';
        cout << cnt << '\n';
    }
}
