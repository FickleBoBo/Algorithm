#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 100000;
int dist[1 + MAX];
int ways[1 + MAX];

void bfs(int n, int k) {
    queue<int> q;
    q.push(n);

    fill(dist, dist + MAX + 1, -1);
    dist[n] = 0;

    ways[n] = 1;

    while (!q.empty()) {
        int node = q.front();
        q.pop();

        int next1 = node - 1;
        if (next1 >= 0) {
            if (dist[next1] == -1) {
                q.push(next1);
                dist[next1] = dist[node] + 1;
                ways[next1] = ways[node];
            } else if (dist[next1] == dist[node] + 1) {
                ways[next1] += ways[node];
            }
        }

        int next2 = node + 1;
        if (next2 <= MAX) {
            if (dist[next2] == -1) {
                q.push(next2);
                dist[next2] = dist[node] + 1;
                ways[next2] = ways[node];
            } else if (dist[next2] == dist[node] + 1) {
                ways[next2] += ways[node];
            }
        }

        int next3 = node * 2;
        if (next3 <= MAX) {
            if (dist[next3] == -1) {
                q.push(next3);
                dist[next3] = dist[node] + 1;
                ways[next3] = ways[node];
            } else if (dist[next3] == dist[node] + 1) {
                ways[next3] += ways[node];
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    bfs(n, k);

    cout << dist[k] << '\n';
    cout << ways[k] << '\n';
}
