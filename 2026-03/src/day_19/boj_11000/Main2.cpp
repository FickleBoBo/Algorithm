#include <bits/stdc++.h>
using namespace std;

pair<int, int> arr[200000 * 2];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    int idx = 0;
    for (int i = 0; i < n; i++) {
        int s, t;
        cin >> s >> t;
        arr[idx++] = {s, 1};
        arr[idx++] = {t, -1};
    }
    sort(arr, arr + n * 2);

    int mx = 0;
    int cnt = 0;
    for (int i = 0; i < n * 2; i++) {
        cnt += arr[i].second;
        mx = max(mx, cnt);
    }

    cout << mx;
}
