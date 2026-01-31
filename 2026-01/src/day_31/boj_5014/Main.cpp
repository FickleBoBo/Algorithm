#include <bits/stdc++.h>
using namespace std;

int bfs(int f, int s, int g, int u, int d) {
    queue<int> q;
    q.push(s);

    vector<bool> visited(1 + f);
    visited[s] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int node = q.front();
            q.pop();

            if (node == g) return dist;

            int up = node + u;
            if (up <= f && !visited[up]) {
                q.push(up);
                visited[up] = true;
            }

            int down = node - d;
            if (down >= 1 && !visited[down]) {
                q.push(down);
                visited[down] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int f, s, g, u, d;
    cin >> f >> s >> g >> u >> d;

    int res = bfs(f, s, g, u, d);
    if (res == -1) {
        cout << "use the stairs";
    } else {
        cout << res;
    }
}
