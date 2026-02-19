#include <bits/stdc++.h>
using namespace std;

int cnt[100001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int l = 0;
    int r = 0;
    int mx = 0;  // 최대 길이

    while (r < n) {
        if (cnt[v[r]] < k) {
            cnt[v[r]]++;
            r++;
            mx = max(mx, r - l);
        } else {
            cnt[v[l]]--;
            l++;
        }
    }

    cout << mx;
}
