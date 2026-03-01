#include <bits/stdc++.h>
using namespace std;

const int MX = 1 + 1000000;
const int ROOT = 0;
int unused;
int nxt[MX][26];
bool chk[MX];
int cnt[MX];  // 자식 노드의 수
int sum;

void init() {
    unused = ROOT + 1;
    memset(nxt, 0, sizeof(nxt));
    memset(chk, 0, sizeof(chk));
    memset(cnt, 0, sizeof(cnt));
    sum = 0;
}

void insert(string& s) {
    int cur = ROOT;
    for (char c : s) {
        int idx = c - 'a';
        if (nxt[cur][idx] == 0) {
            nxt[cur][idx] = unused++;
            cnt[cur]++;
        }
        cur = nxt[cur][idx];
    }
    chk[cur] = true;
}

void solve(int cur, int value) {
    if (chk[cur]) {
        sum += value;
    }

    for (int i = 0; i < 26; i++) {
        if (nxt[cur][i] == 0) continue;

        if (cur == ROOT || chk[cur] || cnt[cur] > 1) {
            solve(nxt[cur][i], value + 1);
        } else {
            solve(nxt[cur][i], value);
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    while (cin >> n) {
        init();

        for (int i = 0; i < n; i++) {
            string s;
            cin >> s;
            insert(s);
        }

        solve(ROOT, 0);
        cout << fixed << setprecision(2) << (double)sum / n << '\n';
    }
}
