#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int l = 0;
    int r = 0;
    int sum = 0;
    int cnt = 0;
    while (true) {
        if (sum < m) {
            sum += v[r++];
        } else {
            if (sum == m) cnt++;
            sum -= v[l++];
        }

        if (r == n && sum < m) break;
    }

    cout << cnt;
}
