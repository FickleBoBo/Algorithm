#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<vector<int>> adj(1 + 500);
bool visited[1 + 500];

int bfs() {
    queue<int> q;
    q.push(1);

    visited[1] = true;

    int dist = 0;
    int cnt = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int node = q.front();
            q.pop();

            for (int next : adj[node]) {
                if (visited[next]) continue;

                q.push(next);
                visited[next] = true;
                cnt++;
            }
        }

        dist++;
        if (dist == 2) break;
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    int cnt = bfs();
    cout << cnt;
}
