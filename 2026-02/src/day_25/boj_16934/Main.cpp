#include <bits/stdc++.h>
using namespace std;

const int MX = 1 + 100000 * 10;
const int ROOT = 0;
int unused = ROOT + 1;
int nxt[MX][26];
unordered_map<string, int> mp;  // key를 닉네임으로 가입한 유저의 수(value)

void insert(string& s) {
    int cur = ROOT;
    for (char c : s) {
        int idx = c - 'a';
        if (nxt[cur][idx] == 0) nxt[cur][idx] = unused++;
        cur = nxt[cur][idx];
    }
}

string find(string& s) {
    string prefix = "";
    int cur = ROOT;
    for (char c : s) {
        prefix += c;
        int idx = c - 'a';
        if (nxt[cur][idx] == 0) return prefix;
        cur = nxt[cur][idx];
    }

    if (mp[s] > 0) prefix += to_string(mp[s] + 1);
    return prefix;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        string s;
        cin >> s;

        cout << find(s) << '\n';
        insert(s);
        mp[s]++;
    }
}
