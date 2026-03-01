#include <bits/stdc++.h>
using namespace std;

const int MX = 1 + 10000 * 500;
const int ROOT = 0;
int unused = ROOT + 1;
int nxt[MX][26];

void insert(string& s) {
    int cur = ROOT;
    for (char c : s) {
        int idx = c - 'a';
        if (nxt[cur][idx] == 0) nxt[cur][idx] = unused++;
        cur = nxt[cur][idx];
    }
}

bool find(string& s) {
    int cur = ROOT;
    for (char c : s) {
        int idx = c - 'a';
        if (nxt[cur][idx] == 0) return false;
        cur = nxt[cur][idx];
    }
    return true;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    while (n--) {
        string s;
        cin >> s;
        insert(s);
    }

    int cnt = 0;
    while (m--) {
        string s;
        cin >> s;
        if (find(s)) cnt++;
    }

    cout << cnt;
}
