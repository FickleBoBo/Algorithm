#include <bits/stdc++.h>
using namespace std;

const int MX = 4000;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    int sum = 0;
    for (int x : v) sum += x;

    vector<int> cnt(MX + 1 + MX);
    for (int x : v) cnt[x + MX]++;

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
            mode = i - MX;
            break;
        }
    }

    cout << (int)round((double)sum / n) << '\n';
    cout << v[n / 2] << '\n';
    cout << mode << '\n';
    cout << v[n - 1] - v[0] << '\n';
}
