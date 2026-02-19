#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 4000;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    int sum = 0;
    for (int x : v) sum += x;

    vector<int> cnt(MAX + 1 + MAX);
    for (int x : v) cnt[x + MAX]++;

    int mx = 0;     // 최빈값의 최댓값
    int cntMx = 0;  // 최빈값의 최댓값이 등장한 횟수
    for (int x : cnt) {
        if (x > mx) {
            mx = x;
            cntMx = 1;
        } else if (x == mx) {
            cntMx++;
        }
    }
    cntMx = min(cntMx, 2);

    int mode = 0;  // 최빈값
    for (int i = 0; i < cnt.size(); i++) {
        if (cnt[i] == mx) cntMx--;
        if (cntMx == 0) {
            mode = i - MAX;
            break;
        }
    }

    cout << (int)round((double)sum / n) << '\n';
    cout << v[n / 2] << '\n';
    cout << mode << '\n';
    cout << v[n - 1] - v[0] << '\n';
}
