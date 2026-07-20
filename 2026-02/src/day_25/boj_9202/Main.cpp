#include <bits/stdc++.h>
using namespace std;

const int MAX = 2 + 300000 * 8;
const int ROOT = 1;
int unused = ROOT + 1;
int nxt[MAX][26];
int chk[MAX];
int mark = 2;

int dr[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
int dc[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
char grid[5][5];
bool vis[5][5];
int score[9] = {0, 0, 0, 1, 1, 2, 3, 5, 11};

int point;       // 최대 점수
string longest;  // 가장 긴 단어
int cnt;         // 찾은 단어의 개수

void insert(string& s) {
    int cur = ROOT;
    for (char c : s) {
        int idx = c - 'A';
        if (nxt[cur][idx] == 0) nxt[cur][idx] = unused++;
        cur = nxt[cur][idx];
    }
    chk[cur] = 1;
}

void find(int r, int c, int cur, string& s) {
    vis[r][c] = true;

    if (0 < chk[cur] && chk[cur] < mark) {
        chk[cur] = mark;

        point += score[s.size()];
        if (s.size() > longest.size() || (s.size() == longest.size() && s < longest)) {
            longest = s;
        }
        cnt++;
    }

    for (int d = 0; d < 8; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;
        if (vis[nr][nc]) continue;

        int idx = grid[nr][nc] - 'A';
        if (nxt[cur][idx] == 0) continue;

        s += grid[nr][nc];
        find(nr, nc, nxt[cur][idx], s);
        s.pop_back();
    }

    vis[r][c] = false;
}

void solve(int r, int c) {
    int idx = grid[r][c] - 'A';
    if (nxt[ROOT][idx] == 0) return;

    string s;
    s += grid[r][c];
    find(r, c, nxt[ROOT][idx], s);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int w;
    cin >> w;
    while (w--) {
        string s;
        cin >> s;
        insert(s);
    }

    int b;
    cin >> b;
    while (b--) {
        for (int i = 0; i < 4; i++) {
            cin >> grid[i];
        }

        point = 0;
        longest = "";
        cnt = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                solve(i, j);
            }
        }

        cout << point << ' ' << longest << ' ' << cnt << '\n';
        mark++;
    }
}
