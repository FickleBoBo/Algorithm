#include <bits/stdc++.h>
using namespace std;

const int MAX = 2 + 500 * 80;
const int ROOT = 1;
int unused = ROOT + 1;
map<string, int> nxt[MAX];

void insert(auto& v) {
    int cur = ROOT;
    for (string& s : v) {
        if (nxt[cur][s] == 0) nxt[cur][s] = unused++;
        cur = nxt[cur][s];
    }
}

void dfs(int cur, int depth) {
    for (auto& [k, v] : nxt[cur]) {
        for (int i = 0; i < depth; i++) {
            cout << " ";
        }
        cout << k << '\n';
        dfs(v, depth + 1);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    cin.ignore();

    while (n--) {
        string line;
        getline(cin, line);

        vector<string> v;
        string s;

        for (char c : line) {
            if (c == '\\') {
                v.push_back(s);
                s.clear();
            } else {
                s += c;
            }
        }
        v.push_back(s);

        insert(v);
    }

    dfs(ROOT, 0);
}
