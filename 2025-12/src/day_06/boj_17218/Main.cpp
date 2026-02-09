#include <bits/stdc++.h>
using namespace std;

int dp[41][41];

string traceback(string& s1, string& s2) {
    string res;

    int r = s1.size() - 1;
    int c = s2.size() - 1;

    while (r >= 0 && c >= 0) {
        if (s1[r] == s2[c]) {
            res.push_back(s1[r]);
            r--;
            c--;
        } else {
            if (dp[r][c + 1] > dp[r + 1][c]) {
                r--;
            } else {
                c--;
            }
        }
    }

    reverse(res.begin(), res.end());
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s1, s2;
    cin >> s1 >> s2;

    int n = s1.size();
    int m = s2.size();

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (s1[i - 1] == s2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    cout << traceback(s1, s2);
}
