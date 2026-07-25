#include <bits/stdc++.h>
using namespace std;

const int MAX = 2 + 100000 * 32;
const int ROOT = 1;
int unused = ROOT + 1;
int nxt[MAX][2];
int chk[MAX];

void insert(int x) {
    int cur = ROOT;
    for (int i = 31; i >= 0; i--) {
        int b = (x >> i) & 1;
        if (nxt[cur][b] == 0) nxt[cur][b] = unused++;
        cur = nxt[cur][b];
        chk[cur]++;
    }
}

long long find(int x, int k) {
    int cur = ROOT;
    long long cnt = 0;

    for (int i = 31; i >= 0; i--) {
        int xb = (x >> i) & 1;
        int kb = (k >> i) & 1;

        if (kb == 1) {
            if (nxt[cur][xb]) cnt += chk[nxt[cur][xb]];
            cur = nxt[cur][1 - xb];
        } else {
            cur = nxt[cur][xb];
        }

        if (cur == 0) break;
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    int pxor = 0;
    insert(pxor);
    long long cnt = 0;

    while (n--) {
        int x;
        cin >> x;
        pxor ^= x;

        cnt += find(pxor, k);
        insert(pxor);
    }

    cout << cnt;
}
