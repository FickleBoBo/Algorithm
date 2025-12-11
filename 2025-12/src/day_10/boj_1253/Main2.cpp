#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    int cnt = 0;
    for (int i = 0; i < n; i++) {
        int l = 0;
        int r = n - 1;

        while (l < r) {
            // 왼쪽 포인터가 i면 넘어감
            if (l == i) {
                l++;
                continue;
            }

            // 오른쪽 포인터가 i면 넘어감
            if (r == i) {
                r--;
                continue;
            }

            if (v[l] + v[r] > v[i]) {
                r--;
            } else if (v[l] + v[r] < v[i]) {
                l++;
            } else {
                cnt++;
                break;
            }
        }
    }

    cout << cnt;
}
