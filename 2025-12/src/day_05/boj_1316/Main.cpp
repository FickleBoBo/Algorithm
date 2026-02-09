#include <bits/stdc++.h>
using namespace std;

bool visited[26];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    int cnt = 0;

    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;

        memset(visited, 0, sizeof(visited));
        char prev = '\0';
        bool flag = true;

        for (char c : s) {
            if (visited[c - 'a'] && c != prev) {
                flag = false;
                break;
            }

            visited[c - 'a'] = true;
            prev = c;
        }

        if (flag) cnt++;
    }

    cout << cnt;
}
