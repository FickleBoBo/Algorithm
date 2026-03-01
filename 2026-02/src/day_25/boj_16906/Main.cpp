#include <bits/stdc++.h>
using namespace std;

const int MX = 1 + 1000;
const int ROOT = 0;
int unused = ROOT + 1;
int nxt[MX][2];
bool chk[MX];

vector<string> v;  // 욱제어를 저장한 벡터
bool success;      // 욱제어 삽입 성공 여부

void insert(int cur, int l, string& s) {
    if (chk[cur]) return;

    if (s.size() == l) {
        if (cur != unused - 1) return;

        chk[cur] = true;
        v.push_back(s);
        success = true;
        return;
    }

    for (int i = 0; i < 2; i++) {
        if (nxt[cur][i] == 0) nxt[cur][i] = unused++;
        s += '0' + i;
        insert(nxt[cur][i], l, s);
        s.pop_back();

        if (success) return;  // 0으로 끝나는 욱제어 삽입 성공시 1로 끝나는 노드 삽입 방지
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;

        string s;
        success = false;

        insert(ROOT, x, s);
        if (success) continue;

        cout << -1;
        return 0;
    }

    cout << "1\n";
    for (string& x : v) {
        cout << x << '\n';
    }
}
