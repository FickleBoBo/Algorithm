#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int l = 0;
    int r = 0;
    int cnt = 0;       // 구간 내 라이언 인형의 개수
    int mn = INT_MAX;  // 조건을 만족하는 구간의 길이의 최솟값

    while (true) {
        if (cnt < k) {
            if (v[r++] == 1) cnt++;
        } else {
            if (cnt == k) mn = min(mn, r - l);

            if (v[l++] == 1) cnt--;
        }

        if (r == n && cnt < k) break;
    }

    if (mn == INT_MAX) {
        cout << -1;
    } else {
        cout << mn;
    }
}
