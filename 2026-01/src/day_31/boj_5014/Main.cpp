#include <bits/stdc++.h>
using namespace std;

int f, s, g, u, d;

int bfs() {
    queue<int> q;
    q.push(s);

    vector<bool> vis(1 + f);
    vis[s] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int cur = q.front();
            q.pop();

            if (cur == g) return dist;

            int up = cur + u;
            if (up <= f && !vis[up]) {
                q.push(up);
                vis[up] = true;
            }

            int down = cur - d;
            if (down >= 1 && !vis[down]) {
                q.push(down);
                vis[down] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> f >> s >> g >> u >> d;

    int dist = bfs();
    if (dist == -1) {
        cout << "use the stairs";
    } else {
        cout << dist;
    }
}
