#include <bits/stdc++.h>
using namespace std;

const int MX = 1 + 200000 * 32;
const int ROOT = 0;
int unused = ROOT + 1;
int nxt[MX][2];
int cnt[MX];

void insert(int x) {
    int cur = ROOT;
    for (int i = 31; i >= 0; i--) {
        int b = (x >> i) & 1;
        if (nxt[cur][b] == 0) nxt[cur][b] = unused++;
        cur = nxt[cur][b];
        cnt[cur]++;
    }
}

int find(int x) {
    int cur = ROOT;
    int res = 0;

    for (int i = 31; i >= 0; i--) {
        int b = (x >> i) & 1;
        if (nxt[cur][1 - b] && cnt[nxt[cur][1 - b]] > 0) {
            res |= (1 << i);
            cur = nxt[cur][1 - b];
        } else {
            cur = nxt[cur][b];
        }
    }

    return res;
}

void erase(int x) {
    int cur = ROOT;
    for (int i = 31; i >= 0; i--) {
        int b = (x >> i) & 1;
        cur = nxt[cur][b];
        cnt[cur]--;
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int m;
    cin >> m;

    insert(0);
    while (m--) {
        int q, x;
        cin >> q >> x;

        if (q == 1) {
            insert(x);
        } else if (q == 2) {
            erase(x);
        } else {
            cout << find(x) << '\n';
        }
    }
}
