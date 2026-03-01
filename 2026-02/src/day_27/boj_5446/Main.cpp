#include <bits/stdc++.h>
using namespace std;

const int MX = 1 + 1000 * 20;
const int ROOT = 0;
int unused;
int nxt[MX][128];
bool chk[MX];
int cnt[MX];    // 해당 노드의 자손 노드(해당 노드 포함) 중 지워야 하는 파일의 수
bool mark[MX];  // 지우면 안되는 파일의 접두어에 해당하는 노드들 체크

void init() {
    unused = ROOT + 1;
    memset(nxt, 0, sizeof(nxt));
    memset(chk, 0, sizeof(chk));
    memset(cnt, 0, sizeof(cnt));
    memset(mark, 0, sizeof(mark));
}

void insert(string& s) {
    int cur = ROOT;
    for (char c : s) {
        if (nxt[cur][c] == 0) nxt[cur][c] = unused++;
        cur = nxt[cur][c];
        cnt[cur]++;
    }
    chk[cur] = true;
}

void check(string& s) {
    int cur = ROOT;
    for (char c : s) {
        if (nxt[cur][c] == 0) return;
        cur = nxt[cur][c];
        mark[cur] = true;
    }
}

int solve(int cur) {
    int sum = chk[cur];
    for (int i = 0; i < 128; i++) {
        if (nxt[cur][i] == 0) continue;

        if (mark[nxt[cur][i]]) {
            sum += solve(nxt[cur][i]);
        } else {
            sum++;
        }
    }
    return sum;
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
        while (n--) {
            string s;
            cin >> s;
            insert(s);
        }

        cin >> n;
        if (n == 0) {
            cout << "1\n";  // rm * 사용
            continue;
        }
        while (n--) {
            string s;
            cin >> s;
            check(s);
        }

        cout << solve(ROOT) << '\n';
    }
}
