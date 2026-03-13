#include <bits/stdc++.h>
using namespace std;

bool vis[26];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    int cnt = 0;

    while (n--) {
        string s;
        cin >> s;

        memset(vis, 0, sizeof(vis));
        char prv = '\0';
        bool flag = true;

        for (char c : s) {
            if (vis[c - 'a'] && c != prv) {
                flag = false;
                break;
            }

            vis[c - 'a'] = true;
            prv = c;
        }

        if (flag) cnt++;
    }

    cout << cnt;
}
