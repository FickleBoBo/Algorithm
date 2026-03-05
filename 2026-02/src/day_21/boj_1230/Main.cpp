#include <bits/stdc++.h>
using namespace std;

const int INF = 1001;
int match[1001][1001];
int insert[1001][1001];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s1, s2;
    getline(cin, s1);
    getline(cin, s2);

    int n = s1.size();
    int m = s2.size();

    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            match[i][j] = insert[i][j] = INF;
        }
    }

    match[0][0] = 0;
    for (int j = 1; j <= m; j++) {
        insert[0][j] = 1;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (s1[i - 1] == s2[j - 1]) {
                match[i][j] = min(match[i - 1][j - 1], insert[i - 1][j - 1]);
            }
            insert[i][j] = min(match[i][j - 1] + 1, insert[i][j - 1]);
        }
    }

    int res = min(match[n][m], insert[n][m]);
    if (res == INF) {
        cout << -1;
    } else {
        cout << res;
    }
}
