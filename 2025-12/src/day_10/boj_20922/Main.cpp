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
    int mx = 0;                      // 최대 길이
    vector<int> cntArr(1 + 100000);  // 카운팅 배열

    while (r < n) {
        if (cntArr[v[r]] < k) {
            cntArr[v[r]]++;
            r++;
            mx = max(mx, r - l);
        } else {
            cntArr[v[l]]--;
            l++;
        }
    }

    cout << mx;
}
