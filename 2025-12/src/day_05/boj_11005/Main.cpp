#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, b;
    cin >> n >> b;

    string digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    string ans;

    while (n > 0) {
        ans += digits[n % b];
        n /= b;
    }
    reverse(ans.begin(), ans.end());

    cout << ans;
}
