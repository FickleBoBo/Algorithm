#include <bits/stdc++.h>
using namespace std;

const int MAX = 100;
string dp[1 + MAX] = {"", "", "1", "7", "4", "2", "6", "8"};

string findMin(string& a, string& b) {
    if (a.size() != b.size()) return a.size() > b.size() ? b : a;
    return a > b ? b : a;
}

string findMax(int n) {
    if (n % 2) return "7" + string((n - 3) / 2, '1');
    return string(n / 2, '1');
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 8; i <= MAX; i++) {
        for (int j = 2; j <= 7; j++) {
            if (dp[i - j].empty()) continue;

            string tmp = dp[i - j];
            if (j != 6) {
                tmp += dp[j];
            } else {
                tmp += "0";
            }

            if (dp[i].empty()) {
                dp[i] = tmp;
            } else {
                dp[i] = findMin(dp[i], tmp);
            }
        }
    }

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;
        cout << dp[n] << ' ' << findMax(n) << '\n';
    }
}
