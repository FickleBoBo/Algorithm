#include <bits/stdc++.h>
using namespace std;

const int MX = 100000;
int dist[1 + MX];
int ways[1 + MX];

void bfs(int n, int k) {
    queue<int> q;
    q.push(n);

    memset(dist, -1, sizeof(dist));
    dist[n] = 0;

    ways[n] = 1;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (int nxt : {cur - 1, cur + 1, cur * 2}) {
            if (0 <= nxt && nxt <= MX) {
                if (dist[nxt] == -1) {
                    q.push(nxt);
                    dist[nxt] = dist[cur] + 1;
                    ways[nxt] = ways[cur];
                } else if (dist[nxt] == dist[cur] + 1) {
                    ways[nxt] += ways[cur];
                }
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    bfs(n, k);

    cout << dist[k] << '\n';
    cout << ways[k] << '\n';
}
