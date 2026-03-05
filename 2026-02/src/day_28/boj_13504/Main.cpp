#include <bits/stdc++.h>
using namespace std;

const int MX = 1 + 100000 * 32;
const int ROOT = 0;
int unused;
int nxt[MX][2];

void init() {
    unused = ROOT + 1;
    memset(nxt, 0, sizeof(nxt));
}

void insert(int x) {
    int cur = ROOT;
    for (int i = 31; i >= 0; i--) {
        int b = (x >> i) & 1;
        if (nxt[cur][b] == 0) nxt[cur][b] = unused++;
        cur = nxt[cur][b];
    }
}

int find(int x) {
    int cur = ROOT;
    int res = 0;

    for (int i = 31; i >= 0; i--) {
        int b = (x >> i) & 1;
        if (nxt[cur][1 - b]) {
            res |= (1 << i);
            cur = nxt[cur][1 - b];
        } else {
            cur = nxt[cur][b];
        }
    }

    return res;
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

        int mx = 0;
        int pxor = 0;
        insert(pxor);

        while (n--) {
            int x;
            cin >> x;
            pxor ^= x;

            mx = max(mx, find(pxor));
            insert(pxor);
        }

        cout << mx << '\n';
    }
}
