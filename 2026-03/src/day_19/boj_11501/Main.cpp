#include <bits/stdc++.h>
using namespace std;

int arr[1000000];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        for (int i = 0; i < n; i++) cin >> arr[i];

        long long ans = 0;
        int mx = 0;
        for (int i = n - 1; i >= 0; i--) {
            mx = max(mx, arr[i]);
            ans += mx - arr[i];
        }

        cout << ans << '\n';
    }
}
