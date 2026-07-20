#include <bits/stdc++.h>
using namespace std;

const int MAX = 2 + 10000 * 10;
const int ROOT = 1;
int unused;
int nxt[MAX][10];
bool chk[MAX];

void init() {
    unused = ROOT + 1;
    memset(nxt, 0, sizeof(nxt));
    memset(chk, 0, sizeof(chk));
}

bool insert(string& s) {
    int cur = ROOT;
    for (char c : s) {
        int idx = c - '0';
        if (nxt[cur][idx] == 0) nxt[cur][idx] = unused++;
        cur = nxt[cur][idx];
        if (chk[cur]) return false;
    }

    if (cur != unused - 1) return false;

    chk[cur] = true;
    return true;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        init();

        int n;
        cin >> n;
        bool flag = true;

        while (n--) {
            string s;
            cin >> s;
            if (!flag) continue;

            if (!insert(s)) flag = false;
        }

        if (flag) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
}
